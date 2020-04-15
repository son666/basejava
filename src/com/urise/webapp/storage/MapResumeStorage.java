package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapResumeStorage extends AbstractStorage<Resume> {
    private Map<String, Resume> mapResume = new HashMap<>();

    @Override
    protected Resume getSearchKey(String uuid) {
        return mapResume.get(uuid);
    }

    @Override
    protected void updateElement(Resume searchResume, Resume resume) {
        mapResume.put(resume.getUuid(), resume);
    }

    @Override
    protected void saveElement(Resume resume, Resume searchResume) {
        mapResume.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getElement(Resume searchResume) {
        return searchResume;
    }

    @Override
    protected void deleteElement(Resume searchResume) {
        mapResume.remove(searchResume.getUuid());
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
    protected boolean isExist(Resume searchResume) {
        return searchResume != null;
    }
}
