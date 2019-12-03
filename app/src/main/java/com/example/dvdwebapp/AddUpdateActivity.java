package com.example.dvdwebapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.dvdwebapp.model.DVD;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class AddUpdateActivity extends AppCompatActivity {

    Gson gson = new Gson;

    EditText edTitle, edGenre, edYear;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_update);

        edTitle = findViewById(R.id.editTextDvdTitle);
        edGenre = findViewById(R.id.editTextDvdGenre);
        edYear = findViewById(R.id.editTextDvdYear);
        btnSave = findViewById(R.id.buttonSave);
    }

    public void addDvd(View v) {

        String title = edTitle.getText().toString();
        String genre = edGenre.getText().toString();
        int year = Integer.valueOf(edYear.getText().toString();

        DVD dvd = new DVD(0, title, genre, year);
        String json = gson.toJson(dvd);
        //"http://10.0.2.2:8080/DVDWebApp/APIServlet"
    }

    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
               =
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    });
}
