package com.randyramadhan.covid19;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Button btnInput = findViewById(R.id.btn_form);
        Button btnWeb = findViewById(R.id.btn_website);

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent formInput = new Intent(getBaseContext(), MainActivity.class);
                startActivity(formInput);
            }
        });

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent WebMenu = new Intent(getBaseContext(), WResmi.class);
                startActivity(WebMenu);
            }
        });


    }


}
