package com.gizemsamur.kentrehberi_main.Categories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.gizemsamur.kentrehberi_main.Comments;
import com.gizemsamur.kentrehberi_main.R;

public class ParkingAreaCategories extends AppCompatActivity {

    ImageView backbtn;
    EditText comment;
    Button commentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_area_categories);

        backbtn = findViewById(R.id.back_pressed);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParkingAreaCategories.super.onBackPressed();
            }
        });
        comment = findViewById(R.id.comment);
        commentButton = findViewById(R.id.commentBtn);

        commentButton.setOnClickListener(view ->{
            AddComment();
        });
    }
    private void AddComment() {
        Toast.makeText(ParkingAreaCategories.this, "Yorumunuz için teşekkürler!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(ParkingAreaCategories.this, Comments.class));
    }
}