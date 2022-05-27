package com.example.quiz1jufianto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.quiz1jufianto.database.DB;
import com.example.quiz1jufianto.database.User;

import java.util.Calendar;

public class Register extends AppCompatActivity {

    private EditText etEmail, etPassword, etPhone;
    private CheckBox cbTerms;
    private Button btnSubmit;

    private int age;
    private String date;
    TextView datePick;
    DatePickerDialog.OnDateSetListener setListener;

    private int digit = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Init Components
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        etPhone = findViewById(R.id.et_phone);

        cbTerms = findViewById(R.id.cb_terms);
        btnSubmit = findViewById(R.id.btn_submit);

        datePick = findViewById(R.id.datePicker);
        Calendar calendar = Calendar.getInstance();

        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        datePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        Register.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, setListener,
                        year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }

            ;
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                date = day + "/" + month + "/" + year;
                datePick.setText(date);
                age = 2022 - year;
            }
        };


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString(),
                        password = etPassword.getText().toString(),
                        phone = etPhone.getText().toString(),
                        id = "US00" + digit;

                String date = datePick.getText().toString();

                if (email.isEmpty() || password.isEmpty() || phone.isEmpty()) {
                    Toast.makeText(Register.this, "All fields must be filled !", Toast.LENGTH_SHORT).show();
                } else if (password.length() < 8) {
                    Toast.makeText(Register.this, "Password must more than 8 characters", Toast.LENGTH_SHORT).show();
                } else if (checkDigit(password) == false) {
                    Toast.makeText(Register.this, "Password must contains at least 1 digit, and 1 letter !", Toast.LENGTH_SHORT).show();
                } else if (!phone.startsWith("+62")) {
                    Toast.makeText(Register.this, "Phone number must starts with +62 !", Toast.LENGTH_SHORT).show();
                } else if (phone.length() < 10 || phone.length() > 15) {
                    Toast.makeText(Register.this, "Phone number must be between 10 and 15 !", Toast.LENGTH_SHORT).show();
                } else if (date.equals("Select Date..")) {
                    Toast.makeText(Register.this, "Select your date of birth", Toast.LENGTH_SHORT).show();
                } else if (age < 13) {
                    Toast.makeText(Register.this, "Age can't be under 13 years old !", Toast.LENGTH_SHORT).show();
                } else if (!cbTerms.isChecked()) {
                    Toast.makeText(Register.this, "You must agree to the terms !", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Register.this, "Register Successful", Toast.LENGTH_SHORT).show();
                    DB database = new DB();
                    database.addNewUser(id, email, password, phone, date);

                    digit++;

                    Intent intent = new Intent(Register.this, Login.class);
                    startActivity(intent);

                    Toast.makeText(Register.this, "Registration Success", Toast.LENGTH_SHORT).show();

                }
            }

            ;

            private String idInit(String id, int digit) {
                id = "US00" + digit;
                return id;
            }

            private boolean checkDigit(String password) {
                int alpha = 0;
                int num = 0;

                for (int z = 0; z < password.length(); z++) {
                    if (Character.isLetter(password.charAt(z))) {
                        alpha++;
                    } else if (Character.isDigit(password.charAt(z))) {
                        num++;
                    }

                    if (alpha > 0 && num > 0) {
                        return true;
                    }
                }
                return false;
            }
        });

    }
}