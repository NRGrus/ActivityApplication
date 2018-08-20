package com.example.ruslan.activityapplication;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Product implements Parcelable{//Serializable {
    private String name;
    private String company;
    private int price;

    public Product(String name, String company, int price) {
        this.name = name;
        this.company = company;
        this.price = price;
    }

    protected Product(Parcel in) {
        name = in.readString();
        company = in.readString();
        price = in.readInt();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            String name = in.readString();
            String company = in.readString();
            int price = in.readInt();
            return new Product(name, company, price);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(company);
        dest.writeInt(price);
    }
}
