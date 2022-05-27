package com.example.quiz1jufianto.database;

public class Request {

    //DATABASE Request or ERD Request

    private String bookId, requesterEmail, receiverEmail;

    public Request(String bookId, String requesterEmail, String receiverEmail) {
        this.bookId = bookId;
        this.requesterEmail = requesterEmail;
        this.receiverEmail = receiverEmail;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getRequesterEmail() {
        return requesterEmail;
    }

    public void setRequesterEmail(String requesterId) {
        this.requesterEmail = requesterId;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverId) {
        this.receiverEmail = receiverId;
    }
}
