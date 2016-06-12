package com.example.sergewsevolojsky.parkme.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Array;

/**
 * Created by Tom on 08/06/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Parcelable {

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "id")
    private String id;

    @JsonProperty(value = "imgUrl")
    private String imgUrl;

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "phone")
    private String phone;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty(value = "password")
    private String password;




    // Default constructor
    public User() {
        ;
    }

    // Parcelable constructor
    public User(Parcel in){
        readFromParcel(in);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(name);
        dest.writeString(id);
        dest.writeString(imgUrl);
        dest.writeString(email);
        dest.writeString(phone);
        dest.writeString(password);
    }

    private void readFromParcel(Parcel in){
        name = in.readString();
        id = in.readString();
        imgUrl   = in.readString();
        email   = in.readString();
        phone   = in.readString();
        password   = in.readString();
    }

    public static final Parcelable.Creator CREATOR =
            new Parcelable.Creator() {
                public User createFromParcel(Parcel in) {
                    return new User(in);
                }

                public User[] newArray(int size) {
                    return new User[size];
                }
            };
}