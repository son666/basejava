package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume resume) {
        Object index = getIndexNotExist(resume.getUuid());
        updateElement(index, resume);
    }

    public void save(Resume resume) {
        Object index = getIndexExist(resume.getUuid());
        saveElement(resume, index);
    }

    public Resume get(String uuid) {
        Object index = getIndexNotExist(uuid);
        return getElement(index);
    }

    public void delete(String uuid) {
        Object index = getIndexNotExist(uuid);
        deleteElement(index);
    }

    protected Object getIndexNotExist(String uuid) {
        Object index = getIndex(uuid);
        if ((Integer) index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return index;
    }

    protected Object getIndexExist(String uuid) {
        Object index = getIndex(uuid);
        if ((Integer) index >= 0) {
            throw new ExistStorageException(uuid);
        }
        return index;
    }

    protected abstract Object getIndex(String uuid);

    protected abstract void updateElement(Object index, Resume resume);

    protected abstract void saveElement(Resume resume, Object index);

    protected abstract Resume getElement(Object index);

    protected abstract void deleteElement(Object index);

}
