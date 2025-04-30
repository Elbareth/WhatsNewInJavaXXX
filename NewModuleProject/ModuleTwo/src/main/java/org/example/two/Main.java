//To use module we have to name our package always!
package org.example.two;

public class Main {
    public static void main(String[] args) {

        System.out.printf("Hello and welcome to module two!");
        for (int i = 1; i <= 2; i++) {
            System.out.println("i = " + i);
        }
        System.out.println("Now we will run module one");
        org.example.one.Main.main(new String[]{""});
    }
}