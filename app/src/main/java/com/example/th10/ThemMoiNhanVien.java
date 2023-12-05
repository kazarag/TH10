package com.example.th10;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThemMoiNhanVien extends Activity implements View.OnClickListener {
    Button btnSubmit;
    EditText txtid, txtname,txtphong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_moi_nhan_vien);
        txtid = (EditText) findViewById(R.id.txtempid);
        txtname = (EditText) findViewById(R.id.txtName);
        btnSubmit = (Button) findViewById(R.id.btnBack);

        btnSubmit.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent intent  = getIntent();
        Bundle bundle = new Bundle();

        int id = Integer.parseInt(txtid.getText().toString());
        String ten = txtname.getText().toString();
        NhanVien nv = new NhanVien(id,ten);
        bundle.putSerializable("nv",nv);
        intent.putExtras(bundle);
        setResult(Bai1Activity.SAVE_NEW_EMPLOYEE,intent);
        finish();
    }
}