package lab1.standalone.dao;

import lab1.common.dao.FilmDAO;
import lab1.standalone.utils.ConnectionUtil;

import java.sql.Connection;

public class StandaloneFilmDAO extends FilmDAO {

    @Override
    public Connection getConnection() {
        return ConnectionUtil.getConnection();
    }
}
