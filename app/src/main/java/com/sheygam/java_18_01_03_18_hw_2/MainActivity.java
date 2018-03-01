package com.sheygam.java_18_01_03_18_hw_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView nameTxt, emailTxt, phoneTxt;
    private Button setNameBtn, setEmailBtn, setPhoneBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameTxt = findViewById(R.id.name_txt);
        emailTxt = findViewById(R.id.email_txt);
        phoneTxt = findViewById(R.id.phone_txt);

        setNameBtn = findViewById(R.id.set_name_btn);
        setEmailBtn = findViewById(R.id.set_email_btn);
        setPhoneBtn = findViewById(R.id.set_phone_btn);

        setNameBtn.setOnClickListener(this);
        setEmailBtn.setOnClickListener(this);
        setPhoneBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.set_name_btn:
                intent.setAction("action.edit.name");
                startActivityForResult(intent,1);
                break;
            case R.id.set_email_btn:
                intent.setAction("action.edit.email");
                startActivityForResult(intent,2);
                break;
            case R.id.set_phone_btn:
                intent.setAction("action.edit.phone");
                startActivityForResult(intent,3);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            switch (requestCode){
                case 1:
                    nameTxt.setText(data.getStringExtra("DATA"));
                    break;
                case 2:
                    emailTxt.setText(data.getStringExtra("DATA"));
                    break;
                case 3:
                    phoneTxt.setText(data.getStringExtra("DATA"));
                    break;
            }
        }
    }
}
