package com.example.uber;

import static android.os.Build.VERSION_CODES.S;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Button;



import java.security.PrivateKey;

public class MainActivity2 extends AppCompatActivity {
    private String sugar="無糖";
    private String ice_opt="去冰";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        RadioGroup rg1=findViewById(R.id.radioGroup);

        RadioButton rbtn = findViewById(R.id.radioButton6);
        rbtn.performClick();
        rbtn = findViewById(R.id.radioButton5);
        rbtn.performClick();

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.radioButton1:
                        sugar="無糖";
                        break;
                    case R.id.radioButton2:
                        sugar="微糖";
                        break;
                    case R.id.radioButton3:
                        sugar="半糖";
                        break;
                    case R.id.radioButton4:
                        sugar="全糖";
                        break;
                }
            }
        });

        RadioGroup rg2=findViewById(R.id.radioGroup2);
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.radioButton5:
                        ice_opt="微冰";
                        break;
                    case R.id.radioButton6:
                        ice_opt="少冰";
                        break;
                    case R.id.radioButton7:
                        ice_opt="正常冰";
                        break;
                }
            }
        });

        Button send_btn =findViewById(R.id.btn_send);
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText set_drink=findViewById(R.id.ed_drink);
                String drink=set_drink.getText().toString();
                Intent i=new Intent();
                Bundle b=new Bundle();
                b.putString("sugar",sugar);
                b.putString("drink",drink);
                b.putString("ice",ice_opt);
                i.putExtras(b);
                setResult(101,i);
                finish();

            }
        });



    }
}