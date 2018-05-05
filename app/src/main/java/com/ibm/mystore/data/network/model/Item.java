package com.ibm.mystore.data.network.model;

import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Soufiane ELBAZ on 05/05/2018.
 */

public class Item {


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

}
