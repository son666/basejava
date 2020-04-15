package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage<String> {
    private Map<String, Resume> mapResume = new HashMap<>();

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void updateElement(String uuid, Resume resume) {
        mapResume.put(uuid, resume);
    }

    @Override
    protected void saveElement(Resume resume, String uuid) {
        mapResume.put(uuid, resume);
    }

    @Override
    protected Resume getElement(String uuid) {
        return mapResume.get(uuid);
    }

    @Override
    protected void deleteElement(String uuid) {
        mapResume.remove(uuid);
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
    protected boolean isExist(String uuid) {
        return mapResume.containsKey(uuid);
    }


}
