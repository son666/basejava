package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume resume) {
        Object searchKey = searchKeyExist(resume.getUuid());
        updateElement(searchKey, resume);
    }

    public void save(Resume resume) {
        Object searchKey = searchKeyNotExist(resume.getUuid());
        saveElement(resume, searchKey);
    }

    public Resume get(String uuid) {
        Object searchKey = searchKeyExist(uuid);
        return getElement(searchKey);
    }

    public void delete(String uuid) {
        Object searchKey = searchKeyExist(uuid);
        deleteElement(searchKey);
    }

    protected Object searchKeyNotExist(String uuid) {
        Object searchKey = getKey(uuid);
        if (isKeyNotExist(searchKey, uuid)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    protected Object searchKeyExist(String uuid) {
        Object searchKey = getKey(uuid);
        if (isKeyExist(searchKey, uuid)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    protected abstract Object getKey(String uuid);

    protected abstract boolean isKeyNotExist(Object searchKey, String uuid);

    protected abstract boolean isKeyExist(Object searchKey, String uuid);

    protected abstract void updateElement(Object index, Resume resume);

    protected abstract void saveElement(Resume resume, Object index);

    protected abstract Resume getElement(Object index);

    protected abstract void deleteElement(Object index);

}
