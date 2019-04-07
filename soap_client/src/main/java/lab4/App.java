package lab4;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import java.util.List;
import javax.ws.rs.core.MediaType;


public class App {
    private static final String URL = "http://localhost:8081/rest/films";

    public static void main(String[] args) {
        Client client = Client.create();
        printList(getAllFilms(client, null));
        System.out.println();
        printList(getAllFilms(client, "Film1"));
    }
    private static List<Film> getAllFilms(Client client, String name) {
        WebResource webResource = client.resource(URL);
        if (name != null) {
            webResource = webResource.queryParam("filmName", name);
        }
        ClientResponse response =
                webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }
        GenericType<List<Film>> type = new GenericType<List<Film>>() {};
        return response.getEntity(type);
    }

    private static void printList(List<Film> films) {
        for (Film film : films) {
            System.out.println(film);
        }
    }
}
