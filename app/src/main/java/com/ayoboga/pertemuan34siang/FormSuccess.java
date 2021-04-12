package com.ayoboga.pertemuan34siang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FormSuccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_success);

        String strNama = getIntent().getStringExtra("VAR_NAMA");
        String strNIK = getIntent().getStringExtra("VAR_NIK");
        String strJK = getIntent().getStringExtra("VAR_JK");
        String strKota = getIntent().getStringExtra("VAR_KOTA");
        String strDate = getIntent().getStringExtra("VAR_DATE");
        String strAlamat = getIntent().getStringExtra("VAR_ALAMAT");
        String strNegara = getIntent().getStringExtra("VAR_NEGARA");
        String strEmail = getIntent().getStringExtra("VAR_EMAIL");
        Boolean status = getIntent().getBooleanExtra("VAR_STATUS", false);



        TextView lblNama = (TextView) findViewById(R.id.nama_success);
        TextView lblNIK = (TextView) findViewById(R.id.nik_success);
        TextView lblJK = (TextView) findViewById(R.id.jk_success);
        TextView lblTgl = (TextView) findViewById(R.id.tgl_success);
        TextView lblAlamat = (TextView) findViewById(R.id.alamat_success);
        TextView lblNegara = (TextView) findViewById(R.id.negara_success);
        TextView lblEmail = (TextView) findViewById(R.id.email_success);
        TextView lblStatus = (TextView) findViewById(R.id.status_success);

        lblNama.setText("Hi, " + strNama + "!");
        lblNIK.setText("NIK kamu, " + strNIK + ",");
        lblJK.setText("Dengan Jenis Kelamin " + strJK + ",");
        lblTgl.setText("Dan Tempat Tanggal Lahir, " + strKota + ", " + strDate + ",");
        lblNegara.setText("Yeyy Kamu Orang " + strNegara);
        lblEmail.setText("Dan Kamu udah terdaftar Vaksinasi dengan email ini,\n" + strEmail);
        lblAlamat.setText("Vaksinasi akan berada di daerah alamat,\n" + strAlamat);

        if (status) {
            lblStatus.setText("Kamu Lagi Sakit!, Tunggu sembuh dulu!");
        } else {
            lblStatus.setText("Karena Kamu sehat, Kamu akan di Vaksin!");
        }
    }


}