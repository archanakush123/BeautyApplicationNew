package com.example.techpex.beautyapplication.home.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.techpex.beautyapplication.R;

public class SchemeGridActivity extends AppCompatActivity implements View.OnClickListener {

    CardView card_1, card_2, card_3, card_4;
    Toolbar my_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheme_grid);
        setLayoutRefs();
    }

    private void setLayoutRefs() {

        card_1 = findViewById(R.id.card_1);
        card_1.setOnClickListener(this);
        card_2 = findViewById(R.id.card_2);
        card_2.setOnClickListener(this);
        card_3 = findViewById(R.id.card_3);
        card_3.setOnClickListener(this);
        card_4 = findViewById(R.id.card_4);
        card_4.setOnClickListener(this);

        my_toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(my_toolbar);


    }

    @Override
    public void onClick(View view) {

       switch(view.getId())
        {
            case R.id.card_1 :
                openOffer1();
                break;
            case R.id.card_2 :
                openOffer2();
                break;
            case R.id.card_3 :
                openOffer3();
                break;
            case R.id.card_4 :
                openOffer4();
                break;
            default:
                break;
        }

    }

    private void openOffer4() {
        Intent intent = new Intent(SchemeGridActivity.this,FixAppointmentActivity.class);
        startActivity(intent);
    }

    private void openOffer3() {
        Intent intent = new Intent(SchemeGridActivity.this,FixAppointmentActivity.class);
        startActivity(intent);
    }

    private void openOffer2() {
        Intent intent = new Intent(SchemeGridActivity.this,FixAppointmentActivity.class);
         startActivity(intent);
    }


    private void openOffer1() {

        Intent intent = new Intent(SchemeGridActivity.this,FixAppointmentActivity.class);
        startActivity(intent);
    }
}