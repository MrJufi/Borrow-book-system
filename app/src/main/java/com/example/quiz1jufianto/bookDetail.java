package com.example.quiz1jufianto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz1jufianto.database.DB;
import com.example.quiz1jufianto.database.Request;
import com.example.quiz1jufianto.model.Service;
import com.example.quiz1jufianto.database.User;

public class bookDetail extends AppCompatActivity {

    private TextView dtJudul, dtSynopsis, dtAuthor;
    private ImageView dtGambar;

    private Button btnBorrow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        //Init Comp
        dtJudul = findViewById(R.id.dt_judul);
        dtSynopsis = findViewById(R.id.dt_synopsis);
        dtAuthor = findViewById(R.id.dt_author);
        dtGambar = findViewById(R.id.dt_gambar);

        btnBorrow = findViewById(R.id.btn_borrow);

        Service book = getIntent().getParcelableExtra("books");
        dtJudul.setText(book.getTitle());
        dtSynopsis.setText(book.getSynopsis());
        dtAuthor.setText(book.getAuthor());
        dtGambar.setImageResource(book.getImg());

        btnBorrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bookTitle = dtJudul.getText().toString(),
                        bookId = "", requestEmail = "", receiveEmail = "";

                if(bookTitle.equals("White Tiger")){
                    bookId = "BK001";
                }

                else if(bookTitle.equals("Batman Comic")){
                    bookId = "BK003";
                }
                else{
                    bookId = "BK002";
                }

                for(int j = 0 ; j < DB.listUser.size() ; j++){
                    User user = DB.listUser.get(j);
                    requestEmail = user.getEmail();
                }

                DB database = new DB();
                database.addNewRequest(bookId, requestEmail, receiveEmail);

                for(int i = 0 ; i< DB.requestList.size() ; i++){
                    Request q = DB.requestList.get(i);
                }
                Toast.makeText(bookDetail.this, "Request Borrowing Sucess...", Toast.LENGTH_SHORT).show();
            }
        });

    }
}