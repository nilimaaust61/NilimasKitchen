package com.example.nilimaskitchen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Dashboardesign extends AppCompatActivity implements View.OnClickListener {
 private TextView myDashBoardTextViewId, dashboardtextviewid1, dashboardtextviewid2,dashboardtextviewid3,dashboardtextviewid4,dashboardtextviewid5,dashboardtextviewid6,dashboardtextviewid7,dashboardtextviewid8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboardesign);
        myDashBoardTextViewId=findViewById(R.id.myDashBoardTextViewId);
        dashboardtextviewid1=findViewById(R.id.dashboardtextviewid1);
        dashboardtextviewid2=findViewById(R.id.dashboardtextviewid2);
        dashboardtextviewid3=findViewById(R.id.dashboardtextviewid3);
        dashboardtextviewid4=findViewById(R.id.dashboardtextviewid4);
        dashboardtextviewid5=findViewById(R.id.dashboardtextviewid5);
        dashboardtextviewid6=findViewById(R.id.dashboardtextviewid6);
        dashboardtextviewid7=findViewById(R.id.dashboardtextviewid7);
        dashboardtextviewid8=findViewById(R.id.dashboardtextviewid8);

        dashboardtextviewid1.setOnClickListener(this);
        dashboardtextviewid2.setOnClickListener(this);
        dashboardtextviewid3.setOnClickListener(this);
        dashboardtextviewid4.setOnClickListener(this);
        dashboardtextviewid5.setOnClickListener(this);
        dashboardtextviewid6.setOnClickListener(this);
        dashboardtextviewid7.setOnClickListener(this);
        dashboardtextviewid8.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.dashboardtextviewid1:
                Intent dessertintent= new Intent(getApplicationContext(),Dessert.class);
                startActivity(dessertintent);
                break;

            case R.id.dashboardtextviewid2:
                Intent thaiintent= new Intent(getApplicationContext(),ThaiFood.class);
                startActivity(thaiintent);
                break;

            case R.id.dashboardtextviewid3:
                Intent chineseintent= new Intent(getApplicationContext(),ChineseFood.class);
                startActivity(chineseintent);
                break;

            case R.id.dashboardtextviewid4:
                Intent italianintent= new Intent(getApplicationContext(),ItalianFood.class);
                startActivity(italianintent);
                break;

            case R.id.dashboardtextviewid5:
                Intent streetfoodintent= new Intent(getApplicationContext(),StreetFood.class);
                startActivity(streetfoodintent);
                break;
            case R.id.dashboardtextviewid6:
                Intent mexicanfoodintent= new Intent(getApplicationContext(),MexicanFood.class);
                startActivity(mexicanfoodintent);
                break;
            case R.id.dashboardtextviewid7:
                Intent junkfoodintent= new Intent(getApplicationContext(),JunkFood.class);
                startActivity(junkfoodintent);
                break;

            case R.id.dashboardtextviewid8:
                Intent bengalifoodintent= new Intent(getApplicationContext(),BengaliFood.class);
                startActivity(bengalifoodintent);
                break;

        }

    }
}
