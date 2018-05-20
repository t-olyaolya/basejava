package storage;

import model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, sizeStorage, searchKey);
    }

    @Override
    protected void insertResume(Resume resume, int index) {
        int insertIndex = -index - 1;
        System.arraycopy(storage, insertIndex, storage, insertIndex + 1, sizeStorage - insertIndex);
        storage[insertIndex] = resume;
    }

    @Override
    protected void deleteResume(int index) {
        int elements = sizeStorage - index - 1;
        if (elements > 0) {
            System.arraycopy(storage, index + 1, storage, index, elements);
        }
    }
}
