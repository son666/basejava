package com.urise.webapp.exception;

public class ExistStorageException extends StorageException {

    public ExistStorageException(String uuid) {
        super("Resume c № " + uuid + " уже присутствует в хранилище", uuid);
    }
}
