package com.example.th10;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Bai1Activity extends AppCompatActivity {
    public static final int NEW_EMPLOYEE = 55;
    public static final int EDIT_EMPLOYEE = 56;
    public static final int SAVE_NEW_EMPLOYEE = 57;
    public static final int SAVE_EDIT_EMPLOYEE = 58;

    ArrayList <NhanVien> arrayList = new ArrayList<NhanVien>();
    ListView listView;
    int vitrichon = -1;
    ArrayAdapter<NhanVien> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        listView = (ListView) findViewById(R.id.lvNhanVien);
        arrayList.add(new NhanVien(1, "Nguyễn Văn A"));
        arrayList.add(new NhanVien(2, "Nguyễn Kim Duy"));
        arrayList.add(new NhanVien(3, "Nguyễn Thị B"));

        adapter = new ArrayAdapter<NhanVien>(this,android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                vitrichon = position;
                return false;
            }
        });

        registerForContextMenu(listView);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.mnulistviewcontext,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
            if(item.getItemId()==R.id.mnuNew)
                doNewEmployee();
            else if (item.getItemId()==R.id.mnuUpdate)
                doEditEmployee();
            else if (item.getItemId()==R.id.mnuDel)
                doDeleteEmplyee();
        return super.onContextItemSelected(item);
    }

    private void doDeleteEmplyee() {

    }

    private void doEditEmployee() {
        Intent intent = new Intent(this, CapNhatNhanVien.class);
        startActivityForResult(intent,Bai1Activity.EDIT_EMPLOYEE);
    }

    private void doNewEmployee() {
        Intent intent = new Intent(this, ThemMoiNhanVien.class);
        startActivityForResult(intent,Bai1Activity.NEW_EMPLOYEE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Bai1Activity.NEW_EMPLOYEE:
                if (resultCode == Bai1Activity.SAVE_NEW_EMPLOYEE)
                {
                    Bundle b = data.getExtras();
                    NhanVien p = (NhanVien) b.getSerializable("nv");
                    arrayList.add(p);
                    adapter.notifyDataSetChanged();
                }
            case Bai1Activity.EDIT_EMPLOYEE:
                if (resultCode == Bai1Activity.SAVE_EDIT_EMPLOYEE)
                {
                    Bundle b = data.getExtras();
                    NhanVien p = (NhanVien) b.getSerializable("nv");
                    arrayList.set(vitrichon, p);
                    adapter.notifyDataSetChanged();
                }
        }

    }
}