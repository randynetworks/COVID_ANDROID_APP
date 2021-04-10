package com.ayoboga.pertemuan34siang;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private EditText displayDate;
    private DatePickerDialog.OnDateSetListener dateSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_input);

        displayDate = (EditText) findViewById(R.id.id_tgl);
        displayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,R.style.Theme_AppCompat_Light_Dialog, dateSetListener , year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                dialog.show();
            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + dayOfMonth + "/" + year);

                String date = month + "/" + dayOfMonth + "/" + year;
                displayDate.setText(date);
            }
        };


        Button btnSubmit = findViewById(R.id.buttonSubmit);
        btnSubmit.setOnClickListener(new MainActivity.submitForm());

    }

    public class submitForm implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            EditText textNama = findViewById(R.id.id_name);
            EditText textEmail = findViewById(R.id.id_email);
            EditText textAlamat = findViewById(R.id.id_alamat);
            EditText textNIK = findViewById(R.id.id_NIK);
            EditText textDate = findViewById(R.id.id_tgl);
            RadioGroup radioJK = findViewById(R.id.id_JK);
            RadioButton JK = findViewById(radioJK.getCheckedRadioButtonId());

            String strNama = textNama.getText().toString();
            String strEmail = textEmail.getText().toString();
            String strAlamat = textAlamat.getText().toString();
            String strNIK = textNIK.getText().toString();
            String strDate = textDate.getText().toString();
            String strJK = JK.getText().toString();

            Intent formSuccess = new Intent(MainActivity.this, FormSuccess.class);
            formSuccess.putExtra("VAR_NAMA", strNama);
            formSuccess.putExtra("VAR_NIK", strNIK);
            formSuccess.putExtra("VAR_JK", strJK);
            formSuccess.putExtra("VAR_DATE", strDate);
            formSuccess.putExtra("VAR_ALAMAT", strAlamat);
            formSuccess.putExtra("VAR_EMAIL", strEmail);

            startActivity(formSuccess);
        }
    }

}
