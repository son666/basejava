package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapResumeStorage extends AbstractStorage {
    private Map<String, Resume> mapResume = new HashMap<>();

    @Override
    protected Resume getSearchKey(String uuid) {
        if (!mapResume.containsKey(uuid)) {
            return null;
        }
        return mapResume.get(uuid);
    }

    @Override
    protected void updateElement(Object searchResume, Resume resume) {
        mapResume.put(resume.getUuid(), resume);
    }

    @Override
    protected void saveElement(Resume resume, Object searchResume) {
        mapResume.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getElement(Object searchResume) {
        return (Resume) searchResume;
    }

    @Override
    protected void deleteElement(Object searchResume) {
        mapResume.remove(((Resume) searchResume).getUuid());
    }

    @Override
    public void clear() {
        mapResume.clear();
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> listResume = new ArrayList<>(mapResume.values());
        Collections.sort(listResume, Resume::compareTo);
        return listResume;
    }

    @Override
    public int size() {
        return mapResume.size();
    }

    @Override
    protected boolean isExist(Object searchResume) {
        return searchResume != null;
    }
}
