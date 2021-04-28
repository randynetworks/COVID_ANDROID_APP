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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;

public class Calculate extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_calculate);

        EditText gaji = findViewById(R.id.txtGaji);
        EditText pendapatanLain = findViewById(R.id.txtPendapatanLain);
        EditText pengurangPajak = findViewById(R.id.txtPengurangPajak);
        EditText tanggungan = findViewById(R.id.txtTanggungan);
        Button btnCalculate = findViewById(R.id.btnSubmit);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double dGaji = Double.parseDouble(gaji.getText().toString());
                Double dPendapatanLain = Double.parseDouble(pendapatanLain.getText().toString());
                Double dpenguraganPajak = Double.parseDouble(pengurangPajak.getText().toString());
                Double dTanggungan = Double.parseDouble(tanggungan.getText().toString());

                Double TotalGajiPertahun = dGaji * 12;
                Double TotalPendapatan = TotalGajiPertahun + dPendapatanLain;
                Double TotalTanggungan = dTanggungan * 1000000;
                Double TotalPengurangan = TotalTanggungan + dpenguraganPajak;
                Double Pajak = TotalPendapatan - TotalPengurangan;
                Double PajakPerTahun = Pajak * 2.5 /100;
                Double PajakPerBulan = PajakPerTahun / 12;

                DecimalFormat pattern = new DecimalFormat("#");
                pattern.setMaximumFractionDigits(12);
                NumberFormat formatter = NumberFormat.getNumberInstance(Locale.GERMAN);
                String output = "Pendapatan Satu Tahun : " + formatter.format(TotalGajiPertahun) + "\n"
                        + "Pendapatan Lain : " + formatter.format(dPendapatanLain) + "\n"
                        + "Total Pendapatan : " + formatter.format(TotalPendapatan) + "\n"
                        + "Pengurangan Pajak : " + formatter.format(TotalPengurangan) + "\n"
                        + "Tanggungan (Orang x 1jt): " + formatter.format(TotalTanggungan) + "\n"
                        + "Total Pengurangan: " + formatter.format(TotalPengurangan) + "\n"
                        + "Pajak : " + formatter.format(Pajak) + "\n"
                        + "Total Pajak Per Tahun : " + formatter.format(PajakPerTahun) + "\n"
                        + "Total Pajak Per Bulan : " + formatter.format(PajakPerBulan);

                Intent calculateSuccess = new Intent(getBaseContext(), CalculateSuccess.class);
                calculateSuccess.putExtra("OUTPUT", output);
                startActivity(calculateSuccess);
            }
        });



    }


}
