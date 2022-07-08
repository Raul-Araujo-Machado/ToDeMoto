package com.example.todemoto.disponiveis.interactor;

import androidx.annotation.NonNull;

import com.example.todemoto.disponiveis.DisponiveisContracts;
import com.example.todemoto.disponiveis.presenter.DisponiveisPresenter;
import com.example.todemoto.perfil_motociclista.entity.CardMotociclista;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DisponiveisInteractor implements DisponiveisContracts.Interactor {
    private final DisponiveisContracts.Presenter presenter;

    public DisponiveisInteractor(DisponiveisContracts.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void buscandoDisponiveisCard() {
        ArrayList<CardMotociclista> ml = new ArrayList<>();
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("cardMoto");
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot data : snapshot.getChildren()){
                    CardMotociclista m = (CardMotociclista) data.getValue(CardMotociclista.class);
                    ml.add(m);
                }
                if (ml.isEmpty()){
                    presenter.messageFeedBack("Nenhum motociclista disponível no momento!");
                    presenter.goToFavoritos();
                }else{
                    presenter.onBuscaDisponiveisCard(ml);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                presenter.messageFeedBack("Algo de errado ao carregar motociclistas!: "+error.getMessage());

            }
        });
    }
}
