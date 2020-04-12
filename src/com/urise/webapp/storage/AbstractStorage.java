package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Collections;
import java.util.List;

public abstract class AbstractStorage implements Storage {

    protected abstract Object getSearchKey(String uuid);

    protected abstract List<Resume> getCopyAllElement();

    protected abstract boolean isExist(Object searchKey);

    protected abstract void updateElement(Object searchKey, Resume resume);

    protected abstract void saveElement(Resume resume, Object searchKey);

    protected abstract Resume getElement(Object searchKey);

    protected abstract void deleteElement(Object searchKey);

    public void update(Resume resume) {
        Object searchKey = getExistedSearchKey(resume.getUuid());
        updateElement(searchKey, resume);
    }

    public void save(Resume resume) {
        Object searchKey = getNotExistedSearchKey(resume.getUuid());
        saveElement(resume, searchKey);
    }

    public Resume get(String uuid) {
        Object searchKey = getExistedSearchKey(uuid);
        return getElement(searchKey);
    }

    public List<Resume> getAllSorted() {
        List<Resume> listResume = getCopyAllElement();
        Collections.sort(listResume);
        return listResume;
    }

    public void delete(String uuid) {
        Object searchKey = getExistedSearchKey(uuid);
        deleteElement(searchKey);
    }

    private Object getExistedSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object getNotExistedSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

}