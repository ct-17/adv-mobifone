package com.elcome.plus.advmobifone.dao.impl;

//import com.elcome.plus.advmobifone.common.ConnectionDatabase;
import com.elcome.plus.advmobifone.controller.UserController;
import com.elcome.plus.advmobifone.dao.UserDao;
import com.elcome.plus.advmobifone.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;

@Repository
public class UserDaoImpl extends AbstractDao implements UserDao {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    private SimpleJdbcCall simpleJdbcCall;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public User findById(Long id) {
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            String sqlSelect = "select * from users limit 10";
//            logger.info("get-user ===> id: {} ========== Start query user info ==========", id);
//            jdbcTemplate.query(sqlSelect, (Object[]) null, rs1 -> {});
            logger.info("nmcuong da toi day");
            simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("GET_USER_BY_ID")
                .declareParameters(
                new SqlParameter("id", Types.INTEGER));
            logger.info("get-user ===> output data ==========: nmcuong da toi day...");
            logger.info("get-user ===> output data ==========: {}", simpleJdbcCall.execute(new MapSqlParameterSource("id", id)));
            User user = new User();
            return user;
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
