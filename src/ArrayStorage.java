import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int sizeStorage = 0;


    void clear() {
        Arrays.fill(storage,null);
    }

    void save(Resume r) {
       storage [size()] = r;
    }


    Resume get(String uuid) {
        sizeStorage = size();
        for (int r = 0; r < sizeStorage - 1; r++) {
            if (storage[r].uuid.equals(uuid)) {
                return storage[r];
            }
        }
        return null;
    }

    void delete(String uuid) {
        sizeStorage = size();
        for (int r = 0; r < sizeStorage - 1; r++) {
            if (storage[r].uuid.equals(uuid)) {
                System.arraycopy(storage, r+1, storage, r, storage.length-r-1);
            }
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size());
    }

    int size() {
        int index = 0;
        int length = storage.length;
        for (int i = 0; i <= length; i++) {
            if (storage [i] == null) {
                index = i;
                break;
            }
        }
        return index;
    }
}
