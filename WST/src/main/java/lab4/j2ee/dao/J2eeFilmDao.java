package lab4.j2ee.dao;

import lab1.common.dao.FilmDAO;
import lab4.j2ee.utils.ConnectionUtil;

import java.sql.Connection;

public class J2eeFilmDao extends FilmDAO {

    @Override
    public Connection getConnection() {
        return ConnectionUtil.getConnection();
    }
}
