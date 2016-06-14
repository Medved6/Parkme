package com.example.sergewsevolojsky.parkme.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;

/**
 * Created by sergewsevolojsky on 13/06/16.
 */
public class ReservationDate implements Parcelable {

    private String day, month, year;

    private String[] monthes = {"Jan","Feb","Mar","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return this.monthes[Integer.parseInt(month)];
    }

    public void setMonth(String month) {

        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ReservationDate() {

    }

    protected ReservationDate(Parcel in) {
        day = in.readString();
        month = in.readString();
        year = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(day);
        dest.writeString(month);
        dest.writeString(year);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ReservationDate> CREATOR = new Creator<ReservationDate>() {
        @Override
        public ReservationDate createFromParcel(Parcel in) {
            return new ReservationDate(in);
        }

        @Override
        public ReservationDate[] newArray(int size) {
            return new ReservationDate[size];
        }
    };
}
