package com.example.quiz1jufianto.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Service implements Parcelable {

    //DATABASE Book or ERD Book

    private String title, author, synopsis;
    private int img;

    public Service(String title, String author, String synopsis, int img) {
        this.title = title;
        this.author = author;
        this.synopsis = synopsis;
        this.img = img;
    }

    protected Service(Parcel in) {
        title = in.readString();
        author = in.readString();
        synopsis = in.readString();
        img = in.readInt();
    }

    public static final Creator<Service> CREATOR = new Creator<Service>() {
        @Override
        public Service createFromParcel(Parcel in) {
            return new Service(in);
        }

        @Override
        public Service[] newArray(int size) {
            return new Service[size];
        }
    };

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

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
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
        parcel.writeInt(img);
    }

}
