package com.company.dao.impl;

import com.company.bean.User;
import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserDaoInter;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl extends AbstractDAO implements UserDaoInter {

    @Override
    public List<User> getAllUsers() {
        List<User> result = new ArrayList<>();
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select * from user");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String email = rs.getString("email");
                result.add(new User(id, name, surname, email));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean addUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("INSERT INTO user (name, surname, email)" + "VALUES (?,?,?)");
            stmt.setString(1, "Sabit");
            stmt.setString(2, "Ehmedov");
            stmt.setString(3, "sabit@gmail.com");
            stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return false;
    }

    @Override
    public boolean updateUser() {
        try (Connection c = connect()){
           Statement stmt = c.createStatement();
           String query = "update user set surname='Aliyev' where id = 2";
           stmt.executeUpdate(query);
            System.out.println();

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }return false;
    }
    @Override
    public boolean removeUser(int id) {
        try (Connection c = connect()){
            Statement stmt = c.createStatement();
            return stmt.execute("delete from user where id ="+id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
