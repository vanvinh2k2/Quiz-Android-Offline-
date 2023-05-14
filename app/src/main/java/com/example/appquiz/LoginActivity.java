package com.example.appquiz;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appquiz.Model.DatabaseSqlite;

public class LoginActivity extends AppCompatActivity {
    EditText email,pass;
    TextView dangKi;
    Button xacNhan;
    DatabaseSqlite databaseSqlite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        anhXa();
        getDangNhap();
    }
    private void getDangNhap() {
        xacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email1 = email.getText().toString().trim();
                String pass1 = pass.getText().toString().trim();
                if(isKiemTra()) {
                    XuLy(email1,pass1);
                }
            }
        });
        dangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
    public void XuLy(String email, String pass){
        int kt = 1;
        Cursor cursor = databaseSqlite.getDatabase("SELECT * FROM USER");
        while(cursor.moveToNext()){
            String email1 = cursor.getString(2);
            String pass1 = cursor.getString(3);
            if(email1.compareTo(email) == 0 && pass1.compareTo(pass) == 0){
                Toast.makeText(getApplicationContext(), "Logged in successfully.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                kt = 2;
            }
            if(kt == 1) showToast("Wrong email or password!");
        }
    }
    private void anhXa() {
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        dangKi = findViewById(R.id.dangki);
        xacNhan = findViewById(R.id.xacNhan);
        databaseSqlite = new DatabaseSqlite(getApplicationContext(),"database",null,1);

    }
    boolean isKiemTra(){
        if(email.getText().toString().trim().isEmpty()){
            showToast("Please enter email!");
            return false;
        }else if(pass.getText().toString().trim().isEmpty()){
            showToast("Please enter pasword!");
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
            showToast("Email is not correct!");
            return false;
        }else return true;
    }
    void showToast(String value){
        Toast.makeText(LoginActivity.this, value+"", Toast.LENGTH_SHORT).show();
    }
}