package com.example.sergewsevolojsky.parkme.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by sergewsevolojsky on 08/06/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Reservation implements Parcelable{

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @JsonProperty(value = "street")
    private String street;

    @JsonProperty(value = "city")
    private String city;


    @JsonProperty(value = "zip_code")
    private String zipCode;


    // Default constructor
    public Reservation() {

    }

    // Parcelable constructor
    public Reservation(Parcel in){
        readFromParcel(in);
    }



    private void readFromParcel(Parcel in) {
        street = in.readString();
        city = in.readString();
        zipCode = in.readString();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(street);
        dest.writeString(city);
        dest.writeString(zipCode);
    }


    public static final Parcelable.Creator CREATOR =
            new Parcelable.Creator() {
                public Reservation createFromParcel(Parcel in) {
                    return new Reservation(in);
                }

                public Reservation[] newArray(int size) {
                    return new Reservation[size];
                }
            };


}
