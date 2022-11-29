package com.elcome.plus.advmobifone.dao.impl;

import com.elcome.plus.advmobifone.common.ConnectionDatabase;
import com.elcome.plus.advmobifone.controller.UserController;
import com.elcome.plus.advmobifone.dao.UserDao;
import com.elcome.plus.advmobifone.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

@Repository
public class UserDaoImpl extends AbstractDao implements UserDao {

    private static final Logger logger = LogManager.getLogger(UserController.class);
    private final ConnectionDatabase connectionManager = new ConnectionDatabase();

    @Override
    public User findById(Long id) {
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            logger.info("get-user ===> id: {} ========== Start query user info ==========", id);
            con = connectionManager.getConnection();
            cs = con.prepareCall("{CALL WAP_AUTH.GET_USER_BY_ID(?)}");
            cs.setInt(1, Math.toIntExact(id));
            rs = cs.executeQuery();
            while (rs.next()) {
                User data = new User();
                data.setId(rs.getLong("id"));
                data.setUsername(rs.getString("username") != null ? rs.getString("username") : "");
                data.setPassword(rs.getString("password") != null ? rs.getString("password") : "");
                data.setPhone(rs.getString("phone") != null ? rs.getString("phone") : "");
                logger.info("get-user ===> id: {} ========== output data ==========: {}", id, data);
                return data;
            }
        } catch (Exception e) {
            logger.error("get-user ===> id: {} - Error get info user: {}", id, e);
            e.printStackTrace();
        } finally {
            finallyConnection(con, cs, rs);
        }
        logger.info("get-user ===> id: {} ========== output data ==========: null", id);
        return null;
    }
}
