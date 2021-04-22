package com.randyramadhan.covid19;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
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
        Button btnYT = findViewById(R.id.btnYoutube);
        Button btnGM = findViewById(R.id.btn_map);
        Button btnCamera = findViewById(R.id.btn_camera);
        Button btnCalculator = findViewById(R.id.btn_calculator);
        Button btnCalendar = findViewById(R.id.btn_calendar);
        Button btnContact = findViewById(R.id.btn_contact);
        Button btnSetting = findViewById(R.id.btn_setting);
        Button btnProject9 = findViewById(R.id.btn_project_9);
        Button btnLain = findViewById(R.id.btn_lain);


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

        btnYT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent yt = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtube.com"));
                startActivity(yt);
            }
        });

        btnGM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent map = new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.google.com"));
                startActivity(map);
            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivityForResult(camera, 0);
            }
        });

        btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calc = new Intent();
                calc.setClassName("com.android.calculator2", "com.android.calculator2.Calculator");
                startActivityForResult(calc, 0);
            }
        });


        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calendar = new Intent();
                calendar.setClassName("com.samsung.android.calendar", "com.samsung.android.calendar.Calendar");
                startActivityForResult(calendar, 0);
            }
        });

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contact = new Intent();
                contact.setClassName("com.samsung.android.app.contacts", "com.samsung.android.app.contacts.Contacts");
                startActivityForResult(contact, 0);
            }
        });

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setting = new Intent();
                setting.setClassName("com.android.settings", "com.android.settings.Settings");
                startActivityForResult(setting, 0);
            }
        });

        btnProject9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent project9 = new Intent();
                project9.setClassName("com.randyramadhan.project9", "com.randyramadhan.project9.MainActivity");
                startActivityForResult(project9, 0);
            }
        });

        btnLain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lain = new Intent();
                lain.setClassName("com.ayoboga.ayobogaeducation", "com.ayoboga.ayobogaeducation.Ayoboga");
                startActivityForResult(lain, 0);
            }
        });


    }


}
