package com.example.appquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.appquiz.Model.DapAn;
import com.example.appquiz.Ustil.Ustil;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    TextView kq;
    Button lamLai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        anhXa();
        getDapAn();
        kiemTra();
        getLamLai();
    }

    private void getLamLai() {
        lamLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void kiemTra() {
        int s = 0;
        for(int i = 0; i < Ustil.dapAn.size();i++){
            if(Ustil.dapAnChuan.get(i).getDapAn().equals(Ustil.dapAn.get(i).getDapAn())){
                s++;
            }
        }
        kq.setText("High score: "+s);
    }

    private void getDapAn() {
        Ustil.dapAnChuan = new ArrayList<>();
        Ustil.dapAnChuan.add(new DapAn(1,"B"));
        Ustil.dapAnChuan.add(new DapAn(2,"B"));
        Ustil.dapAnChuan.add(new DapAn(3,"A"));
        Ustil.dapAnChuan.add(new DapAn(4,"A"));
        Ustil.dapAnChuan.add(new DapAn(5,"A"));
        Ustil.dapAnChuan.add(new DapAn(6,"A"));
        Ustil.dapAnChuan.add(new DapAn(7,"C"));
        Ustil.dapAnChuan.add(new DapAn(8,"D"));
        Ustil.dapAnChuan.add(new DapAn(9,"D"));
        Ustil.dapAnChuan.add(new DapAn(10,"B"));
    }

    private void anhXa() {
        kq = findViewById(R.id.kq);
        lamLai = findViewById(R.id.lamLai);
    }
}