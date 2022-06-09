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
import com.gizemsamur.kentrehberi_main.Common.LoginSignUp.Login;
import com.gizemsamur.kentrehberi_main.MainActivity;
import com.gizemsamur.kentrehberi_main.R;
import com.gizemsamur.kentrehberi_main.User.UserDashboard;

public class ReligiousPlaceCategories extends AppCompatActivity {

    ImageView backbtn;
    EditText comment;
    Button commentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_religious_place_categories);

        backbtn = findViewById(R.id.back_pressed);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReligiousPlaceCategories.super.onBackPressed();
            }
        });
        comment = findViewById(R.id.comment);
        commentButton = findViewById(R.id.commentBtn);

        commentButton.setOnClickListener(view ->{
            AddComment();
        });
    }
    private void AddComment() {
        Toast.makeText(ReligiousPlaceCategories.this, "Yorumunuz için teşekkürler!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(ReligiousPlaceCategories.this, Comments.class));
    }
}