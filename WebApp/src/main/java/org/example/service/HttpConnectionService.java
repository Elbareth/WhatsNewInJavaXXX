package org.example.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;

class MyNewJSON
{
    private String name;
    private String age;

    public MyNewJSON(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public MyNewJSON() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyNewJSON myNewJSON = (MyNewJSON) o;
        return Objects.equals(name, myNewJSON.name) && Objects.equals(age, myNewJSON.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "{\"name\":\""+this.name+"\",\n\"age\":\""+this.age+"\"\n}";
    }
}

public class HttpConnectionService {
    public void connect(String uri) throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient(); //We create new client

        HttpRequest get = HttpRequest.newBuilder()
                .uri(new URI(uri))
                .GET()
                .build();

        MyNewJSON myNewJSON = new MyNewJSON("Imie", "15");
        System.out.println(myNewJSON);

        /*HttpRequest post = HttpRequest.newBuilder()
                .uri(new URI(uri))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(myNewJSON.toString()))
                .build();*/ //In case we need a post it should look like that
        HttpResponse<String> httpResponse = client.send(get, HttpResponse.BodyHandlers.ofString());
        System.out.println("Headers = " + httpResponse.headers().map());
        System.out.println("Body = "+httpResponse.body());

        //We can send the request in async way using method sendAsync
        //client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
        //  .thenAccept(response -> ...)
    }
}
