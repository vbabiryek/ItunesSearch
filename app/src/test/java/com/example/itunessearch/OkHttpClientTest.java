package com.example.itunessearch;

import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.mockito.Mock;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpClientTest {

    OkHttpClient okHttpClient = new OkHttpClient();

//    Can not work
//    OkHttpClient.Builder okHttpClient = mock(OkHttpClient.Builder.class);

//    Test to confirm our API request will be successful
    @Test
    public void UrlTest() throws Exception{

        Request request = new Request.Builder()
                .url("https://itunes.apple.com/search?term=Bob%20Marley")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        System.out.println(response.isSuccessful());
    }

//    Example test that will NOT work on a mock of a final class unit - this is why it's imperative
//    to have proper and efficient code architecture(s) like MVP or MVVM

//    @Test
//    public void UrlTestTwo() throws  Exception{
//
//        Request request = new Request.Builder()
//                .url("https://itunes.apple.com/search?term=Bob%20Marley")
//                .build();
//
//        Response response = okHttpClient.build().newCall(request).execute();
//        System.out.println(response.isSuccessful());
//    }
}
