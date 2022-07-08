package com.example.todemoto.perfil_cliente.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.todemoto.R;
import com.example.todemoto.cadastro_cliente.entity.Cliente;
import com.example.todemoto.edicao_cliente.view.EdicaoClienteActivity;
import com.example.todemoto.login.view.LoginActivity;
import com.example.todemoto.perfil_cliente.PerfilClienteContracts;
import com.example.todemoto.perfil_cliente.presenter.PerfilClientePresenter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PerfilClienteActivity extends AppCompatActivity implements PerfilClienteContracts.View{

    private Button sairCliente;
    private TextView nomeClientePerfil;
    private TextView emailClientePerfil;
    private Button editarPerfilCliente;

    private PerfilClienteContracts.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_cliente);

        presenter = new PerfilClientePresenter(this);
        nomeClientePerfil = findViewById(R.id.nomeClientePerfil);
        emailClientePerfil = findViewById(R.id.emailClientePerfil);
        sairCliente = findViewById(R.id.sairPerfilCliente);
        editarPerfilCliente = findViewById(R.id.editarPerfilCliente);

        presenter.carregarInfoCliente();

        sairCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.logOutCliente();
            }
        });

    }

    @Override
    public void onCarregarInfoErro(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void carregarTelaCliente(Cliente c) {
        nomeClientePerfil.setText(c.getNome());
        emailClientePerfil.setText(c.getEmail());
    }

    @Override
    public void chamaEdicaoCliente(Cliente c) {
        editarPerfilCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("teste: Conseguu chamar evento para edicao");
                presenter.goToEditarPerfilCliente(c);
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
    }
}