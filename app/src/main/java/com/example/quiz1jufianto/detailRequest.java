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
import com.example.quiz1jufianto.model.ServiceRequest;

public class detailRequest extends AppCompatActivity {

    private TextView drJudul, drAuthor, drSynopsis, requester, receiver;
    private ImageView cover;

    private Button btnAccept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_request);

        drJudul = findViewById(R.id.dr_judul);
        drAuthor = findViewById(R.id.dr_author);
        drSynopsis = findViewById(R.id.dr_synopsis);
        requester = findViewById(R.id.dr_request);
        receiver = findViewById(R.id.dr_receive);

        ServiceRequest requestDetail = getIntent().getParcelableExtra("requestDetail");
        drJudul.setText(requestDetail.getTitle());
        drAuthor.setText(requestDetail.getAuthor());
        drSynopsis.setText(requestDetail.getSynopsis());
        requester.setText(requestDetail.getRequester());
        receiver.setText(requestDetail.getReceiver());

        btnAccept = findViewById(R.id.btn_accept);
        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String requestEmail = "", receiverEmail = "", bookID, title,
                        titleChoose = drJudul.getText().toString();


                for(int i = 0 ; i < DB.requestList.size() ; i++){
                    Request request = DB.requestList.get(i);
                    bookID = request.getBookId();
                    if(bookID.equals("BK001")){
                        title = "The White Tiger";
                    }
                    else if(bookID.equals("BK003")){
                        title = "Batman Comic";
                    }
                    else{
                        title = "Harry Potter and The Sorcerer Stone";
                    }
                    if(title.equals(titleChoose)){
                        requestEmail = request.getRequesterEmail();
                        receiverEmail = request.getReceiverEmail();

                        if(DB.getLogInUser().equals(requestEmail)){
                            Toast.makeText(detailRequest.this, "Sorry.. you are not the receiver", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            DB.requestList.get(i).setReceiverEmail(DB.getLogInUser());
                            btnAccept.setVisibility(View.INVISIBLE);
                            Toast.makeText(detailRequest.this, "Accept request book is success..", Toast.LENGTH_SHORT).show();
                            Intent intent =  new Intent(detailRequest.this, RequestForm.class);
                            startActivity(intent);
                        }
                    }
                }
            }
        });

    }
}