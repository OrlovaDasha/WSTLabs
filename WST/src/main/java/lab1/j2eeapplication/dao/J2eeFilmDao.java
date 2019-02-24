package lab1.j2eeapplication.dao;

import lab1.common.dao.FilmDAO;
import lab1.j2eeapplication.utils.ConnectionUtil;

import java.sql.Connection;

public class J2eeFilmDao extends FilmDAO {

    @Override
    public Connection getConnection() {
        return ConnectionUtil.getConnection();
    }
}
