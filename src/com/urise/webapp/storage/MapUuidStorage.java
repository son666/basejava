package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage {
    private Map<String, Resume> mapResume = new HashMap<>();

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void updateElement(Object uuid, Resume resume) {
        mapResume.put((String) uuid, resume);
    }

    @Override
    protected void saveElement(Resume resume, Object uuid) {
        mapResume.put((String) uuid, resume);
    }

    @Override
    protected Resume getElement(Object uuid) {
        return mapResume.get((String) uuid);
    }

    @Override
    protected void deleteElement(Object uuid) {
        mapResume.remove((String) uuid);
    }

    @Override
    public List<Resume> getCopyAllElement() {
        return new ArrayList<>(mapResume.values());
    }

    @Override
    public void clear() {
        mapResume.clear();
    }

    @Override
    public int size() {
        return mapResume.size();
    }

    @Override
    protected boolean isExist(Object uuid) {
        return mapResume.containsKey((String) uuid);
    }


}
