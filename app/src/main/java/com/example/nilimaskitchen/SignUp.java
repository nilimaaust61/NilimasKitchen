package com.example.nilimaskitchen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

import java.lang.reflect.Array;
import java.util.Objects;

public class SignUp extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    private EditText signUpEmailEditTextId, signUpPasswordEditTextId, contact, retypepasswordEditTextId;
    private Button signUpButtonId;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();

        signUpButtonId = findViewById(R.id.signUpButtonId);
        signUpEmailEditTextId = findViewById(R.id.signUpEmailEditTextId);
        signUpPasswordEditTextId = findViewById(R.id.signUpPasswordEditTextId);
        contact = findViewById(R.id.contact);
        retypepasswordEditTextId = findViewById(R.id.retypepassword);

        signUpButtonId.setOnClickListener(this);


        Spinner gender = findViewById(R.id.genderSelect_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.genders, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        gender.setAdapter(adapter);

        gender.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selected = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signUpButtonId:
                userRegister();

                break;
        }

    }

    private void userRegister() {
        String email = signUpEmailEditTextId.getText().toString().trim();
        String password = signUpPasswordEditTextId.getText().toString();
        String retypepassword = retypepasswordEditTextId.getText().toString();
        if (email.isEmpty()) {
            signUpEmailEditTextId.setError("Enter a valid email address");
            signUpEmailEditTextId.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            signUpEmailEditTextId.setError("Enter a valid email address");
            signUpEmailEditTextId.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            signUpPasswordEditTextId.setError("Enter a password");
            signUpPasswordEditTextId.requestFocus();
            return;
        }
        if (password.length() < 6) {
            signUpPasswordEditTextId.setError("Minimum length of a password should be 6");
            signUpPasswordEditTextId.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(getApplicationContext(),"Registration is successful",Toast.LENGTH_SHORT).show();

                        }
                        else {
                            // If sign in fails, display a message to the user.
                            if(task.getException() instanceof FirebaseAuthUserCollisionException)
                            {
                                Toast.makeText(getApplicationContext(),"User is already registered",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"Error:"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }



                        }
                    }
                });
    }
}