package com.urise.webapp.exception;

public class NotExistStorageException extends StorageException {

    public NotExistStorageException(String uuid) {
        super("Resume c № " + uuid + " отсутсвует в хранилище", uuid);
    }
}
