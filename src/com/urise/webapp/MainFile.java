package com.urise.webapp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainFile {
    private static List<String> listNameFile = new ArrayList<>();

    private static void findFiles(File fileFind) throws IOException {
        if (fileFind.isDirectory()) {
            File[] listFile = fileFind.listFiles();
            if (listFile == null) return;
            for (File file : listFile) {
                findFiles(file);
            }
        } else {
            listNameFile.add(fileFind.getName());
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File(".");
            findFiles(file);
            for (String fileName : listNameFile) {
                System.out.println(fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
