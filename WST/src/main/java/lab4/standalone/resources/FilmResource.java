package lab4.standalone.resources;

import lab4.common.beans.Film;
import lab4.common.dao.FilmDAO;
import lab4.standalone.dao.StandaloneFilmDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import java.util.Date;
import java.util.List;

@Path("/films")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class FilmResource {

    private final static FilmDAO filmDao = new StandaloneFilmDAO();

    @GET
    public List<Film> findFilms(@QueryParam("filmName") String name,
                                @QueryParam("director") String director,
                                @QueryParam("country") String country,
                                @QueryParam("dateOfStart") Date date,
                                @QueryParam("duration") Double duration) {
        return filmDao.getDataByFields(name, director, country, date, duration);
    }
}
