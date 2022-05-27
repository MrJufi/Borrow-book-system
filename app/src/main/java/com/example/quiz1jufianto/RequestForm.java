package com.example.quiz1jufianto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz1jufianto.adapter.customAdapter;
import com.example.quiz1jufianto.adapter.customAdapter2;
import com.example.quiz1jufianto.database.DB;
import com.example.quiz1jufianto.database.Request;
import com.example.quiz1jufianto.model.ServiceRequest;

import java.util.Vector;

public class RequestForm extends AppCompatActivity {

    private Vector<ServiceRequest> requests = new Vector<>();
    private RecyclerView rvRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_form);

        for(int i = 0 ; i < DB.requestList.size() ; i++){
            Request rq = DB.requestList.get(i);
            String bookId = rq.getBookId(),
                    requestEmail = rq.getRequesterEmail(),
                    receiveEmail = rq.getReceiverEmail();

            if(receiveEmail.equals("")){
                receiveEmail = "-";
            }

            if(bookId.equals("BK001")){
                requests.add(new ServiceRequest("The White Tiger" , "Aravind Adiga",
                        "Synopsis : The White Tiger is a novel by Indian" +
                                "author Aravind Adiga. It was published in 2008 and won the 40th Man Booker Prize the same year.", requestEmail, receiveEmail, R.drawable.tiger));
            }
            else if(bookId.equals("BK003")){
                requests.add(new ServiceRequest("Batman Comic" , "Bob Kane & Bill Finger",
                        "Synopsis : Batman's origin story features him swearing vengeance against criminals after witnessing the murder of his parents Thomas and Martha",requestEmail, receiveEmail, R.drawable.batman));
            }
            else {
                requests.add(new ServiceRequest("Harry Potter and The Sorcerer Stone" , "J.K.Rowling",
                        "Synopsis : An orphaned boy enrolls in a school of wizardry where he learns the truth about " +
                                "himself, his family and the terrible evil that haunts the magical world.",requestEmail, receiveEmail, R.drawable.harry_potter));
            }
        }

        rvRequest = findViewById(R.id.rv_request);
        rvRequest.setAdapter(new customAdapter2(requests, this));
        rvRequest.setLayoutManager(new LinearLayoutManager(this));

    }
}