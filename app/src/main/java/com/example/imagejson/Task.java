package com.example.imagejson;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Task extends AsyncTask<String, Void, String> {
    Second mainActivity;

    ProgressDialog dialog;

    public Task(Second mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    protected String doInBackground(String... strings) {

        try {
            URL url = new URL(strings[0]);


            HttpURLConnection con = (HttpURLConnection) url.openConnection();


            InputStream stream = con.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();


            String line = "";

            while (line != null) {

                line = reader.readLine();
                buffer.append(line);


            }
            return buffer.toString();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();


        dialog = new ProgressDialog(mainActivity);

        dialog.setMessage("Wait Some Time...");
        dialog.setTitle("Downloadind");

        dialog.show();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        dialog.dismiss();
        //Toast.makeText(mainActivity, ""+s, Toast.LENGTH_SHORT).show();

        List<poso> data = new ArrayList<>();

        try {
            JSONObject first = new JSONObject(s);
            JSONArray arr = first.getJSONArray("hits");

            for (int i = 0; i <= arr.length(); i++) {
                JSONObject object = arr.getJSONObject(i);

                String imgurl = object.getString("userImageURL");
                int downls = object.getInt("downloads");

                poso reso;

                reso = new poso(imgurl, downls);

                data.add(reso);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        mainActivity.recyclerView.setAdapter(new RecAdapter(mainActivity, data));


    }


}