package com.example.uber;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data==null)return;
        if (requestCode==1){
            if (resultCode==101){
                Bundle b =data.getExtras();
                String str1 =b.getString("drink");
                String str2 =b.getString("sugar");
                String str3 =b.getString("ice");
                TextView tv_meal=findViewById(R.id.tv_meal);
                tv_meal.setText("飲料："+str1+"\n\n甜度："+str2+"\n\n冰塊："+str3);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv_meal=findViewById(R.id.tv_meal);
        Button btn=findViewById(R.id.btn_choice);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this,MainActivity2.class),1);
            }
        });
    }


}