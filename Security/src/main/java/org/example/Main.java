package org.example;

import org.example.services.MyOwnClassLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)
    {
        //We can use different procedure to load the classes
        //1. basic level - all basic JDK's module
        //2. platform level - all basic platform that wasn't loaded on basic level
        //3. system level - all modules, JAR, classes from the classpath
        //ATTENTION! Above procedure has hierarchy ASC!
        System.out.println("We use platform level = "+ClassLoader.getPlatformClassLoader().getName());
        System.out.println("We use system level = " +ClassLoader.getSystemClassLoader().getName());
        //We can change the way, the classes are loaded
        Thread t  = Thread.currentThread();
        System.out.println("How we load the thread now? = " + t.getContextClassLoader());
        t.setContextClassLoader(ClassLoader.getPlatformClassLoader());
        System.out.println("How we load the thread now? = " + t.getContextClassLoader());
        System.out.println("What's the parent of the procedure? What's the higher in the procedure hierarchy? = " + t.getContextClassLoader().getParent());
        try {
            //We want to load class from another package
            //We wrote own ClassLoader
            //We override the findClass method
            //This method will be called when standard procedures won't find the code
            //We have to load bytes array from loaded file
            //And call the defineClass method - put the byte stream there
            MyOwnClassLoader ownClassLoader = new MyOwnClassLoader();
            //We try to load the class
            //The standard procedures first, then our own loader
            Class<?> cl = ownClassLoader.loadClass("FileFromAnotherPackage");
            //We load the method that we are interested in
            Method method = cl.getMethod("main", String[].class);
            //And we can call our method with arguments
            method.invoke(null, (Object) new String[]{"Lubię placki"});

        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}