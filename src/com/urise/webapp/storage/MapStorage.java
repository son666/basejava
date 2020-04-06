package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> mapResume = new HashMap<>();

    @Override
    protected String getSearchKey(String uuid) {
        if (!mapResume.containsKey(uuid)) {
            return null;
        }
        return mapResume.get(uuid).getUuid();
    }

    @Override
    protected void updateElement(Object key, Resume resume) {
        mapResume.put(resume.getUuid(), resume);
    }

    @Override
    protected void saveElement(Resume resume, Object key) {
        mapResume.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getElement(Object key) {
        String uuid = (String) key;
        return mapResume.get(uuid);
    }

    @Override
    protected void deleteElement(Object key) {
        String uuid = (String) key;
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
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }


}
