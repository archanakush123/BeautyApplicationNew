package com.example.techpex.beautyapplication.home.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.techpex.beautyapplication.R;

import java.util.Arrays;
import java.util.List;

public class FixAppointmentActivity extends AppCompatActivity implements View.OnClickListener{

    Button  btn_add_more,btn_fix_appointment;
    Spinner spn_location;
    String SELECTED_LOCATION_NAME = "";
    int spineerLocation;
    EditText tied_name,tied_mob_no,tied_password;
    String name,mob_no,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_appointment);
        setLayoutRefs();
        setSpineerRefrences();
    }

    private void setSpineerRefrences() {

        String[] cityArray = getResources().getStringArray(R.array.location_list);
        List<String> cityList = Arrays.asList(cityArray);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cityList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_location.setAdapter(adapter);

        spn_location.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (!(position == 0)) {
                    SELECTED_LOCATION_NAME = parent.getItemAtPosition(position).toString();
                    //txt_overlap_state.setText(SELECTED_STATE_NAME);
                    spineerLocation++;
                    Toast.makeText(FixAppointmentActivity.this, SELECTED_LOCATION_NAME, Toast.LENGTH_SHORT).show();
                } else {

                    SELECTED_LOCATION_NAME = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setLayoutRefs() {

        tied_name = findViewById(R.id.tied_name);
        tied_mob_no = findViewById(R.id.tied_mob_no);
        tied_password = findViewById(R.id.tied_password);
        btn_add_more = findViewById(R.id.btn_add_more);
        btn_add_more.setOnClickListener(this);
        btn_fix_appointment = findViewById(R.id.btn_fix_appointment);
        spn_location = findViewById(R.id.spn_location);
        btn_fix_appointment.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.btn_add_more:
                Intent intent = new Intent(FixAppointmentActivity.this,CartActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_fix_appointment:
                name = tied_name.getText().toString().trim();
                mob_no = tied_mob_no.getText().toString().trim();
                password = tied_password.getText().toString().trim();

                if (validateInputField()){

                }
                Intent  intent1 = new Intent(FixAppointmentActivity.this,CartActivity.class);
                startActivity(intent1);
                finish();
                break;

            default:
                break;

        }
    }

    private boolean validateInputField() {

        if(TextUtils.isEmpty(name)){
            Toast.makeText(this, "Enter the name", Toast.LENGTH_SHORT).show();
            return false;
        } if(TextUtils.isEmpty(mob_no)){
            Toast.makeText(this, "Enter the mobile  number", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Enter the password", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
