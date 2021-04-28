package com.randyramadhan.covid19;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class CalculateSuccess extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculate_success);

        String strOutput = getIntent().getStringExtra("OUTPUT");
        TextView total = (TextView) findViewById(R.id.total);
        total.setText(strOutput);

    }


}
