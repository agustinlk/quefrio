package com.alotitokehoe.utn.quefrio;



import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;

public class ApiTemperatura  {

    AppCompatActivity activity;
    public ApiTemperatura(AppCompatActivity activity) {
        this.activity = activity;
    }

    public String consultarTemperatura(String ciudad){
        String url = "http://api.openweathermap.org/data/2.5/weather?q=cordoba,ar&appid=2c0063ce6ac7e3ab1058868cf9dea46a";
        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url,  null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject main_object = response.getJSONObject("main");
                    JSONArray array = response.getJSONArray("weather");
                    JSONObject object = array.getJSONObject(0);
                    String temp = String.valueOf(main_object.getDouble("temp"));
                    int a = 1;

                } catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        RequestQueue queue = Volley.newRequestQueue(this.activity);
        queue.add(jor);
        return "aaa";
    }
}
