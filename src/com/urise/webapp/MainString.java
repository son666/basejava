package com.urise.webapp;

public class MainString {
    public static void main(String[] args) {
        String[] str = new String[]{"1", "2", "3", "4", "5"};
        StringBuilder stringBuilder = new StringBuilder();
        for (String strVal : str) {
            stringBuilder.append(strVal).append(", ");
        }
        System.out.println(stringBuilder);

        String str1 = "abc";
        String str2 = "c";
        String str3 = ("ab" + str2).intern();
        System.out.println(str1 == str3);
    }
}
