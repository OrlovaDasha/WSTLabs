package withauth.rest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import lab4.Film;
import sun.misc.BASE64Encoder;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;


public class App {
    private static final String URL = "http://localhost:8081/rest/films";

    static String login() {
        String name = "user";
        String password = "12345";
        String authString = name + ":" + password;
        return new BASE64Encoder().encode(authString.getBytes());
    }

    public static void main(String[] args) throws IOException {
        Client client = Client.create();
        Integer id = saveFilm(client, new Film("sampleName", null, "counry", 1.0, "director"), false);
        System.out.println("Inserted row id = " + id);
        id = saveFilm(client, new Film("sampleName", null, "counry", 1.0, "director"), true);
        System.out.println("Inserted row id = " + id);
        String result = updateFilm(client, new Film("AnotherFilmName", null, null, 2.0, null), id);
        System.out.println("Update result = " + result);
        System.out.println(getFilms(client, "AnotherFilmName"));
        result = deleteFilm(client, id);
        System.out.println("Delete result = " + result);
        System.out.println(getFilms(client, "AnotherFilmName"));
    }

    private static List<Film> getFilms(Client client, String filmName) {
        WebResource webResource = client.resource(URL);
        if (filmName != null) {
            webResource = webResource.queryParam("filmName", filmName);
        }
        ClientResponse response =
                webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }
        GenericType<List<Film>> type = new GenericType<List<Film>>() {
        };
        return response.getEntity(type);
    }

    private static Integer saveFilm(Client client, Film film, Boolean login) throws IOException {
        WebResource webResource = client.resource(URL + "/save");

        if (film.getName() != null) {
            webResource = webResource.queryParam("filmName", film.getName());
        }
        if (film.getCountry() != null) {
            webResource = webResource.queryParam("country", film.getCountry());
        }
        if (film.getDateOfStart() != null) {
            webResource = webResource.queryParam("dateOfStart", film.getDateOfStart().toString());
        }
        if (film.getDirector() != null) {
            webResource = webResource.queryParam("director", film.getDirector());
        }
        if (film.getDuration() != null) {
            webResource = webResource.queryParam("birthdate", film.getDuration().toString());
        }


        ClientResponse response = login ? webResource.accept(MediaType.APPLICATION_JSON_TYPE)
                .header("Authorization", "Basic " + login())
                .post(ClientResponse.class)
                : webResource.accept(MediaType.APPLICATION_JSON_TYPE)
                .post(ClientResponse.class);

        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }
        GenericType<String> type = new GenericType<String>() {
        };
        return Integer.parseInt(response.getEntity(type));
    }

    private static String updateFilm(Client client, Film film, Integer id) throws IOException {
        WebResource webResource = client.resource(URL + "/update/" + id);


        if (film.getName() != null) {
            webResource = webResource.queryParam("filmName", film.getName());
        }
        if (film.getCountry() != null) {
            webResource = webResource.queryParam("country", film.getCountry());
        }
        if (film.getDateOfStart() != null) {
            webResource = webResource.queryParam("dateOfStart", film.getDateOfStart().toString());
        }
        if (film.getDirector() != null) {
            webResource = webResource.queryParam("director", film.getDirector());
        }
        if (film.getDuration() != null) {
            webResource = webResource.queryParam("birthdate", film.getDuration().toString());
        }

        ClientResponse response = webResource
                .header("Authorization", "Basic " + login())
                .accept(MediaType.APPLICATION_JSON_TYPE).put(ClientResponse.class);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }
        GenericType<String> type = new GenericType<String>() {
        };
        return response.getEntity(type);
    }

    private static String deleteFilm(Client client, Integer id) throws IOException {
        WebResource webResource = client.resource(URL + "/delete/" + id);

        ClientResponse response = webResource
                .header("Authorization", "Basic " + login())
                .accept(MediaType.APPLICATION_JSON_TYPE).delete(ClientResponse.class);

        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }

        return response.getEntity(String.class);
    }
}
