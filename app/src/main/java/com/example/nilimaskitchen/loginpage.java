package com.example.nilimaskitchen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class loginpage extends AppCompatActivity implements View.OnClickListener {
    private EditText signInEmailEditTextId, signInPasswordEditTextId;
    private Button signInButtonId,signUpButtonId;
    ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_loginpage);
        mAuth = FirebaseAuth.getInstance();

        signInButtonId=findViewById(R.id.signInButtonId);
        signUpButtonId=findViewById(R.id.signUpButtonId);
        signInEmailEditTextId=findViewById(R.id.signInEmailEditTextId);
        signInPasswordEditTextId=findViewById(R.id.signInPasswordEditTextId);
        progressBar=findViewById(R.id.progressBarId);

        signInButtonId.setOnClickListener(this);
        signUpButtonId.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.signInButtonId:
                userLogin();
                break;

            case R.id.signUpButtonId:
                Intent intent= new Intent(getApplicationContext(),SignUp.class);
                startActivity(intent);
                break;
        }

    }

    private void userLogin() {
        String email = signInEmailEditTextId.getText().toString().trim();
        String password = signInPasswordEditTextId.getText().toString();
        if (email.isEmpty()) {
            signInEmailEditTextId.setError("Enter a valid email address");
            signInEmailEditTextId.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            signInEmailEditTextId.setError("Enter a valid email address");
            signInEmailEditTextId.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            signInPasswordEditTextId.setError("Enter a password");
            signInPasswordEditTextId.requestFocus();
            return;
        }
        if (password.length() < 6) {
            signInPasswordEditTextId.setError("Minimum length of a password should be 6");
            signInPasswordEditTextId.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Intent intent = new Intent(getApplicationContext(),Dashboardesign.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Login is not successful",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
