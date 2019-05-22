package withauth.soap;

import withauth.soap.generated.FilmWebCrudServiceService;

import java.net.MalformedURLException;
import java.net.URL;

public class ClientApp {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8081/FilmService?wsdl");
        FilmWebCrudServiceService filmWebService = new FilmWebCrudServiceService(url);
        String err = filmWebService.getFilmServicePort().insertFilm("user1", "password","ExampleFilm", "director",
                "USA", null, 100.);
        System.out.println("Problem = " + err);

        Integer id = Integer.parseInt(filmWebService.getFilmServicePort().insertFilm("user", "12345", "ExampleFilm", "director",
                "USA", null, 100.));
        String result = filmWebService.getFilmServicePort().updateFilm("user", "12345", id, "AnotherFilmName", null, null, null, null);
        System.out.println("Update result = " + result);
        System.out.println(filmWebService.getFilmServicePort().findFilms("AnotherFilmName", null, null, null, null).get(0).getName());
        result = filmWebService.getFilmServicePort().deleteFilm("user", "12345", id);
        System.out.println("Delete result = " + result);
        System.out.println(filmWebService.getFilmServicePort().findFilms("AnotherFilmName", null, null, null, null));
    }
}
