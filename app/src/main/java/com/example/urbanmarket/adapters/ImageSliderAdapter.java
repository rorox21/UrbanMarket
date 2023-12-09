package com.example.urbanmarket.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.urbanmarket.R;

import java.util.List;

public class ImageSliderAdapter extends RecyclerView.Adapter<ImageSliderAdapter.ViewHolder> {

    private final List<Integer> imageList;

    public ImageSliderAdapter(List<Integer> imageList) {
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflar el diseño del elemento del ViewPager2
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_image_slider, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Establecer la imagen en el ImageView
        holder.imageView.setImageResource(imageList.get(position));
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    // ViewHolder para el adaptador
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Referenciar el ImageView en el diseño del elemento del ViewPager2
            imageView = itemView.findViewById(R.id.image_slider_item);
        }
    }
}
