package com.example.todemoto.edicao_motociclista.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.todemoto.cadastro_cliente.entity.Cliente;
import com.example.todemoto.edicao_motociclista.EdicaoMotociclistaContracts;
import com.example.todemoto.edicao_motociclista.presenter.EdicaoMotociclistaPresenter;
import com.example.todemoto.perfil_motociclista.view.PerfilMotociclistaActivity;
import com.example.todemoto.R;
import com.example.todemoto.cadastro_motociclista.entity.Motociclista;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EdicaoMotociclistaActivity extends AppCompatActivity implements EdicaoMotociclistaContracts.View {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();;
    private EditText nomeMotociclistaEdicao;
    private EditText telefoneMotociclistaEdicao;
    private EditText descricaoMotociclistaEdicao;
    private Button atualizaMotociclistaEdicao;
    private Button cancelaMotociclistaEdicao;
    private EdicaoMotociclistaContracts.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicao_motociclista);

        presenter = new EdicaoMotociclistaPresenter(this);
        nomeMotociclistaEdicao = findViewById(R.id.nomeMotociclistaEdicao);
        telefoneMotociclistaEdicao = findViewById(R.id.telefoneMotociclistaEdicao);
        descricaoMotociclistaEdicao = findViewById(R.id.descricaoMotociclistaEdicao);
        atualizaMotociclistaEdicao = findViewById(R.id.atualizaMotociclistaEdicao);
        cancelaMotociclistaEdicao = findViewById(R.id.cancelaMotociclistaEdicao);


        Motociclista m = (Motociclista) getIntent().getSerializableExtra("motociclista");
        System.out.println("teste: Peguei o objeto "+ m.getNome()+m.getEmail());

        nomeMotociclistaEdicao.setText(m.getNome());
        telefoneMotociclistaEdicao.setText(m.getTelefone());
        descricaoMotociclistaEdicao.setText(m.getDescricao());

        atualizaMotociclistaEdicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = nomeMotociclistaEdicao.getText().toString();
                String t = telefoneMotociclistaEdicao.getText().toString();
                String d = descricaoMotociclistaEdicao.getText().toString();
                presenter.atualizaDados(m, n, t, d);
            }
        });

        cancelaMotociclistaEdicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goToPerfilMotociclista();
            }
        });


    }


    @Override
    public void onSavedError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSavedSucess(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        presenter.goToPerfilMotociclista();
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void finish() {
        super.finish();
    }
}