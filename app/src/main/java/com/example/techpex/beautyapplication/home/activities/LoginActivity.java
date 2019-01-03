package com.example.techpex.beautyapplication.home.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.techpex.beautyapplication.R;
import com.example.techpex.beautyapplication.home.constants.GlobalConstant;
import com.example.techpex.beautyapplication.home.database.PrefrenceManager;

public class LoginActivity extends AppCompatActivity {

    TextView sign_up;
    EditText edt_mob_no,edt_password;
    Button btn_login;
    String mob_no,password;
    private PrefrenceManager mPrefrenceManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mPrefrenceManager = PrefrenceManager.getInstance(this);
        setLayoutRefrences();
    }

    private void setLayoutRefrences() {

        sign_up = findViewById(R.id.txt_sign_up);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,SignUpAcivity.class);
                startActivity(intent);
            }
        });

        edt_mob_no = findViewById(R.id.edt_mobile_no);
        edt_password = findViewById(R.id.edt_login_password);
        btn_login = findViewById(R.id.btn_loginBtn);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mob_no = edt_mob_no.getText().toString().trim();
                password = edt_password.getText().toString().trim();
                if (validateInputField()){
                    retriveUserData();
                }
            }
        });
    }

    private void retriveUserData() {

       String phone_no =  mPrefrenceManager.getPrefString(GlobalConstant.USER_MOB_NO);
       String password = mPrefrenceManager.getPrefString(GlobalConstant.USER_PASSWORD);
       if(phone_no.equalsIgnoreCase(mob_no)){
           if(password.equalsIgnoreCase(password)){
               openHomeActivity();
           }else {
               Toast.makeText(this, "Enter the valid password ", Toast.LENGTH_SHORT).show();
           }
       }else {
           Toast.makeText(this, "Enter the valid mobile number ", Toast.LENGTH_SHORT).show();
       }

    }

    private void openHomeActivity() {
        Intent intent = new Intent(LoginActivity.this,HomeScreenActivity.class);
        startActivity(intent);
        finish();
    }

    private boolean validateInputField() {
        if (TextUtils.isEmpty(mob_no)){
            Toast.makeText(this, "Enter the mobile number", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Enter the Password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
