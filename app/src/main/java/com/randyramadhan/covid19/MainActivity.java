package com.randyramadhan.covid19;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private EditText displayDate;
    private DatePickerDialog.OnDateSetListener dateSetListener;
    private String[] listKewarganegaraan = {"-- Pilih kewarganegaraan --", "Indonesia", "Singapore", "Malaysia", "Japan", "Lainnya"};

    String strKotaData;
    String strNegaraData;


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


        Spinner spinnerKota = findViewById(R.id.id_kota);
        Spinner spinnerNegara = findViewById(R.id.id_negara);

        spinnerKota.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            String item = String.valueOf(spinnerKota.getSelectedItem());
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                strKotaData = (item.equals(spinnerKota.getSelectedItem())) ? "" : parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        final ArrayAdapter<String> dataNegara = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, listKewarganegaraan);


        spinnerNegara.setAdapter(dataNegara);
        spinnerNegara.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            String item = String.valueOf(spinnerNegara.getSelectedItem());
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                strNegaraData = (item.equals(spinnerNegara.getSelectedItem())) ? "" : parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


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
            String strKota = strKotaData;
            String strNegara = strNegaraData;
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
                                    "Data Input Kota\t\t" + strKota + "\n" +
                                    "Data Input Negara\t\t" + strNegara + "\n" +
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
            System.out.println("Data Input Kota : " + strKota);
            System.out.println("Data Input Negara : " + strNegara);
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
                    formSuccess.putExtra("VAR_KOTA", strKota);
                    formSuccess.putExtra("VAR_DATE", strDate);
                    formSuccess.putExtra("VAR_ALAMAT", strAlamat);
                    formSuccess.putExtra("VAR_NEGARA", strNegara);
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
