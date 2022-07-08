package com.example.todemoto.edicao_cliente.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.todemoto.edicao_cliente.EdicaoClienteContracts;
import com.example.todemoto.edicao_cliente.presenter.EdicaoClientePresenter;
import com.example.todemoto.perfil_cliente.view.PerfilClienteActivity;
import com.example.todemoto.R;
import com.example.todemoto.cadastro_cliente.entity.Cliente;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EdicaoClienteActivity extends AppCompatActivity implements EdicaoClienteContracts.View {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();;
    private EditText nomeClienteEdicao;
    private TextView emailClienteEdicao;
    private Button atualizaClienteEdicao;
    private Button cancelaClienteEdicao;
    private EdicaoClienteContracts.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicao_cliente);

        presenter = new EdicaoClientePresenter(this);
        nomeClienteEdicao = findViewById(R.id.nomeClienteEdicao);
        emailClienteEdicao = findViewById(R.id.emailClienteEdicao);
        atualizaClienteEdicao = findViewById(R.id.atualizaClienteEdicao);
        cancelaClienteEdicao = findViewById(R.id.cancelaClienteEdicao);

        Cliente c = (Cliente) getIntent().getSerializableExtra("cliente");
        System.out.println("teste: Peguei o objeto "+ c.getNome()+c.getEmail());

        nomeClienteEdicao.setText(c.getNome());
        emailClienteEdicao.setText(c.getEmail());

        cancelaClienteEdicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goToPerfilCliente();
            }
        });

        atualizaClienteEdicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = nomeClienteEdicao.getText().toString();
                presenter.atualizaDados(c, n);
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
        presenter.goToPerfilCliente();
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

}