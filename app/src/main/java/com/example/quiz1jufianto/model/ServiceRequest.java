package com.example.quiz1jufianto.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ServiceRequest implements Parcelable{
    private  String title, author, synopsis, requester, receiver;
    private int cover;

    public ServiceRequest(String title, String author, String synopsis, String requester, String receiver, int cover) {
        this.title = title;
        this.author = author;
        this.requester = requester;
        this.receiver = receiver;
        this.cover = cover;
        this.synopsis = synopsis;
    }

    protected ServiceRequest(Parcel in) {
        title = in.readString();
        author = in.readString();
        synopsis = in.readString();
        requester = in.readString();
        receiver = in.readString();
        cover = in.readInt();
    }

    public static final Creator<ServiceRequest> CREATOR = new Creator<ServiceRequest>() {
        @Override
        public ServiceRequest createFromParcel(Parcel in) {
            return new ServiceRequest(in);
        }

        @Override
        public ServiceRequest[] newArray(int size) {
            return new ServiceRequest[size];
        }
    };

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public int getCover() {
        return cover;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(author);
        parcel.writeString(synopsis);
        parcel.writeString(requester);
        parcel.writeString(receiver);
        parcel.writeInt(cover);
    }
}
