package com.alotitokehoe.utn.quefrio;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;


public class ClimaOnline extends AsyncTask<String, String, String> {

    AppCompatActivity mainActivity;
    ProgressDialog pd;
    String ciudad;

    public ClimaOnline(AppCompatActivity main) {
        this.mainActivity = main;
    }

    protected void onPreExecute() {
        super.onPreExecute();

        pd = new ProgressDialog(this.mainActivity);
        pd.setMessage("Consultado clima");
        pd.setCancelable(false);
        pd.show();
    }

    protected String doInBackground(String... params) {

        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            this.ciudad = params[0];
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + params[0] + ",ar&appid=2c0063ce6ac7e3ab1058868cf9dea46a");
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream stream = connection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();
            String line = "";

            while ((line = reader.readLine()) != null) {
                buffer.append(line+"\n");
            }

            return buffer.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (pd.isShowing()){
            pd.dismiss();
        }

        try {
            JSONObject resultJson = new JSONObject(result);
            JSONObject main_object = resultJson.getJSONObject("main");
            Double temperatura = main_object.getDouble("temp") - 273.15;
            String temp = String.format("%.1f", temperatura);
            //String temp = String.valueOf(temperatura);
            Toast.makeText(this.mainActivity.getApplicationContext(),"Temperatura en " + this.ciudad + ": " + temp + "°",Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}