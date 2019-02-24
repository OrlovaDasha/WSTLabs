package lab1.standalone.client;

import lab1.standalone.services.Film;
import lab1.standalone.services.FilmWebServiceService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class FilmClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8081/FilmService?wsdl");
        FilmWebServiceService filmService = new FilmWebServiceService(url);
        List<Film> films = filmService.getFilmServicePort().getFilmsByFields(null, "Director3", null, null, null);
        for (Film film : films) {
            System.out.println("name: " + film.getName() +
                    ", director: " + film.getDirector() + ", country: " + film.getCountry());
        }
        System.out.println("Total films: " + films.size());
    }
}
