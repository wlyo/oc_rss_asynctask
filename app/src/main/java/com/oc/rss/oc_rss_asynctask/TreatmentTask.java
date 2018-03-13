package com.oc.rss.oc_rss_asynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by wlyd on 12/03/2018.
 */

public class TreatmentTask extends AsyncTask<Integer, Void, String> {

    private final TextView _textView;
    private boolean running = true;

    public TreatmentTask(TextView textView) {
        _textView = textView;
    }

    @Override
    protected void onCancelled() {
        running = false;
    }



    @Override
    protected String doInBackground(Integer... integers) {
        int seconds = integers[0];

        try { Thread.sleep(seconds * 1000); }
        catch (InterruptedException ignored) {}

        return "Coucou le monde";
    }

    @Override
    protected void onPostExecute(String result) {
        _textView.setText(result);
    }
}
