//To use module we have to name our package always!
package org.example.two;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {

        System.out.printf("Hello and welcome to module two!");
        for (int i = 1; i <= 2; i++) {
            System.out.println("i = " + i);
        }
        System.out.println("Now we will run module one");
        org.example.one.Main.main(new String[]{""});
        System.out.println("We will use reflection here");
        //We access the field from another module
        Field field = null;
        try {
            org.example.one.Main obj = new org.example.one.Main();
            field = org.example.one.Main.class.getDeclaredField("arg");
            //Do we need access to the field?
            field.setAccessible(true);
            System.out.println("Can we read? = "+field.getInt(obj));
            field.setInt(obj, 15);
            System.out.println("Do we have another value? = "+field.getInt(obj));
            System.out.println("Do it will work with string");
            Field fieldStr = org.example.one.Main.class.getDeclaredField("argStr");
            //Do we need access to the field?
            fieldStr.setAccessible(true);
            System.out.println("Can we read? = "+fieldStr.get(obj));
            fieldStr.set(obj, "Different value");
            System.out.println("Do we have another value? = "+fieldStr.get(obj));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}