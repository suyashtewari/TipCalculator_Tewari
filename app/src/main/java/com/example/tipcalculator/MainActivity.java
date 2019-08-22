package com.example.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText bill, tip;
    private Button calculate;
    private TextView totalBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bill = (EditText) findViewById(R.id.billText);
        tip = (EditText) findViewById(R.id.tipText);
        calculate = (Button) findViewById(R.id.calcButton);
        totalBill = (TextView) findViewById(R.id.totalBill);
    }

    public void tipCalc(View v){
        DecimalFormat d = new DecimalFormat("####.00");

        try {


            double startBill = Double.parseDouble(bill.getText().toString().trim());
            double tipAmount = Double.parseDouble(tip.getText().toString().trim());

            double added = startBill * (tipAmount / 100);
            double total = startBill + added;

            totalBill.setText("Total Bill: $" + d.format(total));
        }
        catch(Exception e){
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
        }
    }
}
