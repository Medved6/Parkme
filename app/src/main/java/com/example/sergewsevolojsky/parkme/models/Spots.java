package com.example.sergewsevolojsky.parkme.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by sergewsevolojsky on 13/06/16.
 */
public class Spots implements Parcelable{


    String  street,
            city,
            vehicle;

    float lat;
    float lon;

    int rate;
    int price;
    int id;

    protected Spots(Parcel in) {
        street = in.readString();
        city = in.readString();
        vehicle = in.readString();
        lat = in.readFloat();
        lon = in.readFloat();
        rate = in.readInt();
        price = in.readInt();
        id = in.readInt();
        distance = in.readInt();
        safe = in.readByte() != 0;
        inside = in.readByte() != 0;
        streetNumber = in.readString();
        zipCode = in.readString();
        imgUrl = in.readString();
        owner = in.createTypedArrayList(Owner.CREATOR);
        rental = in.createTypedArrayList(Rental.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(street);
        dest.writeString(city);
        dest.writeString(vehicle);
        dest.writeFloat(lat);
        dest.writeFloat(lon);
        dest.writeInt(rate);
        dest.writeInt(price);
        dest.writeInt(id);
        dest.writeInt(distance);
        dest.writeByte((byte) (safe ? 1 : 0));
        dest.writeByte((byte) (inside ? 1 : 0));
        dest.writeString(streetNumber);
        dest.writeString(zipCode);
        dest.writeString(imgUrl);
        dest.writeTypedList(owner);
        dest.writeTypedList(rental);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Spots> CREATOR = new Creator<Spots>() {
        @Override
        public Spots createFromParcel(Parcel in) {
            return new Spots(in);
        }

        @Override
        public Spots[] newArray(int size) {
            return new Spots[size];
        }
    };

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    int distance;

    boolean safe, inside;

    public Spots() {
    }

    @JsonProperty("streetNumber")
    private String streetNumber;

    @JsonProperty("zipCode")
    private String zipCode;

    @JsonProperty("imgUrl")
    private String imgUrl;

    public ArrayList<Owner> owner;
    public ArrayList<Rental> rental;


    public static class Owner implements Parcelable{


        String firstname, lastname, email, phone;

        public Owner() {
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
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

        protected Owner(Parcel in) {
            firstname = in.readString();
            lastname = in.readString();
            email = in.readString();
            phone = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(firstname);
            dest.writeString(lastname);
            dest.writeString(email);
            dest.writeString(phone);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<Owner> CREATOR = new Creator<Owner>() {
            @Override
            public Owner createFromParcel(Parcel in) {
                return new Owner(in);
            }

            @Override
            public Owner[] newArray(int size) {
                return new Owner[size];
            }
        };
    }

    public static class Rental implements Parcelable{

        int id, status;
        int rentBy;

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

        int rentalPrice;
        ReservationDate arrival, departure;

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

        public ReservationDate getArrival() {
            return arrival;
        }

        public void setArrival(ReservationDate arrival) {
            this.arrival = arrival;
        }

        public ReservationDate getDeparture() {
            return departure;
        }

        public void setDeparture(ReservationDate departure) {
            this.departure = departure;
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

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSafe() {
        return safe;
    }

    public void setSafe(boolean safe) {
        this.safe = safe;
    }

    public boolean isInside() {
        return inside;
    }

    public void setInside(boolean inside) {
        this.inside = inside;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public ArrayList<Owner> getOwner() {
        return owner;
    }

    public void setOwner(ArrayList<Owner> owner) {
        this.owner = owner;
    }

    public ArrayList<Rental> getRental() {
        return rental;
    }

    public void setRental(ArrayList<Rental> rental) {
        this.rental = rental;
    }



}
