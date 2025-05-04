package org.example.child_classes;

import org.example.interfaces.MainInterface;

public class MainClass1 implements MainInterface
{
    @Override
    public void printMessage() {
        System.out.println("I am MainClass1 implementation");
    }
}
