package com.example.todemoto.loading.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.todemoto.PrincipalActivity;
import com.example.todemoto.R;
import com.example.todemoto.loading.LoadingContracts;
import com.example.todemoto.loading.presenter.LoadingPresenter;
import com.example.todemoto.login.view.LoginActivity;
import com.example.todemoto.perfil_motociclista.view.PerfilMotociclistaActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Loading extends AppCompatActivity implements LoadingContracts.View {

    private LoadingContracts.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        presenter = new LoadingPresenter(this);


        presenter.verificaSessao();


    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void onLoadingError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}