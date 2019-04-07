package lab2.client;

import lab2.services.FilmWebCrudServiceService;

import java.net.MalformedURLException;
import java.net.URL;

public class FilmServiceClientLab2 {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8081/FilmService?wsdl");
        FilmWebCrudServiceService filmWebService = new FilmWebCrudServiceService(url);
        Integer id = filmWebService.getFilmServicePort().insertFilm("ExampleFilm", "director",
                "USA", null, 100.);
        System.out.println("Inserted row id = " + id);
        String result = filmWebService.getFilmServicePort().updateFilm(id, "AnotherFilmName", null, null, null, null);
        System.out.println("Update result = " + result);
        System.out.println(filmWebService.getFilmServicePort().findFilms("AnotherFilmName", null, null, null, null).get(0).getName());
        result = filmWebService.getFilmServicePort().deleteFilm(id);
        System.out.println("Delete result = " + result);
        System.out.println(filmWebService.getFilmServicePort().findFilms("AnotherFilmName", null, null, null, null));
    }
}