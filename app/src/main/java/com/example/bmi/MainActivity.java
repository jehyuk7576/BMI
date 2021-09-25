package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText cm;
    EditText kg;

    Button btn;

    TextView txtresultBmi;
    TextView txtResultMsg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cm = findViewById(R.id.cm);
        kg = findViewById(R.id.kg);
        btn = findViewById(R.id.btn1);
        txtresultBmi = findViewById(R.id.txt_result_bmi);
        txtResultMsg = findViewById(R.id.txt_result_msg);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String bringCm = cm.getText().toString();
                String bringKg = kg.getText().toString();
                int changeCm = Integer.parseInt(bringCm);
                int changeKg = Integer.parseInt(bringKg);


                if (bringCm.equals("")){
                    Toast.makeText(getApplicationContext(),"키를 입력해 주세요.",Toast.LENGTH_SHORT).show();
                } else if (bringKg.equals("")){
                    Toast.makeText(getApplicationContext(),"몸무게를 입력해 주세요.",Toast.LENGTH_SHORT).show();
                } else {
                    double resultBmi = changeKg / ((changeCm * 0.01) * (changeCm * 0.01));
                    Toast.makeText(getApplicationContext(),"BMI 결과 값은 == " +resultBmi,Toast.LENGTH_SHORT).show();

                    String resultaMsg = "";


                    if (resultBmi >= 40){
                        resultaMsg = "고도비만";
                    } else if (resultBmi >= 30){
                        resultaMsg = "비만";
                    } else if (resultBmi >= 25){
                        resultaMsg = "과체중";
                    } else if (resultBmi >= 20){
                        resultaMsg = "정상";
                    } else {
                        resultaMsg = "저체중";
                    }
                    int finalBmi = (int)resultBmi;
                    txtresultBmi.setText("BMI : "+finalBmi);
                    txtResultMsg.setText("결과는 "+ resultaMsg);
                }
            }
        });
    }
    private void btn(){
        int height = Integer.parseInt(cm.getText().toString());
        int weight = Integer.parseInt(kg.getText().toString());

        double bmi = weight / (height*0.01) * (height *0.01);

    }
}