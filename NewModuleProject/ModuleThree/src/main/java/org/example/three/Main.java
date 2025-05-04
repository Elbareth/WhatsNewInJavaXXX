//To use module we have to name our package always!
package org.example.three;

import org.example.interfaces.MainInterface;

import java.util.ServiceLoader;

public class Main {

    public static void main(String[] args) {

        System.out.printf("Hello and welcome to module three!");

        for (int i = 1; i <= 3; i++) {
            System.out.println("i = " + i);
        }
        System.out.println("We will call module two from module three");
        try
        {
            org.example.two.Main.main(new String[]{""});
        }
        catch(NoClassDefFoundError err)
        {
            System.out.println("We cannot found the module (static property in module-info) "+err.getLocalizedMessage());
        }
        //We have access to module with an interface
        //We didn't export the implementation
        //However we want to use it!
        //We have to use ServiceLoader
        //We load every possible implementation of MainInterface
        ServiceLoader<MainInterface> mainImplList = ServiceLoader.load(MainInterface.class);
        //We choose the target implementation any way we want ;p
        MainInterface chosenMainImpl = mainImplList.iterator().next();
        //We can use our class
        chosenMainImpl.printMessage();

    }
}