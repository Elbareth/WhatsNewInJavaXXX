package org.example.service;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ServerHandler implements Runnable{
    private Socket socket;
    private final Map<Integer, String> choices;

    public ServerHandler(Socket socket) {
        this.socket = socket;
        this.choices = new HashMap<>();
        this.choices.put(1, "PAPIER");
        this.choices.put(2, "KAMIEŃ");
        this.choices.put(3, "NOŻYCE");
    }

    @Override
    public void run() {
        try {
            int userPoint = 0;
            int computerPoint = 0;
            OutputStream outputStream = this.socket.getOutputStream();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream,  StandardCharsets.UTF_8), true);
            writer.println("Gramy w pamier kamień nożyce! Wpisz 1 dla papier, 2 dla kamień, 3 dla nożyce. Wpisz 0 gdy masz dość!");
            InputStream inputStream = this.socket.getInputStream();
            Scanner reader = new Scanner(inputStream, StandardCharsets.UTF_8);
            boolean done = false;
            while (!done && reader.hasNextLine())
            {
                int myChoice = (int) ((Math.random() * 3)  + 1);
                int userChoice = Integer.parseInt(reader.nextLine());
                System.out.println(userChoice + " " + myChoice);
                if(userChoice == 1 && myChoice == 2)
                {
                    userPoint++;
                    writer.println("Wygrałeś! Twoje punkty = "+userPoint+" moje punkty = "+computerPoint);
                }
                else if(userChoice == 1 && myChoice == 3)
                {
                    computerPoint++;
                    writer.println("Przegrałeś! Twoje punkty = "+userPoint+" moje punkty = "+computerPoint);
                }
                else if(userChoice == 2 && myChoice == 3)
                {
                    userPoint++;
                    writer.println("Wygrałeś! Twoje punkty = "+userPoint+" moje punkty = "+computerPoint);
                }
                else if(userChoice == 2 && myChoice == 1)
                {
                    computerPoint++;
                    writer.println("Przegrałeś! Twoje punkty = "+userPoint+" moje punkty = "+computerPoint);
                }
                else if(userChoice == 3 && myChoice == 1)
                {
                    userPoint++;
                    writer.println("Wygrałeś! Twoje punkty = "+userPoint+" moje punkty = "+computerPoint);
                }
                else if(userChoice == 3 && myChoice == 2)
                {
                    computerPoint++;
                    writer.println("Przegrałeś! Twoje punkty = "+userPoint+" moje punkty = "+computerPoint);
                }
                else if(userChoice == myChoice)
                {
                    writer.println("Mamy remis! Twoje punkty = "+userPoint+" moje punkty = "+computerPoint);
                }
                else if(userChoice == 0)
                {
                    done = true;
                }
                else
                {
                    writer.println("Wpisałeś coś strasznie głupiego do terminala. Tak się nie bawię");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
