package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected void updateElement(Object index, Resume resume) {
        storage[(Integer) index] = resume;

    }

    @Override
    protected void saveElement(Resume resume, Object index) {
        if (size == storage.length) {
            throw new StorageException("В хранилище нет места!", resume.getUuid());
        } else {
            insertElement(resume, (Integer) index);
            size++;
        }
    }

    @Override
    protected Resume getElement(Object index) {
        return storage[(Integer) index];
    }

    @Override
    protected void deleteElement(Object index) {
        deleteResume((Integer) index);
        storage[size - 1] = null;
        size--;
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    protected abstract void insertElement(Resume resume, int index);

    protected abstract void deleteResume(int index);

    @Override
    protected boolean isKeyNotExist(Object searchKey, String uuid) {
        return (Integer) searchKey >= 0;
    }

    @Override
    protected boolean isKeyExist(Object searchKey, String uuid) {
        return (Integer) searchKey < 0;
    }


}
