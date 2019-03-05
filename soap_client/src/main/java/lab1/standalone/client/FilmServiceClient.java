package lab1.standalone.client;

import lab1.standalone.services.Film;
import lab1.standalone.services.FilmWebServiceService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class FilmServiceClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8081/FilmService?wsdl");
        FilmWebServiceService filmWebService = new FilmWebServiceService(url);
        List<Film> films = filmWebService.getFilmServicePort().findFilms(null, null, null, null, null);
        for (Film film : films) {
            System.out.println(film.toString());
        }
        System.out.println("Total persons: " + films.size());
    }
}