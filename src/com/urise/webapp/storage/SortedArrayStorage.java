package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insertElement(Resume resume, int index) {
        index = -index - 1;
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = resume;
    }

    @Override
    protected void deleteElement(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
    }

    @Override
    protected int getIndex(String uuid) {
        Resume resume = new Resume();
        resume.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, resume);
    }
}
