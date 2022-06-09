package com.gizemsamur.kentrehberi_main.Common.LoginSignUp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.gizemsamur.kentrehberi_main.Categories.HotelCategories;
import com.gizemsamur.kentrehberi_main.R;
import com.gizemsamur.kentrehberi_main.User.UserDashboard;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    ImageView backBtn;
    Button hesapBtn;
    Button girisYapBtn, btnLogOut;
    EditText etLoginEmail;
    EditText etLoginPassword;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

        hesapBtn = findViewById(R.id.hesap_olustur_btn);
        btnLogOut = findViewById(R.id.nav_logout);
        girisYapBtn = findViewById(R.id.girisyap_btn);
        etLoginEmail = findViewById(R.id.email);
        etLoginPassword = findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();

        backBtn = findViewById(R.id.login_back_button);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login.super.onBackPressed();
            }
        });

        hesapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent comment = new Intent(getApplicationContext(),SignUp.class);
                startActivity(comment);
            }
        });
        //girisYapBtn.setOnClickListener(view -> loginUser());


        girisYapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giris = new Intent(getApplicationContext(), UserDashboard.class);
                startActivity(giris);
            }
        });
    }

    public void loginUser() {
        String email = etLoginEmail.getText().toString();
        String password = etLoginPassword.getText().toString();

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            etLoginEmail.setError("Email gerekli");
            etLoginEmail.requestFocus();
            //Toast.makeText(Login.this, "Email gerekli!!", Toast.LENGTH_SHORT).show();
        }else if (password.length() < 6){
            etLoginPassword.setError("Parola gerekli");
            etLoginPassword.requestFocus();
            //Toast.makeText(Login.this, "Parola gerekli!!", Toast.LENGTH_SHORT).show();
        }
        else{
            startActivity(new Intent(Login.this, UserDashboard.class));
            /*mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(Login.this, "Giriş başarılı", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Login.this, UserDashboard.class));
                    }else{
                        Toast.makeText(Login.this, "Giriş yapılamadı: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });*/
        }
    }
    public void tanimlama7(){
        hesapBtn = findViewById(R.id.hesap_olustur_btn);
    }
    public void tanimlama8(){
        girisYapBtn = findViewById(R.id.girisyap_btn);
    }
}
