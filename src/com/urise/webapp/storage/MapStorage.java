package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> mapResume = new HashMap<>();

    @Override
    protected String getIndex(String uuid) {
        if (!mapResume.containsKey(uuid)) {
            return null;
        }
        return mapResume.get(uuid).getUuid();
    }

    @Override
    protected void updateElement(Object index, Resume resume) {
        mapResume.put(resume.getUuid(), resume);
    }

    @Override
    protected void saveElement(Resume resume, Object index) {
        mapResume.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getElement(Object index) {
        String uuid = (String) index;
        return mapResume.get(uuid);
    }

    @Override
    protected void deleteElement(Object index) {
        String uuid = (String) index;
        mapResume.remove(uuid);
    }

    @Override
    public void clear() {
        mapResume.clear();
    }

    @Override
    public Resume[] getAll() {
        Resume[] resumes = mapResume.values().toArray(new Resume[0]);
        Arrays.sort(resumes);
        return resumes;
    }

    @Override
    public int size() {
        return mapResume.size();
    }

    @Override
    protected String getIndexNotExist(String uuid) {
        String index = getIndex(uuid);
        if (index == null) {
            throw new NotExistStorageException(uuid);
        }
        return index;
    }

    @Override
    protected String getIndexExist(String uuid) {
        String index = getIndex(uuid);
        if (index != null) {
            throw new ExistStorageException(uuid);
        }
        return index;
    }
}
