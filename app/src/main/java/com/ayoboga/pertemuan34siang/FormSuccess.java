package com.ayoboga.pertemuan34siang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FormSuccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_success);

        String strNama = getIntent().getStringExtra("VAR_NAMA");
        String strEmail = getIntent().getStringExtra("VAR_EMAIL");
        String strAlamat = getIntent().getStringExtra("VAR_ALAMAT");


        TextView lblNama = (TextView) findViewById(R.id.nama_success);
        TextView lblEmail = (TextView) findViewById(R.id.email_success);
        TextView lblAlamat = (TextView) findViewById(R.id.alamat_success);

        lblNama.setText("Nama kamu, " + strNama);
        lblEmail.setText("Emailnya, " + strEmail);
        lblAlamat.setText("Alamat kamu ada di, " + strAlamat);
    }


}