package com.example.sergewsevolojsky.parkme.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;

/**
 * Created by sergewsevolojsky on 13/06/16.
 */
public class ReservationDate implements Parcelable {

    private int day, month, year;

    private String[] monthes = {"Jan","Feb","Mar","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getMonth() {
        return this.monthes[month];
    }

    public void setMonth(int month) {

        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ReservationDate() {

    }

    protected ReservationDate(Parcel in) {
        day = in.readInt();
        month = in.readInt();
        year = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(day);
        dest.writeInt(month);
        dest.writeInt(year);
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
