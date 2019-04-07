package lab4.standalone.dao;

import lab4.common.dao.FilmDAO;
import lab4.standalone.util.ConnectionUtil;

import java.sql.Connection;

public class StandaloneFilmDAO extends FilmDAO {

    @Override
    public Connection getConnection() {
        return ConnectionUtil.getConnection();
    }
}
