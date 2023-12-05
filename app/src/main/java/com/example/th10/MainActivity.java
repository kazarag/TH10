package com.example.th10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openLayout(View view) {
        int id = view.getId();
        Intent intent;
        if (id == R.id.btnbai1) {
            intent = new Intent(this, Bai1Activity.class);
            startActivity(intent);

        } else if (id == R.id.btnbai2) {
            intent = new Intent(this, Bai2Activity.class);
            startActivity(intent);
        }


    }
}