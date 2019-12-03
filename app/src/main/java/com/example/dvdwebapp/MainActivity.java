package com.example.dvdwebapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dvdwebapp.model.DVD;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Gson gson = new Gson();

    RecyclerView recyclerView;
    DvdRecycleAdapter dvdRecycleAdapter;
    RecyclerView.LayoutManager layoutManager;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RVdvd);
        layoutManager = new LinearLayoutManager(this);

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://10.0.2.2:8080/DVDWebApp/APIServlet?apikey=abc123";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        //textView.setText("Response is: " + response.substring(0, 500));
                        Log.i(TAG, "onResponse: " + response);
                        ArrayList<DVD> allDvds = processJson(response);

                        for (DVD dvd: allDvds){
                            Log.i(TAG, "onResponse: " + dvd.getTitle());
                        }
                        dvdRecycleAdapter = new DvdRecycleAdapter(allDvds);
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setAdapter(dvdRecycleAdapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               // textView.setText("That didn't work!");
                Log.e(TAG, "onErrorResponse: " + error );
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    private ArrayList<DVD> processJson (String json){

        return gson.fromJson(json, new TypeToken<List<DVD>>(){}.getType());
    }
}
