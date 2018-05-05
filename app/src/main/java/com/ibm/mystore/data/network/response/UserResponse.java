package com.ibm.mystore.data.network.response;

import com.elbaz.mydaggerapplication.data.network.model.User;
import com.google.gson.annotations.SerializedName;

/**
 * Created by abk on 12/04/2018.
 */

public class UserResponse {

    @SerializedName("code")
    private Integer code;
    @SerializedName("user")
    private User    user;

    public UserResponse(Integer code, User user) {
        this.code = code;
        this.user = user;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
