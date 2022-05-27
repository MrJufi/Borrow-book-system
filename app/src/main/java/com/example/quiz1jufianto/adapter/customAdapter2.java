package com.example.quiz1jufianto.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz1jufianto.R;
import com.example.quiz1jufianto.database.Request;
import com.example.quiz1jufianto.detailRequest;
import com.example.quiz1jufianto.model.ServiceRequest;

import java.util.Vector;

public class customAdapter2 extends RecyclerView.Adapter<customAdapter2.ViewHolder> {
    private Vector<ServiceRequest> requests;
    private Context ctx;

    public customAdapter2(Vector<ServiceRequest> requests, Context ctx) {
        this.requests = requests;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.request_view,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ServiceRequest request = requests.get(position);

        holder.title.setText(request.getTitle());
        holder.author.setText(request.getAuthor());
        holder.synopsis.setText(request.getSynopsis());
        holder.requestEmail.setText(request.getRequester());
        holder.receiverEmail.setText(request.getReceiver());

        holder.cover.setImageResource(request.getCover());

        holder.cvRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), detailRequest.class);
                intent.putExtra("requestDetail", (Parcelable) requests.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return requests.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView author, title, synopsis, requestEmail, receiverEmail;
        protected ImageView cover;
        protected CardView cvRequest;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cvRequest = itemView.findViewById(R.id.cv_request);

            synopsis = itemView.findViewById(R.id.rq_synopsis);
            author = itemView.findViewById(R.id.rq_author);
            title = itemView.findViewById(R.id.rq_title);
            requestEmail = itemView.findViewById(R.id.rq_request);
            receiverEmail = itemView.findViewById(R.id.rq_receive);

            cover = itemView.findViewById(R.id.rq_cover);


        }
    }
}
