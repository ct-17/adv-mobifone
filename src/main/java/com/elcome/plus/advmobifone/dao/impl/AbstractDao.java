package com.elcome.plus.advmobifone.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;


public abstract class AbstractDao {
    protected void finallyConnection(Connection con, CallableStatement cs, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (cs != null) {
                cs.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
