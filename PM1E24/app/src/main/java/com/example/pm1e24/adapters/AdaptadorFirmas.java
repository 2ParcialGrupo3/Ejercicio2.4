package com.example.pm1e24.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pm1e24.R;
import com.example.pm1e24.modelos.Signaturess;

import java.util.List;

public class AdaptadorFirmas extends RecyclerView.Adapter<AdaptadorFirmas.SignaruressViewHolder> {

    private List<Signaturess> signaturessList;

    public AdaptadorFirmas(List<Signaturess> signaturessList) {
        this.signaturessList = signaturessList;
    }

    @NonNull
    @Override
    public SignaruressViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);

        return new SignaruressViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SignaruressViewHolder holder, int position) {
        holder.setData(signaturessList.get(position));
    }

    @Override
    public int getItemCount() {
        return signaturessList.size();
    }

    class SignaruressViewHolder extends RecyclerView.ViewHolder {

         ImageView imageView;
         TextView textViewDescripcion;

        public SignaruressViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView =  itemView.findViewById(R.id.imageViewCardView);
            textViewDescripcion = itemView.findViewById(R.id.textDescripcionCardView);
        }

        void setData(Signaturess signature){

//            try {
                textViewDescripcion.setText(signature.descripcion);
                imageView.setImageBitmap(decodeImage(signature.imagen));
//
//            }
        }
    }


    private static Bitmap decodeImage(String encodedImage){

        byte[] bytes = Base64.decode(encodedImage, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }
}
