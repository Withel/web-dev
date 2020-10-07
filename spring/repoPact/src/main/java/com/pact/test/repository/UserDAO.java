package com.pact.test.repository;


import com.pact.test.model.User;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Component
public class UserDAO {
    private static Connection conn;
    private static Properties properties;
    private String selectedParam;
    private String selectedValue;
    private String usernameFilter;
    private String passwordFilter;

    private void getPropertiesValues() throws IOException {
        properties = new Properties();
        String filename = "db.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        if (inputStream != null) {
            properties.load(inputStream);
        }
    }

    private void connect() {
        try {
            getPropertiesValues();
        } catch (IOException e) {
            e.printStackTrace();
        }
        conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(properties.getProperty("DATABASE_URL"), properties.getProperty("DB_USER"), properties.getProperty("DB_USER_PASSWORD"));
            System.out.println("Successfully connected to database");
        } catch (SQLException | ClassNotFoundException sql_e) {
            sql_e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        connect();
        ResultSet usersResultSet;
        List<User> resultList = new ArrayList<User>();
        String sql="select * from new_table";
        if (!usernameFilter.equals("")) {
            sql = sql.concat(" where username like " + "'"+usernameFilter + "%' ");
            if (!passwordFilter.equals("")) {
                sql = sql.concat(" and password like " +"'"+ passwordFilter + "%'");
            }
        } else if (!passwordFilter.equals("")) {
            sql = sql.concat(" where password like " +"'"+ passwordFilter + "%'");
        }
        if (!selectedParam.equals("") && !selectedValue.equals("")) {
            sql =  sql.concat(" order by " + selectedParam + " " + selectedValue);
        }
        try {
            Statement st = conn.createStatement();
            usersResultSet = st.executeQuery(sql);
            while (usersResultSet.next()) {
                resultList.add(new User(
                        usersResultSet.getInt("userdbID"), usersResultSet
                        .getString("username"), usersResultSet
                        .getString("password")));
            }
        } catch (SQLException sql_e) {
            sql_e.printStackTrace();
        }
        return resultList;
    }

    public void modifyUser(String id, String usernameVal, String password) {
        int userID = Integer.parseInt(id);
        connect();
        try {
            Statement st = conn.createStatement();
            String sql = "update new_table set username=" + "'" + usernameVal + "'" + ",password=" + "'" + password + "'" + " where userdbID=" + userID;
            st.executeUpdate(sql);
        } catch (SQLException sql_e) {
            sql_e.printStackTrace();
        }
    }

    public void addUser(User userToDB) {
        connect();
        Integer id = userToDB.getUserdbID();
        String username = userToDB.getUsername();
        String password = userToDB.getPassword();
        try {
            Statement statement = conn.createStatement();
            String sql = "insert into new_table (userdbID,username,password) values (" + id + ",'" + username + "','" + password + "')";
            statement.executeUpdate(sql);
        } catch (SQLException sql_e) {
            sql_e.printStackTrace();
        }
    }

    public int getLastID() {
        connect();
        ResultSet userIDResult;
        int foundDB = 0;
        try {
            Statement statement = conn.createStatement();
            String sql = "select max(userdbID) as userdbID from new_table";
            userIDResult = statement.executeQuery(sql);
            while (userIDResult.next()) {
                foundDB = userIDResult.getInt("userdbID");
            }
        } catch (SQLException sql_e) {
            sql_e.printStackTrace();
        }
        return foundDB;
    }

    public void deleteUser(String id) {
        connect();
        int userID = Integer.parseInt(id);
        try {
            Statement statement = conn.createStatement();
            String sql = "delete from new_table where userdbID=" + userID;
            statement.executeUpdate(sql);
        } catch (SQLException sql_e) {
            sql_e.printStackTrace();
        }
    }

    public List<User> getAllUsersSorted(String selectedParam, String selectedValue) {
        connect();
        ResultSet usersResultSet;
        List<User> resultList = new ArrayList<User>();
        try {
            Statement st = conn.createStatement();
            usersResultSet = st.executeQuery("select * from new_table order by " + selectedParam + " " + selectedValue);

            while (usersResultSet.next()) {
                resultList.add(new User(
                        usersResultSet.getInt("userdbID"), usersResultSet
                        .getString("username"), usersResultSet
                        .getString("password")));
            }

        } catch (SQLException sql_e) {
            sql_e.printStackTrace();
        }
        return resultList;
    }

    public void setSelectionParam(String selectedParam) {
        this.selectedParam = selectedParam;
    }

    public void setSelectionValue(String selectedValue) {
        this.selectedValue = selectedValue;
    }

    public void setUsernameFilter(String usernameFilter) {
        this.usernameFilter=usernameFilter;
    }

    public void setPasswordFilter(String passwordFilter) {
        this.passwordFilter=passwordFilter;
    }
}


