package lab3.client;


import lab3.services.FilmWebCrudServiceWithExceptionsService;
import lab3.services.WrongFieldValueException;
import lab3.services.WrongIdException;

import java.net.MalformedURLException;
import java.net.URL;

public class FilmServiceClientLab3 {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8081/FilmService?wsdl");
        FilmWebCrudServiceWithExceptionsService filmWebService = new FilmWebCrudServiceWithExceptionsService(url);
        Integer id = null;
        try {
            id = filmWebService.getFilmServicePort().insertFilm("ExampleFilm", "director",
                    "USA", null, 9.);
        } catch (WrongFieldValueException e) {
            System.out.println(e.getFaultInfo().getMessage());
        }

        try {
            id = filmWebService.getFilmServicePort().insertFilm("ExampleFilm", "director",
                    "USA", null, 100.);
        } catch (WrongFieldValueException e) {
            System.out.println(e.getFaultInfo().getMessage());
        }
        System.out.println("Inserted row id = " + id);

        String result = null;
        try {
            result = filmWebService.getFilmServicePort().updateFilm(100, "AnotherFilmName", null, null, null, null);
        } catch (WrongFieldValueException e) {
            System.out.println(e.getFaultInfo().getMessage());
        } catch (WrongIdException e) {
            System.out.println(e.getFaultInfo().getMessage());
        }
        try {
            result = filmWebService.getFilmServicePort().updateFilm(id, "AnotherFilmName", null, null, null, null);
        } catch (WrongFieldValueException e) {
            System.out.println(e.getFaultInfo().getMessage());
        } catch (WrongIdException e) {
            System.out.println(e.getFaultInfo().getMessage());
        }
        System.out.println("Update result = " + result);
        System.out.println(filmWebService.getFilmServicePort().findFilms("AnotherFilmName", null, null, null, null).get(0).getName());
        try {
            result = filmWebService.getFilmServicePort().deleteFilm(100);
        } catch (WrongIdException e) {
            System.out.println(e.getFaultInfo().getMessage());
        }
        try {
            result = filmWebService.getFilmServicePort().deleteFilm(id);
        } catch (WrongIdException e) {
            System.out.println(e.getFaultInfo().getMessage());
        }
        System.out.println("Delete result = " + result);
        System.out.println(filmWebService.getFilmServicePort().findFilms("AnotherFilmName", null, null, null, null));
    }
}