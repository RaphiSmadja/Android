package com.raphaelsmadja.tpfinal;

import android.os.AsyncTask;
import android.renderscript.Long2;
import android.widget.TextView;

/**
 * Created by raphi on 05/10/2017.
 */

public class IncrementeurTask extends AsyncTask<Long,Long, String>{
    TextView textView;

    public IncrementeurTask(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        textView.setText("");
    }

    @Override
    protected String doInBackground(Long... params) {
        Long maxValue = params[0];
        long increment = 0;
        while (increment<maxValue){
            increment++;
            if (increment%500 == 0){
                publishProgress(increment);
            }
        }
        return "Increment is finish";
    }

    @Override
    protected void onProgressUpdate(Long... values) {
        super.onProgressUpdate(values);
        textView.setText(values[0].toString());
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        textView.setText(s);
    }
}
