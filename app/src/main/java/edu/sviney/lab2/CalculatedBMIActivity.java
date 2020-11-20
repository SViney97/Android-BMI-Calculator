package edu.sviney.lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatedBMIActivity extends AppCompatActivity {

    int h = 0, w=0;
    TextView KGWeight,CMHeight, BMI,Message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculated_b_m_i);

        BMI = findViewById(R.id.tvBMI);
        KGWeight = findViewById(R.id.tvweight);
        CMHeight = findViewById(R.id.tvhieght);
        Message = findViewById(R.id.tvMessage);

        w = getIntent().getIntExtra("weight",-1);
        h = getIntent().getIntExtra("height",-1);

//long way of doing the formula
//double meterHeight = h / 10;
        //double meterHeight2 = meterHeight /10;
        //double metersquared = meterHeight2 * meterHeight2;
//double calBMI =(w/(meterheight*meterheight));

        double meterHeight =(double) h / 100;
        double metersquared = meterHeight * meterHeight;

        double calBMI =(double) w / metersquared;

        BMI.setText(String.valueOf(calBMI));
        KGWeight.setText((String.valueOf(w)));
        CMHeight.setText(String.valueOf(h));

        if(calBMI <= 18.5)
        {
            Message.setText("Under Weight");
        }
        if(calBMI>=18.6 || calBMI <=24.9)
        {
            Message.setText("Healthy Weight");
        }
        if(calBMI>=25 || calBMI <=29.9)
        {
            Message.setText("Over Weight");
        }

    }

    public void doExit(View view) {
        finish();
    }
}