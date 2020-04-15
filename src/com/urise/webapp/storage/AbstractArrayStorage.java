package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    protected abstract void insertElement(Resume resume, int index);

    protected abstract void deleteResume(int index);

    protected abstract Integer getSearchKey(String uuid);

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected void updateElement(Integer index, Resume resume) {
        storage[index] = resume;

    }

    @Override
    protected void saveElement(Resume resume, Integer index) {
        if (size == storage.length) {
            throw new StorageException("В хранилище нет места!", resume.getUuid());
        } else {
            insertElement(resume, index);
            size++;
        }
    }

    @Override
    protected Resume getElement(Integer index) {
        return storage[index];
    }

    @Override
    protected void deleteElement(Integer index) {
        deleteResume(index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    public List<Resume> getCopyAllElement() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, size));
    }

    @Override
    protected boolean isExist(Integer index) {
        return index >= 0;
    }


    public int size() {
        return size;
    }

}
