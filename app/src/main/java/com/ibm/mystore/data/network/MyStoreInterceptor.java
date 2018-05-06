package com.ibm.mystore.data.network;

import android.content.Context;

import com.ibm.mystore.BuildConfig;

import java.io.IOException;
import java.io.InputStream;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by abk on 06/05/2018.
 */

public class MyStoreInterceptor implements Interceptor {

    private Context context;

    public MyStoreInterceptor(Context context) {
        this.context = context;
    }


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = null;
        if(BuildConfig.DEBUG) {
            String fakeResponse = getFakeResponse();
            response = new Response.Builder()
                    .code(200)
                    .message(fakeResponse)
                    .request(chain.request())
                    .protocol(Protocol.HTTP_1_0)
                    .body(ResponseBody.create(MediaType.parse("application/json"), fakeResponse.getBytes()))
                    .addHeader("content-type", "application/json")
                    .build();
        } else {
            response = chain.proceed(request);
        }
        return response;
    }

    private String getFakeResponse() {
        try {
            InputStream is = context.getAssets().open("response.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            return new String(buffer, "UTF-8");
        } catch(IOException e) {
            return null;
        }
    }
}
