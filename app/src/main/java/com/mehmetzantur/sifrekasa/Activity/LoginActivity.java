package com.mehmetzantur.sifrekasa.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mehmetzantur.sifrekasa.Model.DBHelper;
import com.mehmetzantur.sifrekasa.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class LoginActivity extends Activity {



    SlidingMenu menu;

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder alert = new AlertDialog.Builder(LoginActivity.this);
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

    protected void showInputDialog() {
        final DBHelper db = new DBHelper(getApplicationContext());

        // get prompts.xml view
        LayoutInflater layoutInflater = LayoutInflater.from(LoginActivity.this);
        final View promptView = layoutInflater.inflate(R.layout.activity_signup, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(LoginActivity.this);
        alertDialogBuilder.setView(promptView);

        //final EditText editText = (EditText) promptView.findViewById(R.id.edittext);
        // setup a dialog window
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("Kaydet", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        final EditText txtPass = (EditText) promptView.findViewById(R.id.txtPass);
                        final EditText txtPassRe = (EditText) promptView.findViewById(R.id.txtPassRe);
                        AlertDialog.Builder alert = new AlertDialog.Builder(LoginActivity.this);

                        if (TextUtils.isEmpty(txtPass.getText()) || TextUtils.isEmpty(txtPassRe.getText())) {
                            Toast.makeText(LoginActivity.this, "Alanları boş bırakmayın!", Toast.LENGTH_LONG).show();
                            showInputDialog();
                        } else {
                            if (txtPass.getText().toString().equals(txtPassRe.getText().toString())) {
                                String msg = db.SignupUser(txtPass.getText().toString());
                                if (msg.equals("ok")) {
                                    alert.setTitle("Oluşturuldu!");
                                    alert.setMessage("Şifreniz " + txtPass.getText() + " olarak oluşturuldu.");
                                    alert.setCancelable(false);
                                    alert.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                                            Toast.makeText(LoginActivity.this, "Şifrenizi istediğiniz zaman ayarlardan değiştirebilisiniz.", Toast.LENGTH_LONG).show();
                                        }
                                    });
                                    alert.show();
                                }
                            } else {
                                Toast.makeText(LoginActivity.this, "Şifreler uyuşmuyor!", Toast.LENGTH_LONG).show();
                                showInputDialog();
                            }
                        }
                    }
                });

        // create an alert dialog
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

/*  SLIDING MENU
        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidth(5);
        menu.setFadeDegree(0.0f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setBehindWidth(500);
        menu.setMenu(R.layout.splash_screen);



        Button ib = (Button) findViewById(R.id.btnMenuAc);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


              menu.toggle();



            }
        });

*/

        final DBHelper db = new DBHelper(getApplicationContext());


        if (!db.HasAdmin()) {
            showInputDialog();
        }


        final EditText txtAdminPass = (EditText) findViewById(R.id.txtAdminPass);
        txtAdminPass.setFocusableInTouchMode(true);
        txtAdminPass.requestFocus();
        final String AdminPass = db.GetAdminPass();
        txtAdminPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (txtAdminPass.getText().toString().equals(AdminPass)) {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        Button btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumToPass("1");
            }
        });

        Button btn2 = (Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumToPass("2");
            }
        });

        Button btn3 = (Button)findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumToPass("3");
            }
        });

        Button btn4 = (Button)findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumToPass("4");
            }
        });

        Button btn5 = (Button)findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumToPass("5");
            }
        });

        Button btn6 = (Button)findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumToPass("6");
            }
        });

        Button btn7 = (Button)findViewById(R.id.btn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumToPass("7");
            }
        });

        Button btn8 = (Button)findViewById(R.id.btn8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumToPass("8");
            }
        });

        Button btn9 = (Button)findViewById(R.id.btn9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumToPass("9");
            }
        });

        Button btn0 = (Button)findViewById(R.id.btn0);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumToPass("0");
            }
        });

        Button btnDelete = (Button)findViewById(R.id.btnDelete);
        Typeface fontbtnDelete = Typeface.createFromAsset( getAssets(), "fontawesome-webfont.ttf" );
        btnDelete.setTypeface(fontbtnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int length = txtAdminPass.getText().length();
                if (length > 0) {
                    txtAdminPass.getText().delete(length - 1, length);
                }
            }
        });


        Button btnAbout = (Button)findViewById(R.id.btnAbout);
        Typeface fontbtnAbout = Typeface.createFromAsset( getAssets(), "fontawesome-webfont.ttf" );
        btnAbout.setTypeface(fontbtnAbout);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    private void AddNumToPass(String getNum){
        EditText txtAdminPass = (EditText) findViewById(R.id.txtAdminPass);
        txtAdminPass.setText(txtAdminPass.getText() + getNum);
    }

}



