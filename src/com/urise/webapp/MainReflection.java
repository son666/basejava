package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume resume = new Resume("Name");
        Field field = resume.getClass().getDeclaredFields()[0];
        System.out.println(field.getName());
        field.setAccessible(true);
        System.out.println(field.get(resume));
        field.set(resume, "new_uuid");
        System.out.println(field.get(resume));
        //invoke r.toString via reflection
        Method method = resume.getClass().getMethod("toString");
        System.out.println(method.invoke(resume));
    }
}
