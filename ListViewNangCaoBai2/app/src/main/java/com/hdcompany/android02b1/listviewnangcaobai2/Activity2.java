package com.hdcompany.android02b1.listviewnangcaobai2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView txt_name, txt_money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        anhXa();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            String value1 = bundle.getString("1", "");
            String value2 = bundle.getString("2", "");

            txt_name.setText(value1);
            txt_money.setText(value2);



        }




    }

    private void anhXa() {

        txt_name = findViewById(R.id.txt_name);
        txt_money = findViewById(R.id.txt_money);
    }
}