package com.example.appquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.appquiz.Model.DapAn;
import com.example.appquiz.Model.TestQuiz;
import com.example.appquiz.Ustil.Ustil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<TestQuiz> listCauHoi;
    TextView title,cauHoi;
    Button nextbtn,backbtn;
    RadioButton cauA,cauB,cauC,cauD,r;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        setData();
        getData(i);
        getMain();
    }

    private void getMain() {
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i<listCauHoi.size()-1){
                    Ustil.dapAn.get(i).setDapAn(checkRadio());
                    Ustil.dapAn.get(i).setId(i);
                    r.setChecked(true);
                    i++;
                    getData(i);
                    if(Ustil.dapAn.get(i).getDapAn().compareTo("")!=0)
                        check(Ustil.dapAn.get(i).getDapAn());
                    nextbtn.setText("next");
                    if(i==listCauHoi.size()-1) {
                        nextbtn.setText("submit");
                    }
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    startActivity(intent);
                }

            }
        });
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i>0){
                    Ustil.dapAn.get(i).setDapAn(checkRadio());
                    Ustil.dapAn.get(i).setId(i);
                    r.setChecked(true);
                    i--;
                    getData(i);
                    if(Ustil.dapAn.get(i).getDapAn().compareTo("")!=0)
                        check(Ustil.dapAn.get(i).getDapAn());
                    nextbtn.setText("next");
                }
                else getData(i);
            }
        });
    }

    private void setData() {
        listCauHoi.add(new TestQuiz(1,"Which of the following programming languages does not require a translator?",
                "Pascal",
                "Machine language.",
                "C++",
                "Python"));
        listCauHoi.add(new TestQuiz(2,"Which of the following is a TRUE statement about translation?",
                "Interpreter programs translate all statements at the same time.",
                "The interpreter programs translate and execute each statement in turn.",
                "The interpreter has the target program to store.",
                "Express an algorithm that can be assigned to a computer to execute."));
        listCauHoi.add(new TestQuiz(3,"Programming languages usually have several basic components:",
                "2.",
                "4.",
                "5.",
                "3."));
        listCauHoi.add(new TestQuiz(4,"Which of the following high-level programming languages are capable of?",
                "A language close to natural language, highly independent and independent of machines",
                "Computer directly understands and executes.",
                "Any algorithm can be expressed",
                " Express algorithms according to certain conventions independent of specific computers."));
        listCauHoi.add(new TestQuiz(5,"To comment on a command line in a C++ program, which pair of signs do we use?",
                "\\* and *\\.",
                "<<.",
                "//.",
                ">>."));
        listCauHoi.add(new TestQuiz(6,"Memory storage of int declaration m,n,a,b; float x,y,z; short i,j; to be:",
                "32.",
                "9.",
                "23.",
                "10."));
        listCauHoi.add(new TestQuiz(7,"What is the cout… command in C++?",
                "Is the procedure to input data into C++.",
                "Annotated command in C++.",
                "Is the procedure to output data in C++.",
                "A command to declare a variable."));
        listCauHoi.add(new TestQuiz(8,"At the end of a command line in a C++ program, what notation do we use?",
                "“,”",
                "“.”",
                "“:”",
                "“;”"));
        listCauHoi.add(new TestQuiz(9,"What pair of signs does the cout command in C++ come with?",
                ">>",
                "||",
                "//",
                "<<"));
        listCauHoi.add(new TestQuiz(10,"What notation does the square root function of a certain value x use in C++?",
                "pow(x).",
                "sqrt(x).",
                "abx(x).",
                "exp(x)."));
        for(int i=0;i<listCauHoi.size();i++){
            Ustil.dapAn.add(new DapAn(0,""));
        }
    }

    public void getData(int i){
        title.setText("Question "+listCauHoi.get(i).getId());
        cauHoi.setText(listCauHoi.get(i).getTitle());
        cauA.setText("A. "+listCauHoi.get(i).getCau1());
        cauB.setText("B. "+listCauHoi.get(i).getCau2());
        cauC.setText("C. "+listCauHoi.get(i).getCau3());
        cauD.setText("D. "+listCauHoi.get(i).getCau4());
    }

    private String checkRadio() {
        if(cauA.isChecked()) return "A";
        if(cauB.isChecked()) return "B";
        if(cauC.isChecked()) return "C";
        if(cauD.isChecked()) return "D";
        return "";
    }

    private void check(String s){
        if(s.compareTo("A")==0) cauA.setChecked(true);
        else if(s.compareTo("B")==0) cauB.setChecked(true);
        else if(s.compareTo("C")==0) cauC.setChecked(true);
        else cauD.setChecked(true);
    }

    private void anhXa() {
        listCauHoi = new ArrayList<>();
        title = findViewById(R.id.title);
        cauHoi = findViewById(R.id.cauhoi);
        cauA = findViewById(R.id.a);
        cauB = findViewById(R.id.b);
        cauC = findViewById(R.id.c);
        cauD = findViewById(R.id.d);
        nextbtn = findViewById(R.id.next);
        backbtn = findViewById(R.id.back);
        r = findViewById(R.id.e);
        Ustil.dapAn = new ArrayList<>();
    }
}