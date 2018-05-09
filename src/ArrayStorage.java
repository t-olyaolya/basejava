import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage,null);
    }

    void save(Resume r) {
        storage[Arrays.asList(storage).indexOf(null)] = r;

    }


    Resume get(String uuid) {
        for (int r = 0; r < Arrays.asList(storage).indexOf(null); r++) {
            if (storage[r].toString() == uuid) {
                return storage[r];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int r = 0; r < Arrays.asList(storage).indexOf(null); r++) {
            if (storage[r].uuid.equals(uuid)) {
                System.arraycopy(storage, r+1, storage, r, storage.length-r-1);
            }
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, Arrays.asList(storage).indexOf(null));
    }

    int size() {
        return Arrays.asList(storage).indexOf(null);
    }
}
