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

    void save(Resume r) {
       if (sizeStorage < storage.length) {
        storage [sizeStorage] = r;
        sizeStorage++;
       }
    }


    Resume get(String uuid) {
        for (int r = 0; r < sizeStorage; r++) {
            if (storage[r].uuid.equals(uuid)) {
                return storage[r];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int r = 0; r < sizeStorage; r++) {
            if (storage[r].uuid.equals(uuid)) {
                System.arraycopy(storage, r+1, storage, r, storage.length-r-1);
                storage[sizeStorage-1] = null;
                sizeStorage--;
                break;
            }
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
}

