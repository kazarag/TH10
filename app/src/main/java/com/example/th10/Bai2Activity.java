package com.example.th10;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Bai2Activity extends AppCompatActivity {
    private Button btnNhap, btnGiai, btnDong;
    private TextView tvA, tvB, tvC;

    private static final int REQUEST_CODE_NHAP = 1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        btnNhap = findViewById(R.id.nhap);
        btnGiai = findViewById(R.id.calculate);
        btnDong = findViewById(R.id.buttonBack);
        tvA = findViewById(R.id.a);
        tvB = findViewById(R.id.b);
        tvC = findViewById(R.id.c);

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bai2Activity.this, NhapActivity.class);
                startActivityForResult(intent, REQUEST_CODE_NHAP);
            }
        });

        btnGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double a = Double.parseDouble(tvA.getText().toString());
                double b = Double.parseDouble(tvB.getText().toString());
                double c = Double.parseDouble(tvC.getText().toString());



                String result;
                if(a==0){
                    result ="Phương trình bậc I: ";
                    if (b == 0)
                    {
                        if (c == 0)
                            result= result + "Phương trình có vô số nghiệm";
                        else
                            result=result+ "Phương trình vô nghiệm";
                    }
                    else
                    {
                        result=result + "x = " + (-c/b);
                    }
                }
                else {
                    double delta = b * b - 4 * a * c;
                    if (delta > 0) {
                        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                        result = "Phương trình có 2 nghiệm: x1 = " + x1 + ", x2 = " + x2;
                    } else if (delta == 0) {
                        double x = -b / (2 * a);
                        result = "Phương trình có nghiệm kép: x = " + x;
                    } else {
                        result = "Phương trình vô nghiệm";
                    }
                }
                Intent intent = new Intent(Bai2Activity.this, ResultActivity.class);
                intent.putExtra("result", result);
                startActivity(intent);
            }
        });

        btnDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_NHAP) {
            if (resultCode == RESULT_OK) {
                double a = data.getDoubleExtra("a", 0);
                double b = data.getDoubleExtra("b", 0);
                double c = data.getDoubleExtra("c", 0);

                tvA.setText(String.valueOf(a));
                tvB.setText(String.valueOf(b));
                tvC.setText(String.valueOf(c));
            }
        }
    }
}