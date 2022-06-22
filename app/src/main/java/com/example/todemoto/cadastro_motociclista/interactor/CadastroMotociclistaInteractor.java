package com.example.todemoto.cadastro_motociclista.interactor;

import androidx.annotation.NonNull;

import com.example.todemoto.cadastro_motociclista.CadastroMotociclistaContracts;
import com.example.todemoto.cadastro_motociclista.entity.Motociclista;
import com.example.todemoto.cadastro_motociclista.presenter.CadastroMotociclistaPresenter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CadastroMotociclistaInteractor implements CadastroMotociclistaContracts.Interactor {

    private final CadastroMotociclistaPresenter presenter;

    public CadastroMotociclistaInteractor(CadastroMotociclistaPresenter cadastroMotociclistaPresenter) {
        this.presenter = cadastroMotociclistaPresenter;
    }

    @Override
    public void salvaMotociclistaAuth(Motociclista motociclista) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(motociclista.getEmail(),motociclista.getSenha()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                motociclista.setId(mAuth.getUid());
                presenter.onMotociclistaAuthSaved(motociclista);
            }
        });
    }

    @Override
    public void salvaMotociclistaRT(Motociclista motociclista) {
        System.out.println("teste "+motociclista.toString());
        DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
        referencia.child("Usuarios/Motociclista").child(motociclista.getId()).setValue(motociclista);
        presenter.onMotociclistaSaved(motociclista);
    }
}
