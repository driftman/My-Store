package com.ibm.mystore.data.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Soufiane ELBAZ on 05/05/2018.
 */

public class Description implements Parcelable {

    @SerializedName("en-CA")
    private String enCA;
    @SerializedName("fr-CA")
    private String frCA;

    public Description() {
    }

    public String getEnCA() {
        return enCA;
    }

    public void setEnCA(String enCA) {
        this.enCA = enCA;
    }

    public String getFrCA() {
        return frCA;
    }

    public void setFrCA(String frCA) {
        this.frCA = frCA;
    }

    protected Description(Parcel in) {
        enCA = in.readString();
        frCA = in.readString();
    }

    public static final Creator<Description> CREATOR = new Creator<Description>() {
        @Override
        public Description createFromParcel(Parcel in) {
            return new Description(in);
        }

        @Override
        public Description[] newArray(int size) {
            return new Description[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(enCA);
        parcel.writeString(frCA);
    }
}
