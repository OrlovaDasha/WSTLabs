package lab6;

import lab4.common.beans.Film;
import lab5.FilmDao;
import lab6.exceptions.WrongFieldValueException;
import lab6.exceptions.WrongIdException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Path("/films")
@Produces({MediaType.APPLICATION_JSON})
public class FilmCrudResourceWithExceptions {

    private final static FilmDao filmDao = new FilmDao();


    @GET
    public List<Film> findFilms(@QueryParam("filmName") String name,
                                @QueryParam("director") String director,
                                @QueryParam("country") String country,
                                @QueryParam("dateOfStart") Date date,
                                @QueryParam("duration") Double duration) {
        return filmDao.getDataByFields(name, director, country, date, duration);
    }

    @POST
    @Path("/save")
    public String insertFilm(@QueryParam("filmName") String name,
                             @QueryParam("director") String director,
                             @QueryParam("country") String country,
                             @QueryParam("dateOfStart") String date,
                             @QueryParam("duration") Double duration) throws WrongFieldValueException {
        if (duration != null && (duration < 10 || duration > 400)) {
            throw new WrongFieldValueException("insert", "Duration must be between 10 minutes and 400 minutes");
        } else {
            return filmDao.insertRow(name, director, country, convertDateFromString(date), duration).toString();
        }
    }

    @Path("/delete/{id}")
    @DELETE
    public String deleteFilm(@PathParam("id") Integer id) throws WrongIdException {
        if (filmDao.findId(id)) {
            return filmDao.deleteRow(id).getStringValue();
        } else {
            throw new WrongIdException(id, "delete");
        }
    }

    @Path("/update/{id}")
    @PUT
    public String updateFilm(@PathParam("id") Integer id,
                             @QueryParam("filmName") String name,
                             @QueryParam("director") String director,
                             @QueryParam("country") String country,
                             @QueryParam("dateOfStart") String date,
                             @QueryParam("duration") Double duration) throws WrongIdException, WrongFieldValueException {
        if (filmDao.findId(id)) {
            if (duration != null && (duration < 10 || duration > 400)) {
                throw new WrongFieldValueException("insert", "Duration must be between 10 minutes and 400 minutes");
            } else {
                return filmDao.updateRow(id, name, director, country, convertDateFromString(date), duration).getStringValue();
            }
        } else {
            throw new WrongIdException(id, "update");
        }

    }

    Date convertDateFromString(String date) throws WrongFieldValueException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (date == null) {
            return null;
        }
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            throw new WrongFieldValueException("Date", "in format yyyy-MM-dd");
        }
    }
}

