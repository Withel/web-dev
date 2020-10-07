package com.pact.test.services;


import com.pact.test.model.User;
import com.pact.test.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;

@Component
public class UserService {

    @Autowired
    UserDAO userDAO;

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public void modifyUser(String id, String username, String password,String oldUsername) {
        String pathName="C:\\Users\\Piotr\\Documents\\ProgramUsers\\" + oldUsername;
        File file = new File(pathName);
        deleteUsersFiles(file);
        pathName="C:\\Users\\Piotr\\Documents\\ProgramUsers\\" + username;
        createDirectoryForUser(pathName,id,username,password);
        userDAO.modifyUser(id, username, password);
    }

    public void addUser(String id, String username, String password) {
        int newID = userDAO.getLastID();
        newID++;
        User newUser = new User(newID, username, password);
        createDirectoryForUser(newUser);
        userDAO.addUser(newUser);
    }

    private void createDirectoryForUser(User newUser) {
        File directory = new File("C:\\Users\\Piotr\\Documents\\ProgramUsers\\" + newUser.getUsername());
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                String filePath="C:\\Users\\Piotr\\Documents\\ProgramUsers\\" + newUser.getUsername() + "\\" + newUser.getUsername() + ".txt";
                createUsersDataFile(filePath,newUser.getUserdbID().toString(),newUser.getUsername(),newUser.getPassword());
            } else {
                System.out.println("Błąd przy tworzeniu katalogu dla użytkownika");
            }
        }
    }

    private void createDirectoryForUser(String path,String id,String username,String password) {
        File directory = new File(path);
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                String filePath = "C:\\Users\\Piotr\\Documents\\ProgramUsers\\" + username + "\\" + username + ".txt";
                createUsersDataFile(filePath, id, username, password);
            } else {
                System.out.println("Błąd przy tworzeniu katalogu dla użytkownika");
            }
        }
    }

    private void createUsersDataFile(String path,String id,String username,String password){
        File file = new File(path);
        FileWriter writer;
        try {
            writer = new FileWriter(file);
            writer.write(id + '\n');
            writer.write(username + '\n');
            writer.write(password);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String id, String username) {
        File file = new File("C:\\Users\\Piotr\\Documents\\ProgramUsers\\" + username);
        deleteUsersFiles(file);
        userDAO.deleteUser(id);
    }

    private void deleteUsersFiles(File file) {
        if (file.isDirectory()) {
            File[] entries = file.listFiles();
            if (entries != null) {
                for (File entry : entries) {
                    deleteUsersFiles(entry);
                }
            }
        }
        if (!file.delete()) {
            System.out.println("Błąd przy usuwaniu pliku");
        }
    }

    public void addSQLParams(String selectedParam, String selectedValue, String usernameFiltr, String passwordFilter) {
        if(selectedValue.equals("rosnąco")){
            selectedValue="ASC";
        }
        else{
            selectedValue="DESC";
        }
        userDAO.setSelectionParam(selectedParam);
        userDAO.setSelectionValue(selectedValue);
        userDAO.setUsernameFilter(usernameFiltr);
        userDAO.setPasswordFilter(passwordFilter);
    }
}

