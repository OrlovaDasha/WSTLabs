package lab2;

import javax.xml.ws.Endpoint;

public class App {
    public static void main(String[] args) {
        String url = "http://0.0.0.0:8081/FilmService";
        Endpoint.publish(url, new FilmWebCrudService());
    }
}
