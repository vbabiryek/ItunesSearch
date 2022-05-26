package com.example.itunessearch;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import com.example.itunessearch.adapters.ArtistAdapter;
import com.example.itunessearch.models.Artist;
import com.google.android.material.textfield.TextInputEditText;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private ProgressBar progressBar;
    private TextInputEditText editText;
    private Button button;
    private String artistNameString;
    private RecyclerView recyclerView;
    private final List<Artist> artistDataArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);

        //Inflates layout for our actionbar menu
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.search, null);
        actionBar.setCustomView(view);

        progressBar = findViewById(R.id.progress_bar);
        editText = findViewById(R.id.artist_edit_txt);
        button = findViewById(R.id.search_button);
        recyclerView = findViewById(R.id.recycler_view);

        ArtistAdapter artistAdapter = new ArtistAdapter(artistDataArrayList);

        button.setOnClickListener(v -> {
            //Grabs our edittext input
            artistNameString = editText.getText().toString();
            progressBar.setVisibility(View.VISIBLE);

            //Avoids making request on main thread.
            Thread thread = new Thread(() -> {
                String url = "https://itunes.apple.com/search?term="+ artistNameString +"";

                OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
                Request request = new Request.Builder()
                        .url(url)
                        .build();

                System.out.println("request is: " + request);
                try {
                    Response response = okHttpClient.newCall(request).execute();
                    if(response.isSuccessful()){
                        ResponseBody responseBody = response.body();
                        String bodyStr = responseBody.string();

                        JSONObject jsonObject = new JSONObject(bodyStr);
                        System.out.println("bodyStr" + bodyStr);
                        JSONArray jsonArray = jsonObject.getJSONArray("results");

                        //Iterates through our response array and adds each element to our recyclerview list
                        for(int i = 0; i < jsonArray.length(); i++){
                            System.out.println("jsonArray.getJSONObject(i) " + jsonArray.getJSONObject(i));
                            Artist artist = new Artist(jsonArray.getJSONObject(i).getString("artistName"),
                                    jsonArray.getJSONObject(i).getString("trackName"),
                                    jsonArray.getJSONObject(i).getString("releaseDate"),
                                    jsonArray.getJSONObject(i).getString("primaryGenreName"),
                                    jsonArray.getJSONObject(i).getString("trackPrice"));
                            artistDataArrayList.add(artist);
                        }

                        //Runs back on main thread to access views created there
                        runOnUiThread(() -> {
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                            recyclerView.setLayoutManager(linearLayoutManager);
                            recyclerView.setAdapter(artistAdapter);
                            progressBar.setVisibility(View.GONE);
                        });
                    }
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
            //Clears our old list in recyclerview
            artistDataArrayList.clear();
            //Updates with new list in recyclerview
            artistAdapter.notifyDataSetChanged();
        });
    }

}