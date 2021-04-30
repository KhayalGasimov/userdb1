
package com.company.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;


public abstract class AbstractDAO {
    public  Connection connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/user";
        String username = "root";
        String password = "123456";
        Connection c = DriverManager.getConnection(url, username, password);
        return c;
    }
}

