package com.mehmetzantur.sifrekasa.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.mehmetzantur.sifrekasa.R;

/**
 * Created by mehme on 6.03.2016.
 */
public class AddActivity extends Activity {

    Spinner spnrSelectCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        spnrSelectCategory = (Spinner)findViewById(R.id.spnrSelectCategory);
        ArrayAdapter categoryAdapter = ArrayAdapter.createFromResource(AddActivity.this,R.array.Categories,android.R.layout.simple_spinner_item);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnrSelectCategory.setAdapter(categoryAdapter);

    }


}
