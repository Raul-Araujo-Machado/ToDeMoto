package com.example.todemoto.perfil_cliente.interactor;

import android.content.Intent;

import androidx.annotation.NonNull;

import com.example.todemoto.cadastro_cliente.entity.Cliente;
import com.example.todemoto.login.view.LoginActivity;
import com.example.todemoto.perfil_cliente.PerfilClienteContracts;
import com.example.todemoto.perfil_cliente.presenter.PerfilClientePresenter;
import com.example.todemoto.perfil_cliente.view.PerfilClienteActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PerfilClienteInteractor implements PerfilClienteContracts.Interactor {
    private final PerfilClientePresenter presenter;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseDatabase database = FirebaseDatabase.getInstance();

    public PerfilClienteInteractor(PerfilClientePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void carregandoInfoCliente() {
        DatabaseReference myRef = database.getReference("Usuarios/Cliente/" + mAuth.getUid());
        System.out.println("teste: estou pegando o usuario: "+mAuth.getUid());
        System.out.println( "teste: "+myRef.getDatabase());
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Cliente c = (Cliente) snapshot.getValue(Cliente.class);
                presenter.onCarregarInfoCliente(c);
                presenter.chamaEdicaoCliente(c);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                presenter.onErroCarregarInfoCliente("Erro ao carregar informações de perfil: "+error.getMessage());
            }
        });
    }

    @Override
    public void logOutingCliente() {
        mAuth.signOut();
        System.out.println("teste: tô no logout"+mAuth.getUid());
        presenter.onLogOutCliente();
    }
}
