package lab5;

import lab4.common.beans.Film;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Path("/films")
@Produces({MediaType.APPLICATION_JSON})
public class FilmCrudResource {

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
                              @QueryParam("duration") Double duration) {
        return filmDao.insertRow(name, director, country, convertDateFromString(date), duration).toString();
    }

    @Path("/delete/{id}")
    @DELETE
    public String deleteFilm(@PathParam("id") Integer id) {
        return filmDao.deleteRow(id).getStringValue();
    }

    @Path("/update/{id}")
    @PUT
    public String updateFilm(@PathParam("id") Integer id,
                             @QueryParam("filmName") String name,
                             @QueryParam("director") String director,
                             @QueryParam("country") String country,
                             @QueryParam("dateOfStart") String date,
                             @QueryParam("duration") Double duration) {
        return filmDao.updateRow(id,
                name,
                director,
                country,
                convertDateFromString(date),
                duration).getStringValue();
    }


    Date convertDateFromString(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (date == null) {
            return null;
        }
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}

