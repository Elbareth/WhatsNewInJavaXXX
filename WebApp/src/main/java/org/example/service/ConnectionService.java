package org.example.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConnectionService {
    public void connect(String url) throws IOException {
        URLConnection connection = new URL(url).openConnection(); //We try to connect under specific URL
        connection.setDoInput(true); // We want to get data from this URL
        connection.setDoOutput(false); //But we don't want to send there anything
        connection.setIfModifiedSince(0); //We are interested in data that was modified from this time
        connection.setUseCaches(false); //If we want to use Cache-Control - Cache-Control: no-cache
        connection.setAllowUserInteraction(false); //If page can interact with the user
        connection.setRequestProperty("Accept-Language", "en"); //To set values for the header
        connection.setConnectTimeout(5000); //Time out for connection
        connection.setReadTimeout(10000); //It is for "starting" read data. The timeout is there to set a limit on how long the wait is for incoming data. The timeout doesn't apply when there is data available for reading.
        //"If the timeout expires before there is data available for read, a java.net.SocketTimeoutException is raised."
        connection.connect();
        Map<String, List<String>> headerFields = connection.getHeaderFields(); //We get information about the header
        System.out.println(headerFields);
        InputStream inputStream = connection.getInputStream();
        Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8);
        System.out.println(scanner.nextLine());
    }
    public void sendAndGet(String url, String street, String language) throws IOException {
        URLConnection connection = new URL(url).openConnection(); //We try to connect under specific URL
        connection.setDoInput(true); // We want to get data from this URL
        connection.setDoOutput(true); //But we don't want to send there anything
        connection.setIfModifiedSince(0); //We are interested in data that was modified from this time
        connection.setUseCaches(false); //If we want to use Cache-Control - Cache-Control: no-cache
        connection.setAllowUserInteraction(false); //If page can interact with the user
        connection.setRequestProperty("Accept-Language", "en"); //To set values for the header
        connection.setConnectTimeout(5000); //Time out for connection
        connection.setReadTimeout(10000); //It is for "starting" read data. The timeout is there to set a limit on how long the wait is for incoming data. The timeout doesn't apply when there is data available for reading.
        //"If the timeout expires before there is data available for read, a java.net.SocketTimeoutException is raised."
        PrintWriter printWriter = new PrintWriter(connection.getOutputStream());
        printWriter.write("q="+street+"&h1="+language);
        //printWriter.write("h1="+language);
        printWriter.close();
        connection.connect();
        Map<String, List<String>> headerFields = connection.getHeaderFields(); //We get information about the header
        System.out.println(headerFields);
        InputStream inputStream = connection.getInputStream();
        Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8);
        System.out.println(scanner.nextLine());
    }
}
