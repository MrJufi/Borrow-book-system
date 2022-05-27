package com.example.quiz1jufianto.database;

import java.util.Vector;

public class DB {

    public static String logInUser;

    public static String getLogInUser() {
        return logInUser;
    }

    public static void setLogInUser(String logInUser) {
        DB.logInUser = logInUser;
    }

    public static Vector<User> listUser = new Vector<>();

    public static Vector<Request> requestList = new Vector<>();

    public static void addNewUser(String id, String email, String password, String phone, String dob){
        User user = new User(id, email, password, phone, dob);
        listUser.add(user);
    }

    public static void addNewRequest(String bookId, String requesterEmail, String receiverEmail){
        Request request = new Request(bookId, requesterEmail, receiverEmail);
        requestList.add(request);
    }

}
