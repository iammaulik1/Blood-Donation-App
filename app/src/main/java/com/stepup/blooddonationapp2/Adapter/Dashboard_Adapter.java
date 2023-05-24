package com.stepup.blooddonationapp2.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.stepup.blooddonationapp2.R;
import com.stepup.blooddonationapp2.databinding.MainAdapterBinding;

public class Dashboard_Adapter extends RecyclerView.Adapter<Dashboard_Adapter.ViewHolder> {

    private Activity activity;
    private String[] name;
    private Integer[] image;
    private int row_index = -1;

    public Dashboard_Adapter(Activity activity, String[] name, Integer[] image) {
        this.activity = activity;
        this.name = name;
        this.image = image;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /*View view = LayoutInflater.from(activity).inflate(R.layout.main_adapter, parent, false);
        return new ViewHolder(view);*/

        MainAdapterBinding binding = MainAdapterBinding.inflate(LayoutInflater.from(activity),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        Glide.with(activity).load(image[position]).into(holder.binding.imageViewMainAdapter);

        holder.binding.textViewMainAdapter.setText(name[position]);

        holder.binding.linearLayoutMainAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                row_index = position;
                notifyDataSetChanged();
            }
        });

        if (row_index == position) {
            holder.binding.linearLayoutMainAdapter.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.shape_selected_back));
            holder.binding.textViewMainAdapter.setTextColor(activity.getResources().getColor(R.color.drawar_text_select));
        } else {
            holder.binding.textViewMainAdapter.setTextColor(activity.getResources().getColor(R.color.black));
            holder.binding.linearLayoutMainAdapter.setBackgroundColor(activity.getResources().getColor(R.color.drawar_layout_background));
        }


    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private MainAdapterBinding binding;

        /*private ImageView imageView;
        private TextView textView_Name;
        private LinearLayout linearLayout;*/


        public ViewHolder(MainAdapterBinding binding) {
            super(binding.getRoot());
            this.binding =binding;

            /*imageView = (ImageView) itemView.findViewById(R.id.imageView_main_adapter);
            textView_Name = (TextView) itemView.findViewById(R.id.textView_main_adapter);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout_main_adapter);*/

        }
    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

}

