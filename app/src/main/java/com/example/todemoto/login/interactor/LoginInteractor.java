package com.example.todemoto.login.interactor;

import androidx.annotation.NonNull;

import com.example.todemoto.login.LoginContracts;
import com.example.todemoto.login.presenter.LoginPresenter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginInteractor implements LoginContracts.Interactor {
    private final LoginContracts.Presenter presenter;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();


    public LoginInteractor(LoginContracts.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void fazendoLogin(String email, String senha) {
        Task<AuthResult> resposta = mAuth.signInWithEmailAndPassword(email, senha);
        resposta.addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                presenter.goToLoading();
            }
        });
        resposta.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                presenter.onErroFazerLogin("Algo de errado ao realizar login: "+e.getLocalizedMessage());
            }
        });


    }

}
