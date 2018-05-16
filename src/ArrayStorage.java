import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int sizeStorage = 0;

    void clear() {
        Arrays.fill(storage,null);
        sizeStorage = 0;
    }

    void update(Resume r) {
        int i = searchResume(r.uuid);
        if (i != -1) {
            storage[i] = r;
        }
        else {
            System.out.println("Резюме с таким uuid нет в базе");
        }
    }

    void save(Resume r) {
       if (searchResume(r.uuid) != -1) {
           System.out.println("Резюме с таким uuid уже существует");
       }
       else if (sizeStorage > storage.length) {
           System.out.println("Недостаточно места для сохранения");
       }
       else {
           storage[sizeStorage] = r;
           sizeStorage++;
       }
    }

    Resume get(String uuid) {
        int i = searchResume(uuid);
        if (i == -1) {
            System.out.println("Резюме с таким uuid нет в базе");
            return null;
        }
        return storage[i];
    }

    void delete(String uuid) {
        int i = searchResume(uuid);
        if (i != -1) {
            System.arraycopy(storage, i+1, storage, i, storage.length-i-1);
            storage[sizeStorage-1] = null;
            sizeStorage--;
        }
        else {
            System.out.println("Резюме с таким uuid нет в базе");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, sizeStorage);
    }

    int size() {
        return sizeStorage;
    }

    int searchResume (String uuid) {
        for (int r = 0; r < sizeStorage; r++) {
            if (storage[r].uuid.equals(uuid)) {
                return r;
            }
        }
        return -1;
    }
}
