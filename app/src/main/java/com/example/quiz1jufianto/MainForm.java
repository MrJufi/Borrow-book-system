package com.example.quiz1jufianto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.quiz1jufianto.adapter.customAdapter;
import com.example.quiz1jufianto.model.Service;

import java.util.ArrayList;
import java.util.Vector;

public class MainForm extends AppCompatActivity {

    private Vector<Service> services = new Vector<>();
    private RecyclerView rvServices;
    private Button btnView, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_form);

        services.add(new Service("White Tiger", "Aravind Adiga", "The White Tiger is a novel by Indian " +
                "author Aravind Adiga. It was published in 2008 and won the 40th Man Booker Prize the same year.", R.drawable.tiger));

        services.add(new Service("Harry Potter and The Sorcerer Stone", "J.K.Rowling", "Synopsis :" +
                "            An orphaned boy enrolls in a school of wizardry," +
                "            where he learns the truth about himself, his family and the " +
                "            terrible evil that haunts the magical world.", R.drawable.harry_potter));

        services.add(new Service("Batman Comic", "Bob Kane & Bill Finger", "Batman's origin story features him swearing vengeance against " +
                "criminals after witnessing the murder of his parents Thomas and Martha", R.drawable.batman));

        rvServices = findViewById(R.id.rv_services);
        rvServices.setAdapter(new customAdapter(services, this));
        rvServices.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menumain, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuView){
            Intent intent = new Intent(MainForm.this, RequestForm.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(MainForm.this, Login.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}