package lab5;

import lab1.common.dao.FilmDAO;
import lab1.standalone.utils.ConnectionUtil;
import lab2.OperationStatus;
import lab4.standalone.dao.StandaloneFilmDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FilmDao extends StandaloneFilmDAO {

    public Integer insertRow(String name, String director, String country, Date dateOfStart, Double duration) {
        String query = " insert into films (name, director, dateofstart, country, duration)"
                + " values (?, ?, ?, ?, ?)";
        int index = 1;
        Integer id = null;
        try (Connection connection = ConnectionUtil.getConnection();) {

            try (PreparedStatement preparedStmt = connection.prepareStatement(query)) {
                preparedStmt.setString(index++, name);
                preparedStmt.setString(index++, director);
                preparedStmt.setDate(index++, dateOfStart != null
                        ? new java.sql.Date(dateOfStart.getTime())
                        : null);
                preparedStmt.setString(index++, country);
                preparedStmt.setObject(index, duration);
                preparedStmt.executeUpdate();
                try (ResultSet result = connection.createStatement().executeQuery("select max(id) as maxid from films")) {
                    result.next();
                    id = result.getInt("maxid");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    private void addUpdatedValues(Object value, String fieldName, StringBuilder query) {
        if (value != null) {
            if (value instanceof String) {
                query.append(fieldName).append(" = '").append(value).append("'").append(", ");
            } else {
                query.append(fieldName).append(" = ").append(value).append(',');
            }
        }
    }

    public OperationStatus updateRow(Integer id, String name, String director, String country, Date dateOfStart, Double duration) {
        StringBuilder query = new StringBuilder(" update films set ");
        addUpdatedValues(name, "name", query);
        addUpdatedValues(director, "director", query);
        addUpdatedValues(country, "country", query);
        addUpdatedValues(dateOfStart, "datepfstart", query);
        addUpdatedValues(duration, "duration", query);
        query.replace(query.lastIndexOf(","), query.length(), " ");
        query.append(" where id = " + id);
        try (Connection connection = ConnectionUtil.getConnection();) {
            try (PreparedStatement preparedStmt = connection.prepareStatement(query.toString())) {
                preparedStmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilmDAO.class.getName()).log(Level.SEVERE, null, ex);
            return OperationStatus.FAIL;
        }
        return OperationStatus.SUCCESS_UPDATE;
    }

    public OperationStatus deleteRow(Integer id) {
        String query = "DELETE FROM films WHERE id = " + id;
        try (Connection connection = ConnectionUtil.getConnection()) {
            try (PreparedStatement preparedStmt = connection.prepareStatement(query)) {
                preparedStmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilmDAO.class.getName()).log(Level.SEVERE, null, ex);
            return OperationStatus.FAIL;
        }
        return OperationStatus.SUCCESS_DELETE;
    }
}
