package com.urise.webapp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainFile {
    private static List<String> listNameFile = new ArrayList<>();

    private static void findFiles(File file) throws IOException {
        if (file.isDirectory()) {
            File[] listFile = file.listFiles();
            for (int i = 0; i < listFile.length; i++) {
                findFiles(listFile[i]);
            }
        } else {
            listNameFile.add(file.getCanonicalPath());
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File(".");
            findFiles(file);
            for (String fileName : listNameFile) {
                System.out.println(fileName);
            }
        } catch (IOException e) { e.printStackTrace(); }
    }
}
