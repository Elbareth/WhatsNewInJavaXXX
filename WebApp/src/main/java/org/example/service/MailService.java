package org.example.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class MailService {
    public  void send() throws IOException {
        //This is how it looks like in the past
        //Now we need of course oAuth etc.
        //https://developers.google.com/gmail/api/quickstart/java?hl=pl
        Socket socket = new Socket("mail.google.com", 25);
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.write(createMessage());
        printWriter.close();
        socket.close();
    }

    private String createMessage()
    {
        return "HELO localhost\r\n MAIL FROM: mail\r\n"
                +"MAIL TO: mail\r\n DATA\r\n SUBJECT: Mail testowy\r\n\r\n"
                +"Oto treść tej wiadomości e-mail\r\nQUIT";
    }
}
