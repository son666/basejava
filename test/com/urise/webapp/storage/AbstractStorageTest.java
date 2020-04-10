package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public abstract class AbstractStorageTest {
    protected Storage storage;
    private String uuid = UUID.randomUUID().toString();

    private static final String FULL_NAME_1 = "Иванов Иван";
    private static final Resume RESUME1 = new Resume(FULL_NAME_1);
    private static final String FULL_NAME_2 = "Сидоров Петр";
    private static final Resume RESUME2 = new Resume(FULL_NAME_2);
    private static final String FULL_NAME_3 = "Федин Илья";
    private static final Resume RESUME3 = new Resume(FULL_NAME_3);


    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(RESUME1);
        storage.save(RESUME2);
        storage.save(RESUME3);
    }

    @Test
    public void size() {
        assertSize(3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void update() {
        Resume resume = storage.get(RESUME2.getUuid());
        storage.update(resume);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        Resume resume = new Resume(uuid);
        storage.update(resume);
    }

    @Test
    public void save() {
        Resume resume = new Resume(uuid);
        storage.save(resume);
        assertSize(4);
        assertGet(resume);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExistStorageException() {
        storage.save(RESUME1);
    }


    @Test
    public void get() {
        Resume resume = storage.get(RESUME1.getUuid());
        assertGet(resume);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(RESUME1.getUuid());
        assertSize(2);
        assertGet(RESUME1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete(uuid);
    }

    @Test
    public void getAllSorted() {
        List<Resume> listResume = storage.getAllSorted();
        assertEquals(3, listResume.size());
        assertEquals(RESUME1, listResume.get(0));
        assertEquals(RESUME2, listResume.get(1));
        assertEquals(RESUME3, listResume.get(2));
    }

    private void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }
}
