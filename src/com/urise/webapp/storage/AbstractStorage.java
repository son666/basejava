package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume resume) {
        int index = getIndexNotExist(resume.getUuid());;
        updateElement(index, resume);
    }

    public void save(Resume resume) {
        int index = getIndexExist(resume.getUuid());
        saveElement(resume, index);
    }

    public Resume get(String uuid) {
        int index = getIndexNotExist(uuid);
        return getElement(index);
    }

    public void delete(String uuid) {
        int index = getIndexNotExist(uuid);
        deleteElement(index);
    }

    private int getIndexNotExist(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return index;
    }
    private int getIndexExist(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            throw new ExistStorageException(uuid);
        }
        return index;
    }

    protected abstract int getIndex(String uuid);

    protected abstract void updateElement(int index, Resume resume);

    protected abstract void saveElement(Resume resume, int index);

    protected abstract Resume getElement(int index);

    protected abstract void deleteElement(int index);

}
