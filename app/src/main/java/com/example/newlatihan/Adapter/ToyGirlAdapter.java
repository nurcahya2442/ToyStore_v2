package com.example.newlatihan.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newlatihan.R;
import com.example.newlatihan.Model.Toys;

import java.util.ArrayList;

public class ToyGirlAdapter extends RecyclerView.Adapter<ToyGirlAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<Toys> imgModelArrayList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public ToyGirlAdapter(Context ctx, ArrayList<Toys>imgModelArrayList){
        inflater = LayoutInflater.from(ctx);
        this.imgModelArrayList = imgModelArrayList;
    }

    @Override
    public ToyGirlAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_list_toys, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ToyGirlAdapter.MyViewHolder holder, int position) {

        holder.iv_toys.setImageResource(imgModelArrayList.get(position).getPic());
        holder.tv_toyName.setText(imgModelArrayList.get(position).getTvJudul());
        holder.tv_desc.setText(imgModelArrayList.get(position).getTvDeks());
        holder.tv_price.setText(imgModelArrayList.get(position).getTvHarga());


    }

    @Override
    public int getItemCount() {
        return imgModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_toyName;
        TextView tv_desc;
        TextView tv_price;
        ImageView iv_toys;
        AdapterView.OnItemClickListener itemClickListener;

        public MyViewHolder(View itemView) {
            super(itemView);

            iv_toys = (ImageView) itemView.findViewById(R.id.ivListMainan);
            tv_toyName = (TextView) itemView.findViewById(R.id.tvNama_Mainan);
            tv_desc = (TextView) itemView.findViewById(R.id.tv_desk);
            tv_price = (TextView) itemView.findViewById(R.id.tv_harga);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }

                }
            });
        }
    }


}
