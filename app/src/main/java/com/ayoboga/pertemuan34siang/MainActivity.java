package com.ayoboga.pertemuan34siang;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
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
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

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
            Switch sakit = findViewById(R.id.id_is_Sick);

            String strNama = textNama.getText().toString();
            String strEmail = textEmail.getText().toString();
            String strAlamat = textAlamat.getText().toString();
            String strNIK = textNIK.getText().toString();
            String strDate = textDate.getText().toString();
            String strJK = JK.getText().toString();
            boolean status = sakit.isChecked();


            Snackbar Informasi = Snackbar.make(v, "Data " + strNama +" tersimpan!", Snackbar.LENGTH_LONG);
            Informasi.setAction("Lihat Detail", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Toast
                    Toast data = Toast.makeText(getApplicationContext(), "Data : \n" +
                                    "Nama\t\t\t" + strNama + "\n" +
                                     "Data Input NIK\t\t\t" + strNIK + "\n" +
                                    "Data Input JK\t\t\t" + strJK + "\n" +
                                    "Data Input Date\t\t\t" + strDate + "\n" +
                                    "Data Input Email\t\t\t" + strEmail + "\n" +
                                    "Data Input Alamat\t\t" + strAlamat + "\n" +
                                     "Data Input Status\t\t" + status
                            , Toast.LENGTH_LONG);
                    data.show();
                }
            });
            Informasi.show();

            System.out.println("Data pada Variable :");
            System.out.println("Data Input Nama : " + strNama);
            System.out.println("Data Input NIK : " + strNIK);
            System.out.println("Data Input JK : " + strJK);
            System.out.println("Data Input Date : " + strDate);
            System.out.println("Data Input Email : " + strEmail);
            System.out.println("Data Input Alamat : " + strAlamat);
            System.out.println("Data Input Status : " + status);

            AlertDialog.Builder InformasiAlert = new AlertDialog.Builder(MainActivity.this);
            InformasiAlert.setTitle("Data Dikonfirmasi");
            InformasiAlert.setMessage("Hi " + strNama + "!, Data yang kamu kirim terkonfirmasi, Kamu bisa Check Data disini!");
            InformasiAlert.setPositiveButton("Check", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent formSuccess = new Intent(MainActivity.this, FormSuccess.class);
                    formSuccess.putExtra("VAR_NAMA", strNama);
                    formSuccess.putExtra("VAR_NIK", strNIK);
                    formSuccess.putExtra("VAR_JK", strJK);
                    formSuccess.putExtra("VAR_DATE", strDate);
                    formSuccess.putExtra("VAR_ALAMAT", strAlamat);
                    formSuccess.putExtra("VAR_EMAIL", strEmail);
                    formSuccess.putExtra("VAR_STATUS", status);

                    startActivity(formSuccess);
                }
            });
            AlertDialog alertDialog = InformasiAlert.create();
            alertDialog.show();
        }
    }
}
