package com.ibm.mystore.data.network.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.ibm.mystore.data.network.model.Item;

import java.util.List;

/**
 * Created by abk on 05/05/2018.
 */

public class ItemsResponse implements Parcelable {

    @SerializedName("data")
    private List<Item> data;


    protected ItemsResponse(Parcel in) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
