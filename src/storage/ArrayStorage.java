package storage;

import model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    protected int getIndex (String uuid) {
        for (int resume = 0; resume < sizeStorage; resume++) {
            if (storage[resume].getUuid().equals(uuid)) {
                return resume;
            }
        }
        return -1;
    }

    @Override
    protected void insertResume(Resume resume, int index) {
        storage[sizeStorage] = resume;
    }

    @Override
    protected void deleteResume(int index) {
        storage[index] = storage[sizeStorage - 1];
    }

}
