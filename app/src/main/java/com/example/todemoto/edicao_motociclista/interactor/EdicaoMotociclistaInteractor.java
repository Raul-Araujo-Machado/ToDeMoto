package com.example.todemoto.edicao_motociclista.interactor;

import androidx.annotation.NonNull;

import com.example.todemoto.cadastro_motociclista.entity.Motociclista;
import com.example.todemoto.edicao_motociclista.EdicaoMotociclistaContracts;
import com.example.todemoto.edicao_motociclista.presenter.EdicaoMotociclistaPresenter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EdicaoMotociclistaInteractor implements EdicaoMotociclistaContracts.Interactor {
    private final EdicaoMotociclistaContracts.Presenter presenter;

    public EdicaoMotociclistaInteractor(EdicaoMotociclistaContracts.Presenter presenter) {
        this.presenter = presenter;
    }



    @Override
    public void atualizandodados(Motociclista m, String n, String t, String d) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Usuarios").child("Motociclista").child(m.getId());
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                myRef.child("nome").setValue(n);
                myRef.child("telefone").setValue(t);
                myRef.child("descricao").setValue(d);
                presenter.onAtualizadados("Dados atualizados com sucesso!");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                presenter.onErrorAtualiza("Algo de errado durante o salvamento dos seus dados!: "+error.getMessage());
            }
        });
    }
}
