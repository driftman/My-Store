package com.ibm.mystore.data.network.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.ibm.mystore.data.network.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abk on 05/05/2018.
 */

public class ItemsResponse implements Parcelable {

    @SerializedName("data")
    private ArrayList<Item> data;


    protected ItemsResponse(Parcel in) {
        data = in.createTypedArrayList(Item.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(data);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ItemsResponse> CREATOR = new Creator<ItemsResponse>() {
        @Override
        public ItemsResponse createFromParcel(Parcel in) {
            return new ItemsResponse(in);
        }

        @Override
        public ItemsResponse[] newArray(int size) {
            return new ItemsResponse[size];
        }
    };

    public ArrayList<Item> getData() {
        return data;
    }


}
