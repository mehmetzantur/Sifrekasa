package com.mehmetzantur.sifrekasa.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Window;

import com.mehmetzantur.sifrekasa.R;

public class SignupActivity extends Activity {


    @Override
    public void onBackPressed() {
        final AlertDialog.Builder alert = new AlertDialog.Builder(SignupActivity.this);
        alert.setMessage("Uygulamadan çıkmak istiyor mu sunuz?");
        alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                moveTaskToBack(true);
                //android.os.Process.killProcess(android.os.Process.myPid());
            }
        }).setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setFinishOnTouchOutside(false);
        setContentView(R.layout.activity_signup);

    }


}
