package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume resume) {
        Object key = searchKeyExist(resume.getUuid());
        updateElement(key, resume);
    }

    public void save(Resume resume) {
        Object key = searchKeyNotExist(resume.getUuid());
        saveElement(resume, key);
    }

    public Resume get(String uuid) {
        Object key = searchKeyExist(uuid);
        return getElement(key);
    }

    public void delete(String uuid) {
        Object key = searchKeyExist(uuid);
        deleteElement(key);
    }

    protected Object searchKeyNotExist(String uuid) {
        Object key = getKey(uuid);
        checkKeyNotExist(key, uuid);
        return key;
    }

    protected Object searchKeyExist(String uuid) {
        Object key = getKey(uuid);
        checkKeyExist(key, uuid);
        return key;
    }

    protected abstract Object getKey(String uuid);

    protected abstract void checkKeyNotExist(Object key, String uuid);

    protected abstract void checkKeyExist(Object key, String uuid);

    protected abstract void updateElement(Object index, Resume resume);

    protected abstract void saveElement(Resume resume, Object index);

    protected abstract Resume getElement(Object index);

    protected abstract void deleteElement(Object index);

}
