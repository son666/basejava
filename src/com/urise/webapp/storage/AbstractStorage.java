package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        checkIndexNotExist(index, resume.getUuid());
        updateElement(index, resume);
    }

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        checkIndexExist(index, resume.getUuid());
        saveElement(resume, index);
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        checkIndexNotExist(index, uuid);
        return getElement(index);
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        checkIndexNotExist(index, uuid);
        deleteElement(index);
    }

    private void checkIndexNotExist(int index, String uuid) {
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
    }
    private void checkIndexExist(int index, String uuid) {
        if (index >= 0) {
            throw new ExistStorageException(uuid);
        }
    }

    protected abstract int getIndex(String uuid);

    protected abstract void updateElement(int index, Resume resume);

    protected abstract void saveElement(Resume resume, int index);

    protected abstract Resume getElement(int index);

    protected abstract void deleteElement(int index);

}
