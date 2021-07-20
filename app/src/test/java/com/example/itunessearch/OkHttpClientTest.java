package com.example.itunessearch;

import org.junit.Test;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpClientTest {
    Request request;
    Response response;

    //Test to confirm our API request will be successful
    @Test
    public void UrlTest() throws Exception{
        OkHttpClient okHttpClient = new OkHttpClient();

        request = new Request.Builder()
                .url("https://itunes.apple.com/search?term=Bob%20Marley")
                .build();

        response = okHttpClient.newCall(request).execute();
        System.out.println(response.isSuccessful());
    }
}
