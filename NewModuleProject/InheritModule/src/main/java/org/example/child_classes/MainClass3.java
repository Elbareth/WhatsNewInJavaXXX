package org.example.child_classes;

import org.example.interfaces.MainInterface;

public class MainClass3 implements MainInterface {
    @Override
    public void printMessage() {
        System.out.println("I am MainClass3 implementation");
    }
}
