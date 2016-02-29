package com.mehmetzantur.sifrekasa.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.mehmetzantur.sifrekasa.Model.DBHelper;
import com.mehmetzantur.sifrekasa.R;

public class SplashActivity extends Activity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        final DBHelper db = new DBHelper(getApplicationContext());
        Thread SplashScreen = new Thread() {
          public void run(){

              try{
                  sleep(5000);
                  startActivity(new Intent(getApplicationContext(), LoginActivity.class));
              }

              catch (InterruptedException e) {
                  e.printStackTrace();
              }

              finally {
                  //finish();
              }
          }
        };

        SplashScreen.start();

    }
}
