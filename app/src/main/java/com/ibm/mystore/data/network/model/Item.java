package com.ibm.mystore.data.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Soufiane ELBAZ on 05/05/2018.
 */

public class Item implements Parcelable{


    @SerializedName("itemId")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private Description description;
    @SerializedName("value")
    private String value;
    @SerializedName("currency")
    private String currency;

    public Item() {}

    protected Item(Parcel in) {
        id = in.readString();
        title = in.readString();
        description = in.readParcelable(Description.class.getClassLoader());
        value = in.readString();
        currency = in.readString();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(title);
        parcel.writeParcelable(description, i);
        parcel.writeString(value);
        parcel.writeString(currency);
    }
}
