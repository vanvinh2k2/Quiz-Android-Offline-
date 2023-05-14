package com.example.appquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appquiz.Model.DatabaseSqlite;
import com.example.appquiz.Ustil.Ustil;

public class SignUpActivity extends AppCompatActivity {
    EditText email,pass,name,repass;
    TextView dangNhap;
    Button xacNhan;
    DatabaseSqlite databaseSqlite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        anhXa();
        getDangKi();
    }
    private void getDangKi() {
        dangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        xacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = name.getText().toString().trim();
                String email1 = email.getText().toString().trim();
                String pass1 = pass.getText().toString().trim();
                if(isKiemTra()) {
                    Ustil.name = name1;
                    databaseSqlite.setDatabase("CREATE TABLE IF NOT EXISTS USER(ID INTEGER PRIMARY KEY AUTOINCREMENT, TEN VARCHAR(200), EMAIL VARCHAR(100), PASS VARCHAR(50))");
                    databaseSqlite.setDatabase("INSERT INTO USER VALUES(null,'"+name1+"','"+email1+"','"+pass1+"')");
                    showToast("Registered successfully.");
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void anhXa() {
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        repass = findViewById(R.id.repass);
        name = findViewById(R.id.name);
        dangNhap = findViewById(R.id.dangNhap);
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
        }else if(repass.getText().toString().trim().isEmpty()){
            showToast("Please enter repassword!");
            return false;
        }else if(name.getText().toString().trim().isEmpty()){
            showToast("Please enter name!");
            return false;
        }else if(pass.getText().toString().trim().compareTo(repass.getText().toString().trim())!=0){
            showToast("Repassword and pasword are not the same!");
            return false;
        }else return true;
    }
    void showToast(String value){
        Toast.makeText(SignUpActivity.this, value+"", Toast.LENGTH_SHORT).show();
    }
}