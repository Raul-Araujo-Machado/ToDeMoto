package com.example.todemoto.cadastro_motociclista.interactor;

import androidx.annotation.NonNull;


import com.example.todemoto.cadastro_motociclista.CadastroMotociclistaContracts;
import com.example.todemoto.cadastro_motociclista.entity.Motociclista;
import com.example.todemoto.cadastro_motociclista.presenter.CadastroMotociclistaPresenter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CadastroMotociclistaInteractor implements CadastroMotociclistaContracts.Interactor {
    private final CadastroMotociclistaContracts.Presenter presenter;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();


    public CadastroMotociclistaInteractor(CadastroMotociclistaContracts.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void salvaMotociclistaAuth(Motociclista m) {
        System.out.println("teste: peguei o motociclista" +m.getEmail() +m.getSenha());
        Task<AuthResult> resposta = mAuth.createUserWithEmailAndPassword(m.getEmail(), m.getSenha());
        resposta.addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                m.setId(mAuth.getUid());
                presenter.onMotociclistaAuthSaved(m);
                System.out.println("teste: consegui salvar motociclista no Auth e : "+m.getDisponivel());
            }
        });
        resposta.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                presenter.onSavedErrorAuth("Erro ao salvar motociclista no FireAuth: "+e.getLocalizedMessage());
                e.printStackTrace();
            }
        });
    }

    @Override
    public void salvaMotociclistaRT(Motociclista m) {
        Task<Void> resposta = referencia.child("Usuarios").child("Motociclista").child(m.getId()).setValue(m);
        resposta.addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                presenter.onMotociclistaSaved();
                System.out.println("teste: consegui salvar motocilcista no realtime");
            }
        });
        resposta.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                presenter.onSavedErrorRT("Erro ao salvar no FireRealTime: "+e.getLocalizedMessage());
                e.printStackTrace();
            }
        });
    }
}
