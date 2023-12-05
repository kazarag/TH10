package com.example.th10;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NhapActivity extends AppCompatActivity {
    private EditText etA, etB, etC;
    private Button btnNhapLai, btnTroVe;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhap);
        etA = findViewById(R.id.a);
        etB = findViewById(R.id.b);
        etC = findViewById(R.id.c);
        btnNhapLai = findViewById(R.id.nhaplai);
        btnTroVe = findViewById(R.id.buttonBack);

        btnNhapLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(etA.getText().toString());
                double b = Double.parseDouble(etB.getText().toString());
                double c = Double.parseDouble(etC.getText().toString());

                Intent returnIntent = new Intent();
                returnIntent.putExtra("a", a);
                returnIntent.putExtra("b", b);
                returnIntent.putExtra("c", c);

                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });

        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }
}