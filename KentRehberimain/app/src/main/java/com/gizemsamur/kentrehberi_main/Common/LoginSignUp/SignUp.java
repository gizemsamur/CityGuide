package com.gizemsamur.kentrehberi_main.Common.LoginSignUp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.gizemsamur.kentrehberi_main.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    //Firebase
    private FirebaseAuth mAuth;

    //Variables
    ImageView backBtn;
    Button createaccount, login;
    TextView titleText, registerUser;
    EditText editTextName, editTextLastName, editTextEmail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        //Firebase
        mAuth = FirebaseAuth.getInstance();

        //Hooks
        backBtn = findViewById(R.id.signup_back_button);
        createaccount = findViewById(R.id.create_account_button);
        titleText = findViewById(R.id.signup_title_text);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUp.super.onBackPressed();
            }
        });
        createaccount.setOnClickListener(view ->{
            createaccount();
        });
        editTextName = findViewById(R.id.name);
        editTextLastName = findViewById(R.id.lastName);
        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
    }

    public void callNextSignupScreen(View view) {

        Intent intent = new Intent(getApplicationContext(), Login.class);

        //Add Transition
        Pair[] pairs = new Pair[3];

        pairs[0] = new Pair<View, String>(backBtn, "transition_back_arrow_btn");
        pairs[1] = new Pair<View, String>(createaccount, "transition_create_account_btn");
        pairs[2] = new Pair<View, String>(titleText, "transition_title_btn");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.create_account_button:
                createaccount();
        }

    }
    private void createaccount(){
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        String name = editTextName.getText().toString();
        String lastName = editTextLastName.getText().toString();

        if (TextUtils.isEmpty(email)){
            editTextEmail.setError("Email gerekli");
            editTextEmail.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            editTextPassword.setError("Parola gerekli");
            editTextPassword.requestFocus();
        }else if (TextUtils.isEmpty(name)){
            editTextName.setError("İsim gerekli");
            editTextName.requestFocus();
        }else if (TextUtils.isEmpty(lastName)){
            editTextLastName.setError("Soyisim gerekli");
            editTextLastName.requestFocus();
        }
        else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(SignUp.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignUp.this, Login.class));
                    }else{
                        Toast.makeText(SignUp.this, "Kayıt Başarısız: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    /*private void createaccount(){
        String email = editTextEmail.getText().toString().trim();
        String name = editTextName.getText().toString().trim();
        String lastName = editTextLastName.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(name.isEmpty()){
            editTextName.setError("İsim gerekli!");
            editTextName.requestFocus();
            return;
        }
        if(lastName.isEmpty()){
            editTextLastName.setError("Soyisim gerekli!");
            editTextLastName.requestFocus();
            return;
        }
        if (email.isEmpty()){
            editTextEmail.setError("Email gerekli!");
            editTextEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Lütfen geçerli bir email giriniz!");
            editTextEmail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            editTextPassword.setError("Parola gerekli!");
            editTextPassword.requestFocus();
            return;
        }
        if(password.length() < 6){
            editTextPassword.setError("Parola minimum 6 karakterden oluşmalıdır!");
            editTextPassword.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        Users users = new Users(name,lastName,email);
                        Toast.makeText(SignUp.this, "GİRDİ", Toast.LENGTH_LONG).show();
                        FirebaseDatabase.getInstance().getReference("Users")
                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                .setValue(users).addOnCompleteListener(task1 -> {
                                    if(task1.isSuccessful()){
                                        Toast.makeText(SignUp.this,"Kayıt başarıyla tamamlandı", Toast.LENGTH_LONG).show();
                                    }
                                    else{
                                        Toast.makeText(SignUp.this, "Kayıt yapılamadı", Toast.LENGTH_LONG).show();
                                    }
                                });
                    }else {
                        Toast.makeText(SignUp.this, "Kayıt yapılamadı", Toast.LENGTH_LONG).show();
                    }
                });
    }*/
}}


/*mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Users users = new Users(name,lastName,email);
                            Toast.makeText(SignUp.this, "GİRDİ", Toast.LENGTH_LONG).show();
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(SignUp.this,"Kayıt başarıyla tamamlandı", Toast.LENGTH_LONG).show();
                                    }
                                    else{
                                        Toast.makeText(SignUp.this, "Kayıt yapılamadı", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                        }else {
                            Toast.makeText(SignUp.this, "Kayıt yapılamadı", Toast.LENGTH_LONG).show();
                        }
                    }
                });*/