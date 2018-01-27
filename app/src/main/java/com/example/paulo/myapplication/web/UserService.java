package com.example.paulo.myapplication.web;

import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by paulo on 27/01/18.
 */

public class UserService extends AsyncTask<String, String, String> {

    private final String URL_API = "http://private-c9c06-helloandroid.apiary-mock.com";

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    private OkHttpClient client = new OkHttpClient();


    @Override
    protected String doInBackground(String... string) {
        RequestBody body = RequestBody.create(JSON, userJson("asdas", "dsf"));
        Request request = new Request.Builder()
                .url(URL_API)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }catch (IOException e){}
        return null;
    }

    String userJson(String id, String name) {
        return "{'id':'"+ id +"',"
                + "'name':'"+ name +"'"
                + "}";
    }

}