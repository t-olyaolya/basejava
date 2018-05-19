import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int sizeStorage = 0;

    public void clear() {
        Arrays.fill(storage,0, sizeStorage, null);
        sizeStorage = 0;
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index != -1) {
            storage[index] = r;
        }
        else {
            System.out.println("Резюме с таким uuid нет в базе");
        }
    }

    public void save(Resume r) {
       if (getIndex(r.getUuid()) != -1) {
           System.out.println("Резюме с таким uuid уже существует");
       } else if (sizeStorage > storage.length) {
           System.out.println("Недостаточно места для сохранения");
       }
       else {
           storage[sizeStorage] = r;
           sizeStorage++;
       }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Резюме с таким uuid нет в базе");
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            storage[index] = storage[sizeStorage - 1];
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

    private int getIndex (String uuid) {
        for (int resume = 0; resume < sizeStorage; resume++) {
            if (storage[resume].getUuid().equals(uuid)) {
                return resume;
            }
        }
        return -1;
    }
}
