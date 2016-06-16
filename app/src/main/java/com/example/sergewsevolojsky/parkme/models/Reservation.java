package com.example.sergewsevolojsky.parkme.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergewsevolojsky on 08/06/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Reservation implements Parcelable {


    @JsonProperty(value = "spotId")
    private int spotId;

    @JsonProperty(value = "street")
    private String street;

    @JsonProperty(value = "city")
    private String city;


    @JsonProperty(value = "zipCode")
    private String zipCode;

    @JsonProperty(value = "rental")
    public Rental rental;

    public Reservation() {
    }


    protected Reservation(Parcel in) {
        spotId = in.readInt();
        street = in.readString();
        city = in.readString();
        zipCode = in.readString();
        rental = in.readParcelable(Rental.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(spotId);
        dest.writeString(street);
        dest.writeString(city);
        dest.writeString(zipCode);
        dest.writeParcelable(rental, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Reservation> CREATOR = new Creator<Reservation>() {
        @Override
        public Reservation createFromParcel(Parcel in) {
            return new Reservation(in);
        }

        @Override
        public Reservation[] newArray(int size) {
            return new Reservation[size];
        }
    };

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }







    public static class Rental implements Parcelable {
        private int id;
        private int status;
        private int rentBy;

        protected Rental(Parcel in) {
            id = in.readInt();
            status = in.readInt();
            rentBy = in.readInt();
            rentalPrice = in.readInt();
            arrival = in.readParcelable(ReservationDate.class.getClassLoader());
            departure = in.readParcelable(ReservationDate.class.getClassLoader());
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(id);
            dest.writeInt(status);
            dest.writeInt(rentBy);
            dest.writeInt(rentalPrice);
            dest.writeParcelable(arrival, flags);
            dest.writeParcelable(departure, flags);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<Rental> CREATOR = new Creator<Rental>() {
            @Override
            public Rental createFromParcel(Parcel in) {
                return new Rental(in);
            }

            @Override
            public Rental[] newArray(int size) {
                return new Rental[size];
            }
        };

        public int getRentalPrice() {
            return rentalPrice;
        }

        public void setRentalPrice(int rentalPrice) {
            this.rentalPrice = rentalPrice;
        }

        private int rentalPrice;




        public ReservationDate arrival;



        public ReservationDate departure;


        public ReservationDate getDeparture() {
            return departure;
        }

        public void setDeparture(ReservationDate departure) {
            this.departure = departure;
        }


        public ReservationDate getArrival() {
            return arrival;
        }

        public void setArrival(ReservationDate arrival) {
            this.arrival = arrival;
        }

        public Rental() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getRentBy() {
            return rentBy;
        }

        public void setRentBy(int rentBy) {
            this.rentBy = rentBy;
        }

    }





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

    public int getSpotId() {
        return spotId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }


}


