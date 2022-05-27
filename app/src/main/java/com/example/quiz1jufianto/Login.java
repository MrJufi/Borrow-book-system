package com.example.quiz1jufianto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz1jufianto.database.DB;
import com.example.quiz1jufianto.database.User;

import java.util.Vector;

public class Login extends AppCompatActivity {

    private TextView txtRegister;
    private EditText etEmail, etPassword;
    private Button btnLogin;

    Vector<User> listUser = new Vector<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtRegister = findViewById(R.id.txt_register);

        etEmail = findViewById(R.id.et_email_login);
        etPassword = findViewById(R.id.et_password_login);

        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString(),
                        password = etPassword.getText().toString();


                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Login.this, "All fields must be filled", Toast.LENGTH_SHORT).show();
                }
                else{
                    for(int i = 0 ; i< DB.listUser.size() ; i++) {
                        User user = DB.listUser.get(i);

                        if (!email.equals(user.getEmail()) || !password.equals(user.getPassword())) {
                            Toast.makeText(Login.this, "Credencials not match !", Toast.LENGTH_SHORT).show();
                        }

                        else{
                            DB.setLogInUser(email);

                            Intent intent = new Intent(Login.this, MainForm.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            intent.putExtra("idUser", user.getId());
                            startActivity(intent);
                        }
                    }
                }

            }
        });

        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);

            }
        });


    }
}