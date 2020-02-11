package com.catapi.printjson;

public class PrintArrayInJsonFormat {


    public static void main(String[] args) {

        String[] arrayStr = new String[]{"JAVA", "NODE", "Python", "Ruby"};

        PrintJsonFormatUtills.test(arrayStr);


        int [] arrayInt = {1,23,4,5,5};
        PrintJsonFormatUtills.test(arrayInt);

    }
}
