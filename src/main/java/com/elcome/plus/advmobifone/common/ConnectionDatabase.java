package com.elcome.plus.advmobifone.common;

import org.springframework.beans.factory.annotation.Value;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDatabase {
    private static final ConnectionDatabase instance = new ConnectionDatabase();

    @Value("${db.url}")
    private String url_db;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;


    public Connection getConnection() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection con = DriverManager.getConnection(url_db, decrypt(username), decrypt(password));
            if (con != null && !con.isClosed()) {
                con.setAutoCommit(false);
            }
            return con;
        } catch (Exception e) {
            System.out.println("Connect data base error...");
        }
        return null;
    }

    public String decrypt(String value) {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword("elcomviettelvrbt");
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);

        String decrypt = encryptor.decrypt(value);
        return decrypt;
    }
}
