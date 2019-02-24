package lab1.common.dao;

import lab1.common.beans.Film;
import lab1.standalone.utils.ConnectionUtil;

import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class FilmDAO {

    private Boolean addChecking(Object value, String fieldName, Boolean isNotFirst, StringBuilder query) {
        if (value != null) {
            if (isNotFirst) {
                query.append(" and ");
            }
            if (value instanceof String) {
                query.append(fieldName).append(" = '").append(value).append("'");
            } else {
                query.append(fieldName).append(" = ").append(value);
            }
            if (!isNotFirst) {
                return true;
            }
        }
        return isNotFirst;
    }

    public abstract Connection getConnection();

    public List<Film> getDataByFields(String name, String director, String country, Date dateOfStart, Double duration) {
        List<Film> films = Collections.emptyList();
        try (Connection connection = getConnection()) {
            StringBuilder query = new StringBuilder("select * from films");
            boolean notFirstField = false;
            if (name != null || director != null || country != null && dateOfStart != null || duration != null) {
                query.append(" where ");
            }
            notFirstField = addChecking(name, "name", notFirstField, query);
            notFirstField = addChecking(director, "director", notFirstField, query);
            notFirstField = addChecking(country, "country", notFirstField, query);
            notFirstField = addChecking(dateOfStart, "dateOfStart", notFirstField, query);
            addChecking(duration, "duration", notFirstField, query);

            PreparedStatement stmt = connection.prepareStatement(query.toString());
            ResultSet rs = stmt.executeQuery();
            films = extractFilmsFromResultSet(rs);
        } catch (SQLException ex) {
            Logger.getLogger(FilmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return films;
    }

    private List<Film> extractFilmsFromResultSet(ResultSet rs) throws SQLException{
        List<Film> films = new ArrayList<Film>();
        while (rs.next()) {
            String name = rs.getString("name");
            Date date = rs.getDate("dateOfStart");
            String director = rs.getString("director");
            String country = rs.getString("country");
            double duration = rs.getDouble("duration");

            Film film = new Film(name, date, country, duration, director);
            films.add(film);
        } return films;
    }
}
