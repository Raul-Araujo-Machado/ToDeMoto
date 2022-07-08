package com.example.todemoto.perfil_motociclista.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.todemoto.R;
import com.example.todemoto.cadastro_motociclista.entity.Motociclista;
import com.example.todemoto.edicao_motociclista.view.EdicaoMotociclistaActivity;
import com.example.todemoto.login.view.LoginActivity;
import com.example.todemoto.perfil_motociclista.PerfilMotociclistaContracts;
import com.example.todemoto.perfil_motociclista.presenter.PerfilMotociclistaPresenter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PerfilMotociclistaActivity extends AppCompatActivity implements PerfilMotociclistaContracts.View {

    private Button sairPerfilMotociclista;
    private TextView nomeMotociclistaPerfil;
    private TextView emailMotociclistaPerfil;
    private TextView telefoneMotociclistaPerfil;
    private TextView descricaoMotociclistaPerfil;
    private Button editarMotociclistaPerfil;
    private Switch disponivelMotociclistaPerfil;
    private PerfilMotociclistaContracts.Presenter presenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_motociclista);

        presenter = new PerfilMotociclistaPresenter(this);
        nomeMotociclistaPerfil = findViewById(R.id.nomeMotociclistaPerfil);
        emailMotociclistaPerfil = findViewById(R.id.emailMotociclistaPerfil);
        telefoneMotociclistaPerfil = findViewById(R.id.telefoneMotociclistaPerfil);
        descricaoMotociclistaPerfil = findViewById(R.id.descricaoMotociclistaPerfil);
        editarMotociclistaPerfil = findViewById(R.id.editarMotociclistaPerfil);
        sairPerfilMotociclista = findViewById(R.id.sairPerfilMotociclista);
        disponivelMotociclistaPerfil = findViewById(R.id.disponivelMotociclistaPerfil);

        presenter.carregarInfoMotociclista();

        sairPerfilMotociclista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.logOutMotociclista();
            }
        });
    }

    @Override
    public void onCarregarInfoError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void carregarTelaMotociclista(Motociclista m) {
        nomeMotociclistaPerfil.setText(m.getNome());
        emailMotociclistaPerfil.setText(m.getEmail());
        telefoneMotociclistaPerfil.setText(m.getTelefone());
        descricaoMotociclistaPerfil.setText(m.getDescricao());
        disponivelMotociclistaPerfil.setChecked(m.getDisponivel());
        System.out.println("teste: estou na view perfil motociclista: "+m.getDisponivel());
    }

    @Override
    public void chamarTelaEdicaoMotociclista(Motociclista m) {
        editarMotociclistaPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goToEditarPerfilMotociclista(m);
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
    }

    @Override
    public void motociclistaStatus(Motociclista m) {
        disponivelMotociclistaPerfil.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    presenter.estarDisponivel(m);
                }else{
                    presenter.estarIndisponivel(m);
                }
            }
        });
    }
}