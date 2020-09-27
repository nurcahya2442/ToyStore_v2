package com.example.newlatihan.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newlatihan.Model.BoyToys;
import com.example.newlatihan.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ToyBoyAdapter extends RecyclerView.Adapter<ToyBoyAdapter.MyViewHolder>{

    private LayoutInflater inflater;
    private ArrayList<BoyToys> imgModelBoyArrayList;
    private ToyBoyAdapter.OnItemClickListener bListener;

    public interface  OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        bListener = listener;
    }

    public ToyBoyAdapter(Context ctx, ArrayList<BoyToys>imgModelBoyArrayList){
        inflater = LayoutInflater.from(ctx);
        this.imgModelBoyArrayList = imgModelBoyArrayList;
    }

    @Override
    public ToyBoyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_list_toys_boy, parent,false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ToyBoyAdapter.MyViewHolder holder, int position) {

        holder.iv_boyToys.setImageResource(imgModelBoyArrayList.get(position).getImgBoy());
        holder.tv_toyName_Boy.setText(imgModelBoyArrayList.get(position).getTvName_Boy());
        holder.tv_descBoy.setText(imgModelBoyArrayList.get(position).getTvDecs_Boy());
        holder.tv_priceBoy.setText(imgModelBoyArrayList.get(position).getTvPrice_Boy());

    }
    @Override
    public int getItemCount() {
        return imgModelBoyArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_toyName_Boy;
        TextView tv_descBoy;
        TextView tv_priceBoy;
        ImageView iv_boyToys;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_boyToys = (ImageView) itemView.findViewById(R.id.iv_ListMainan_boy);
            tv_toyName_Boy = (TextView) itemView.findViewById(R.id.tvNama_Mainan_boy);
            tv_descBoy = (TextView) itemView.findViewById(R.id.tv_desk_boy);
            tv_priceBoy  = (TextView) itemView.findViewById(R.id.tv_harga_boy);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (bListener !=null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            bListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
