package com.example.todemoto.loading.interactor;

import android.content.Intent;

import androidx.annotation.NonNull;

import com.example.todemoto.loading.LoadingContracts;
import com.example.todemoto.loading.presenter.LoadingPresenter;
import com.example.todemoto.loading.view.Loading;
import com.example.todemoto.login.view.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoadingInteractor implements LoadingContracts.Interactor {
    private final LoadingContracts.Presenter presenter;


    private FirebaseDatabase database = FirebaseDatabase.getInstance();

    public LoadingInteractor(LoadingContracts.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void verificandoSessao() {

        FirebaseUser current = FirebaseAuth.getInstance().getCurrentUser();
        if (current == null) {
            System.out.println("Teste: ninguém na sessão");
            presenter.goToLogin();
        }else{
            DatabaseReference myRef = database.getReference("Usuarios/Motociclista/" + current.getUid());
            myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    int res = (int) snapshot.getChildrenCount();
                    if (res > 0) {
                        System.out.println("teste: vou para tela do motociclista e na sessao:"+res +" current:"+current.getUid());
                        presenter.goToPerfilMotociclista();
                    }else{
                        System.out.println("teste: vou para tela do cliente" );
                        presenter.goToPrincipalActivity();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    presenter.onLoadingError("Erro ao carregar informações: "+error.getMessage());
                }
            });
        }
    }
}
