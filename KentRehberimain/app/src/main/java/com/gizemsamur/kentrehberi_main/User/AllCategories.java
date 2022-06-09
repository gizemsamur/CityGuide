package com.gizemsamur.kentrehberi_main.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.gizemsamur.kentrehberi_main.Categories.HistoricalPlaces;
import com.gizemsamur.kentrehberi_main.Categories.HotelCategories;
import com.gizemsamur.kentrehberi_main.Categories.LibraryCategories;
import com.gizemsamur.kentrehberi_main.Categories.MarketCategories;
import com.gizemsamur.kentrehberi_main.Categories.ParkCategories;
import com.gizemsamur.kentrehberi_main.Categories.ParkingAreaCategories;
import com.gizemsamur.kentrehberi_main.Categories.ReligiousPlaceCategories;
import com.gizemsamur.kentrehberi_main.R;
import com.google.firebase.auth.FirebaseUser;

public class AllCategories extends AppCompatActivity {


    Button btn;
    ImageView backBtn;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_categories);

        //Hooks
        backBtn = findViewById(R.id.back_pressed);
        btn = findViewById(R.id.kutupBtn);
        btn2 = findViewById(R.id.parkBtn);
        btn3 = findViewById(R.id.historical_btn);
        btn4 = findViewById(R.id.hotelBtn);
        btn5 = findViewById(R.id.parkingareaBtn);
        btn6 = findViewById(R.id.marketBtn);
        btn7 = findViewById(R.id.religiousBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AllCategories.super.onBackPressed();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kutuphane = new Intent(getApplicationContext(), LibraryCategories.class);
                startActivity(kutuphane);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent parklar = new Intent(getApplicationContext(), ParkCategories.class);
                startActivity(parklar);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tarihiyerler = new Intent(getApplicationContext(), HistoricalPlaces.class);
                startActivity(tarihiyerler);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hotels = new Intent(getApplicationContext(), HotelCategories.class);
                startActivity(hotels);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent parkingareas = new Intent(getApplicationContext(), ParkingAreaCategories.class);
                startActivity(parkingareas);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent market = new Intent(getApplicationContext(), MarketCategories.class);
                startActivity(market);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent religious = new Intent(getApplicationContext(), ReligiousPlaceCategories.class);
                startActivity(religious);
            }
        });

    }

    public void tanimlama(){
        btn = findViewById(R.id.kutupBtn);
    }
    public void tanimlama2(){btn2 = findViewById(R.id.parkBtn);}
    public void tanimlama3(){btn3 = findViewById(R.id.historical_btn);}
    public void tanimlama4(){btn4 = findViewById(R.id.hotelBtn);}
    public void tanimlama5(){btn5 = findViewById(R.id.parkingareaBtn);}
    public void tanimlama6(){btn6 = findViewById(R.id.marketBtn);}
    public void tanimlama7(){btn7 = findViewById(R.id.religiousBtn);}
}
