package com.mehmetzantur.sifrekasa.Activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mehmetzantur.sifrekasa.R;

/**
 * Created by mehme on 6.03.2016.
 */
public class AddActivity extends Activity {

    String[] Categories = {"Web Siteleri", "Uygulamalar", "Banka Hesapları", "Diğer"};
    Integer[] Images = {R.string.fa_globe, R.string.fa_android, R.string.fa_credit_card, R.string.fa_folder};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Spinner spnrSelectCategory = (Spinner) findViewById(R.id.spnrSelectCategory);
        spnrSelectCategory.setAdapter(new MyAdapter(this, R.layout.custom_spinner,
                Categories));


        spnrSelectCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                // TODO Auto-generated method stub
                String selectedItem = parent.getItemAtPosition(pos).toString();
                Toast.makeText(AddActivity.this,
                        selectedItem + " is selected", Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });


        Button btnAddNewBack = (Button) findViewById(R.id.btnAddNewBack);
        Typeface fontbtnAddNewBack = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
        btnAddNewBack.setTypeface(fontbtnAddNewBack);
        btnAddNewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final EditText txtAddNewPwd = (EditText)findViewById(R.id.txtAddNewPwd);

        Button btnAddNewSave = (Button) findViewById(R.id.btnAddNewSave);
        Typeface fontbtnAddNewSave = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
        btnAddNewSave.setTypeface(fontbtnAddNewSave);

        final Button btnAddNewShowPwd = (Button) findViewById(R.id.btnAddNewShowPwd);
        Typeface fontbtnAddNewShowPwd = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
        btnAddNewShowPwd.setTypeface(fontbtnAddNewShowPwd);
        btnAddNewShowPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnAddNewShowPwd.getText().toString().equals(getResources().getString(R.string.fa_eye)))
                {
                    btnAddNewShowPwd.setText(R.string.fa_eye_slash);
                    txtAddNewPwd.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                else
                {
                    btnAddNewShowPwd.setText(R.string.fa_eye);
                    txtAddNewPwd.setInputType(129);
                }
            }
        });
    }

    public class MyAdapter extends ArrayAdapter<String> {
        public MyAdapter(Context ctx, int txtViewResourceId, String[] objects) {
            super(ctx, txtViewResourceId, objects);
        }

        @Override
        public View getDropDownView(int position, View cnvtView, ViewGroup prnt) {
            return getCustomView(position, cnvtView, prnt);
        }

        @Override
        public View getView(int pos, View cnvtView, ViewGroup prnt) {
            return getCustomView(pos, cnvtView, prnt);
        }

        public View getCustomView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            View mySpinner = inflater.inflate(R.layout.custom_spinner, parent, false);
            TextView spinItemText = (TextView) mySpinner.findViewById(R.id.spinItemText);
            spinItemText.setText(Categories[position]);
            TextView spinItemIcon = (TextView) mySpinner.findViewById(R.id.spinItemIcon);
            Typeface fontspinItemIcon = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
            spinItemIcon.setTypeface(fontspinItemIcon);
            spinItemIcon.setText(Images[position]);
            return mySpinner;
        }
    }


}
