package storage;

import model.Resume;

import java.util.Arrays;

/**
 * Sorted array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int sizeStorage = 0;

    public void clear() {
        Arrays.fill(storage,0, sizeStorage, null);
        sizeStorage = 0;
    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            System.out.println("Резюме с таким uuid уже существует");
        } else if (sizeStorage > STORAGE_LIMIT) {
            System.out.println("Недостаточно места для сохранения");
        }
        else {
            insertResume(r, index);
            sizeStorage++;
        }
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            storage[index] = r;
        }
        else {
            System.out.println("Резюме с таким uuid нет в базе");
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Резюме с таким uuid нет в базе");
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            deleteResume(index);
            storage[sizeStorage - 1] = null;
            sizeStorage--;
        }
        else {
            System.out.println("Резюме с таким uuid нет в базе");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, sizeStorage);
    }

    public int size() {
        return sizeStorage;
    }

    protected abstract int getIndex(String uuid);

    protected abstract void insertResume(Resume resume, int index);

    protected abstract void deleteResume(int index);

}
