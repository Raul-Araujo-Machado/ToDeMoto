package com.example.todemoto.edicao_cliente.interactor;

import androidx.annotation.NonNull;

import com.example.todemoto.cadastro_cliente.entity.Cliente;
import com.example.todemoto.edicao_cliente.EdicaoClienteContracts;
import com.example.todemoto.edicao_cliente.presenter.EdicaoClientePresenter;
import com.example.todemoto.edicao_motociclista.presenter.EdicaoMotociclistaPresenter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EdicaoClienteInteractor implements EdicaoClienteContracts.Interactor {
    private final EdicaoClienteContracts.Presenter presenter;
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    public EdicaoClienteInteractor(EdicaoClienteContracts.Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void atualizandodados(Cliente c, String n) {
        DatabaseReference myRef = database.getReference("Usuarios").child("Cliente").child(c.getId());
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                myRef.child("nome").setValue(n);
                presenter.onAtualizadados("Dados Atualizados com sucesso!");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                presenter.onErrorAtualiza("Erro ao atualizar seus dados!: "+error.getMessage());
            }
        });
    }
}
