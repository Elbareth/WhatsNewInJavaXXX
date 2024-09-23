package org.example;

import org.example.service.ConnectionService;
import org.example.service.HttpConnectionService;
import org.example.service.MailService;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://loremipsum.io/generator");  // we get the information from the website
            InputStream inputStream = url.openStream();
            Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8);
            System.out.println(scanner.nextLine());
            ConnectionService service = new ConnectionService();
            service.connect("https://loremipsum.io/generator");
            //service.sendAndGet("https://www.google.com/maps?", "1+Market+Street+San+Francisco", "en");
            HttpConnectionService httpConnectionService = new HttpConnectionService();
            httpConnectionService.connect("https://loremipsum.io/generator");
            //MailService mailService = new MailService();
            //mailService.send();
        } catch (IOException | URISyntaxException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}