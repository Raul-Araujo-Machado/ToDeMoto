package com.example.todemoto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.todemoto.cadastro_cliente.entity.Cliente;
import com.example.todemoto.edicao_cliente.view.EdicaoClienteActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PerfilClienteActivity extends AppCompatActivity {

    private Button sairCliente;
    private TextView nomeClientePerfil;
    private TextView emailClientePerfil;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_cliente);

        nomeClientePerfil = findViewById(R.id.nomeClientePerfil);
        emailClientePerfil = findViewById(R.id.emailClientePerfil);

        carregarInformações();


        sairCliente = findViewById(R.id.sairPerfilCliente);
        sairCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent intent = new Intent(PerfilClienteActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
    private void carregarInformações(){
        String user = mAuth.getUid();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Usuarios/Cliente/" + user);
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Cliente c = (Cliente) snapshot.getValue(Cliente.class);
                System.out.println("teste"+c.getNome());
                nomeClientePerfil.setText(c.getNome());
                emailClientePerfil.setText(c.getEmail());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void chamarEditarCliente(View view){
        Intent intent = new Intent(this, EdicaoClienteActivity.class);
        startActivity(intent);
    }
}