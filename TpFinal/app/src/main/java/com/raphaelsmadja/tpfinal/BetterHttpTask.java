package com.raphaelsmadja.tpfinal;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by raphi on 05/10/2017.
 */

public class BetterHttpTask extends AsyncTask<String, Long, String> {
    TextView textView;

    public BetterHttpTask(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected String doInBackground(String... params) {
        String valueToReturn = "";
        try {
            URL url = new URL(params[0]);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            //Config
            httpURLConnection.setConnectTimeout(1500);
            httpURLConnection.setRequestMethod("GET");
            //....
            httpURLConnection.connect();
            //status
            int statusCode = httpURLConnection.getResponseCode();

            //Body
            InputStream is = httpURLConnection.getInputStream();
            InputStreamReader isReader = new InputStreamReader(is);
            //
            BufferedReader bufferedReader = new BufferedReader(isReader);
            String line = null;
            while ((line= bufferedReader.readLine()) != null) {
                valueToReturn += line+"\n";
                publishProgress(Long.valueOf(valueToReturn.length()));
            }
        }catch (Exception e) {
            e.printStackTrace();
            valueToReturn = e.getLocalizedMessage();
        }finally {

        }
        return valueToReturn;
    }

    @Override
    protected void onProgressUpdate(Long... values) {
        super.onProgressUpdate(values);
        textView.setText("Read : " + values[0].toString()+" characters");
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        textView.setText(s);
    }
}

