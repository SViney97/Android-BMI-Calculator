package edu.sviney.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText Weight,Height;
    TextView Message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Weight = findViewById(R.id.etWeight);
        Height = findViewById(R.id.etHeight);
        Message = findViewById(R.id.etMessage);

        int w = getIntent().getIntExtra("weight",-1);
        int h = getIntent().getIntExtra("height",-1);

    }

    public void DoReset(View view) {
        Weight.setText("0");
        Height.setText("0");
        Message.setText("");

    }

    public void DoCalculate(View view) {

       int KGWeight = Integer.valueOf(Weight.getText().toString());
       int CMHeight = Integer.valueOf(Height.getText().toString());

        if(KGWeight <20 || KGWeight >300)
        {
            Message.setText("invalid Weight");

        }
        else if(CMHeight<80 || CMHeight>200)
        {
            Message.setText("invalid Height");

        }
        else {
            Intent CalculatedActvity = new Intent(view.getContext(), CalculatedBMIActivity.class);
            CalculatedActvity.putExtra("weight", KGWeight);
            CalculatedActvity.putExtra("height", CMHeight);
            startActivity(CalculatedActvity);
            Weight.setText("0");
            Height.setText("0");
            Message.setText("");
        }
    }
}