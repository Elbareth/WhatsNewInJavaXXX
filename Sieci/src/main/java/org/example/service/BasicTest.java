package org.example.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class BasicTest {
    public void test()
    {
        try {
            // We try to connect to this page
            Socket socket = new Socket("time-a.nist.gov", 13);
            //How many miliseconds the socket will wait for the response
            socket.setSoTimeout(10000);
            // We read returned page
            Scanner scanner = new Scanner(socket.getInputStream(), StandardCharsets.UTF_8);
            while (scanner.hasNextLine())
            {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            // We create empty socket and we don't connect to anything yet!
            Socket socket2 = new Socket();
            // Now we can connect to sth. We can set timeout here
            socket2.connect(new InetSocketAddress("time-a.nist.gov", 13), 10000);
            Scanner scanner = new Scanner(socket2.getInputStream(), StandardCharsets.UTF_8);
            while (scanner.hasNextLine())
            {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            // We try to get the ip address based on host name
            InetAddress hostname = InetAddress.getByName("www.google.pl");
            System.out.println(hostname);

            //We want to get all ip addresses connected to this hostname
            InetAddress[] hostnames = InetAddress.getAllByName("www.google.pl");
            for(int i = 0; i < hostnames.length; i++)
            {
                System.out.println("Address "+i+" = "+hostnames[i]);
            }

            // When we want to get local host name
            InetAddress localhost = InetAddress.getLocalHost();
            System.out.println("Localhost = "+localhost);

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

    }
}
