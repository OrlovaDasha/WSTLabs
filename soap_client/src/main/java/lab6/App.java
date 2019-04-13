package lab6;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import lab4.Film;

import javax.ws.rs.core.MediaType;
import java.net.MalformedURLException;
import java.util.List;

public class App {
    private static final String URL = "http://localhost:8081/rest/films";

    public static void main(String[] args){
        Client client = Client.create();
        Integer id;
        id = saveFilm(client, new Film("ExampleFilm", null, "USA", 9.0, "director"));

        System.out.println("Inserted row id = " + id);

        id = saveFilm(client, new Film("ExampleFilm", null, "USA", 100., "director"));

        System.out.println("Inserted row id = " + id);

        String result = updateFilm(client, new Film("AnotherFilmName", null, null, null, null), 100);
        System.out.println("Update result = " + result);

        result = updateFilm(client, new Film("AnotherFilmName", null, null, null, null), id);

        System.out.println("Update result = " + result);

        System.out.println(getFilms(client, "AnotherFilmName").get(0).getName());
        result = deleteFilm(client, 100);
        System.out.println("Delete result = " + result);

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

    private static Integer saveFilm(Client client, Film film) {
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

        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            GenericType<String> type = new GenericType<String>() {};
            System.out.println("Insert failed " + response.getStatus() +  " " + response.getEntity(type));
            return null;
        } else {
            GenericType<String> type = new GenericType<String>() {
            };
            return Integer.parseInt(response.getEntity(type));
        }
    }

    private static String updateFilm(Client client, Film film, Integer id) {
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

        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON_TYPE).put(ClientResponse.class);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            GenericType<String> type = new GenericType<String>() {};
            System.out.println("Update failed " + response.getStatus() +  " " + response.getEntity(type));
            return null;
        } else {
            GenericType<String> type = new GenericType<String>() {
            };
            return response.getEntity(type);
        }

    }

    private static String deleteFilm(Client client, Integer id) {
        WebResource webResource = client.resource(URL + "/delete/" + id);

        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON_TYPE).delete(ClientResponse.class);

        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            GenericType<String> type = new GenericType<String>() {};
            System.out.println("Delete failed " + response.getStatus() +  " " + response.getEntity(type));
            return null;
        } else {
            return response.getEntity(String.class);
        }
    }

}