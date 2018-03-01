package com.sheygam.java_18_01_03_18_hw_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText inputName, inputEmail, inputPhone;
    private Button okBtn;

    private int flag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        inputName = findViewById(R.id.input_name);
        inputEmail = findViewById(R.id.input_email);
        inputPhone = findViewById(R.id.input_phone);
        okBtn = findViewById(R.id.ok_btn);
        okBtn.setOnClickListener(this);

        showInput(getIntent().getAction());
    }

    private void showInput(String action){
        switch (action){
            case "action.edit.name":
                flag = 1;
                inputName.setVisibility(View.VISIBLE);
                inputEmail.setVisibility(View.INVISIBLE);
                inputPhone.setVisibility(View.INVISIBLE);
                break;
            case "action.edit.email":
                flag = 2;
                inputName.setVisibility(View.INVISIBLE);
                inputEmail.setVisibility(View.VISIBLE);
                inputPhone.setVisibility(View.INVISIBLE);
                break;
            case "action.edit.phone":
                flag = 3;
                inputName.setVisibility(View.INVISIBLE);
                inputEmail.setVisibility(View.INVISIBLE);
                inputPhone.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.ok_btn){
            Intent intent = new Intent();
            String data = "";
            switch (flag){
                case 1:
                    data = inputName.getText().toString();
                    break;
                case 2:
                    data = inputEmail.getText().toString();
                    break;
                case 3:
                    data = inputPhone.getText().toString();
                    break;
            }
            intent.putExtra("DATA", data);
            setResult(RESULT_OK,intent);
            finish();
        }
    }
}
