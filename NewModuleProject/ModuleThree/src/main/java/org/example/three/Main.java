//To use module we have to name our package always!
package org.example.three;

public class Main {

    public static void main(String[] args) {

        System.out.printf("Hello and welcome to module three!");

        for (int i = 1; i <= 3; i++) {
            System.out.println("i = " + i);
        }
        System.out.println("We will call module two from module three");
        org.example.two.Main.main(new String[]{""});
    }
}