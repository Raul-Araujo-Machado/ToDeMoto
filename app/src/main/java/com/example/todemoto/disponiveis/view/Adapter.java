package com.example.todemoto.disponiveis.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todemoto.R;
import com.example.todemoto.perfil_motociclista.entity.CardMotociclista;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {


    private final ArrayList<CardMotociclista> ml;

    public Adapter(ArrayList<CardMotociclista> ml) {
        this.ml = ml;
        System.out.println("teste: disponiveis/adapter"+ ml.get(0));
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View indiceDisponiveislayout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.indicedisponiveislayout, parent, false);
        //nessa função setto o layout dos indices
        return new MyViewHolder(indiceDisponiveislayout);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //nesse metodo eu setto os valores dentro do indice
        //holder.fotoMotociclista.setImageIcon(Icon.createWithContentUri("@drawable/ic_disponiveis"));
        CardMotociclista c = ml.get(position);
        holder.nomeMotociclista.setText(c.getNome());
        holder.distanciaMotociclista.setText(c.getDistancia());
        holder.avaliacaoMotociclista.setText(c.getNota());

    }

    @Override
    public int getItemCount() {
        //metodo que define quantos registros serão exibidos
        return ml.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        //esta classe eu associo as variaveis com os campos dos indices
        //ImageView fotoMotociclista;
        TextView nomeMotociclista;
        TextView avaliacaoMotociclista;
        TextView distanciaMotociclista;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //fotoMotociclista = itemView.findViewById(R.id.imagemMotociclista);
            nomeMotociclista = itemView.findViewById(R.id.nomeMotociclista);
            avaliacaoMotociclista = itemView.findViewById(R.id.avaliacaoMotociclista);
            distanciaMotociclista = itemView.findViewById(R.id.distanciaMotociclista);
        }
    }
}
