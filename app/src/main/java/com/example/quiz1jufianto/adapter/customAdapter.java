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
import com.example.quiz1jufianto.bookDetail;
import com.example.quiz1jufianto.model.Service;

import java.util.Vector;

public class customAdapter extends RecyclerView.Adapter<customAdapter.ViewHolder> {

    private Vector<Service>services;
    private Context ctx;

    public customAdapter(Vector<Service> services, Context ctx) {
        this.services = services;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_view,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Service service = services.get(position);

        holder.title.setText(service.getTitle());
        holder.author.setText(service.getAuthor());
        holder.synopsis.setText(service.getSynopsis());
        holder.img.setImageResource(service.getImg());

        holder.cvService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(holder.itemView.getContext(), bookDetail.class);
                intent.putExtra("books", (Parcelable) services.get(position));
                holder.itemView.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return services.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        protected TextView title, author, synopsis;
        protected ImageView img;
        protected CardView cvService;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cvService = itemView.findViewById(R.id.cv_service);

            title = itemView.findViewById(R.id.tv_title);
            author = itemView.findViewById(R.id.tv_author);
            synopsis = itemView.findViewById(R.id.tv_synopsis);

            img = itemView.findViewById(R.id.img);

        }
    }
}
