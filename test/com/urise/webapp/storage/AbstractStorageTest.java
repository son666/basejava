package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class AbstractStorageTest {

    protected Storage storage;
    private String uuid = UUID.randomUUID().toString();
    private static final Resume RESUME1;
    private static final Resume RESUME2;
    private static final Resume RESUME3;

    static {
        RESUME1 = ResumeTestData.initiallyResume("Григорий Кислин");
        RESUME2 = ResumeTestData.initiallyResume("Сидоров Петр");
        RESUME3 = ResumeTestData.initiallyResume("Федин Илья");
    }


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
        Resume newResume = new Resume(RESUME1.getUuid(), "New Name");
        storage.update(newResume);
        assertTrue(newResume == storage.get(RESUME1.getUuid()));
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
        assertEquals(listResume, Arrays.asList(RESUME1, RESUME2, RESUME3));
    }

    private void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }
}
