package com.oc.rss.oc_rss_asynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);
        findViewById(R.id.imageView).startAnimation(animation);

        final Button button = findViewById(R.id.button);
        final TextView textView = findViewById(R.id.textView);

        /* Méthode avec Thread
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Thread thread = new Thread(){

                    @Override
                    public void run() {

                        try { Thread.sleep(2000); }
                        catch (InterruptedException ignored) {}

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                textView.setText("Coucou le monde");
                            }
                        });
                    }
                };

                thread.start();
            }
        });
        */

        //Méthode AsyncTask
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final TreatmentTask task = new TreatmentTask(textView);

                task.execute(2);
            }
        });
    }
}
