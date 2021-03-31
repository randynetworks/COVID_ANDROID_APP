package com.ayoboga.pertemuan34siang;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_input);

        Button btnSubmit = findViewById(R.id.buttonSubmit);
        btnSubmit.setOnClickListener(new MainActivity.submitForm());
    }


    public class submitForm implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            EditText textNama = findViewById(R.id.id_name);
            EditText textEmail = findViewById(R.id.id_email);
            EditText textAlamat = findViewById(R.id.id_alamat);

            String strNama = textNama.getText().toString();
            String strEmail = textEmail.getText().toString();
            String strAlamat = textAlamat.getText().toString();

            Intent formSuccess = new Intent(MainActivity.this, FormSuccess.class);
            formSuccess.putExtra("VAR_NAMA", strNama);
            formSuccess.putExtra("VAR_EMAIL", strEmail);
            formSuccess.putExtra("VAR_ALAMAT", strAlamat);
            startActivity(formSuccess);
        }
    }

}
