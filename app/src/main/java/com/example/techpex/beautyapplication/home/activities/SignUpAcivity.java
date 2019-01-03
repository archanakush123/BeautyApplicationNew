package com.example.techpex.beautyapplication.home.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.techpex.beautyapplication.R;
import com.example.techpex.beautyapplication.home.constants.GlobalConstant;
import com.example.techpex.beautyapplication.home.database.PrefrenceManager;

public class SignUpAcivity extends AppCompatActivity {

    EditText edt_user_name,edt_mob_no,edt_email,edt_password;
    Button btn_submit;
    String name,mob_no,email,password;
    private PrefrenceManager mPrefrenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_acivity);
        mPrefrenceManager = PrefrenceManager.getInstance(this);
        setLayoutRefrences();
    }

    private void setLayoutRefrences() {

        edt_user_name = findViewById(R.id.edt_user_name);
        edt_mob_no = findViewById(R.id.edt_mobile);
        edt_email = findViewById(R.id.edt_email);
        edt_password = findViewById(R.id.edt_login_password);
        btn_submit = findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = edt_user_name.getText().toString().trim();
                mob_no = edt_mob_no.getText().toString().trim();
                email = edt_email.getText().toString().trim();
                password = edt_password.getText().toString().trim();

                if(validateInputField()){
                    saveUserDataInput();
                    openLoginAcivity();
                }

            }
        });
    }

    private void openLoginAcivity() {
        Intent intent = new Intent(SignUpAcivity.this,LoginActivity.class);
        intent.putExtra(GlobalConstant.USER_MOB_NO,mob_no);
        startActivity(intent);
        finish();
    }

    private void saveUserDataInput() {
        mPrefrenceManager.savePrefString(GlobalConstant.USER_NAME,name);
        mPrefrenceManager.savePrefString(GlobalConstant.USER_MOB_NO,mob_no);
        mPrefrenceManager.savePrefString(GlobalConstant.USER_EMAIL_ID,email);
        mPrefrenceManager.savePrefString(GlobalConstant.USER_PASSWORD,password);
        Toast.makeText(SignUpAcivity.this, "Data Entered Successfully", Toast.LENGTH_SHORT).show();
    }

    private boolean validateInputField(){

        if(TextUtils.isEmpty(name)){
            Toast.makeText(this, "Enter the name", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(TextUtils.isEmpty(mob_no)){
            Toast.makeText(this, "Enter the mobile number", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Enter the email", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Enter the password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
