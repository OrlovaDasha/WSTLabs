package lab3;

import lab1.common.dao.FilmDAO;
import lab1.standalone.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FilmDao extends lab2.FilmDao {

    public boolean findId(Integer id) {
        boolean isIdPresent = false;
        String query = "select count(*) from films where id = ?";
        try (Connection connection = ConnectionUtil.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                int n = 0;
                if (rs.next()) {
                    isIdPresent = rs.getInt(1) == 1;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilmDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return isIdPresent;
        }
    }
}
