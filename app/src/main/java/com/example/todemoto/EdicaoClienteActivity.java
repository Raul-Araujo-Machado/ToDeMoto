package com.example.todemoto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.todemoto.Model.Cliente;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EdicaoClienteActivity extends AppCompatActivity {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();;
    private EditText nomeClienteEdicao;
    private EditText emailClienteEdicao;
    private Button atualizaClienteEdicao;
    private Button cancelaClienteEdicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicao_cliente);

        nomeClienteEdicao = findViewById(R.id.nomeClienteEdicao);
        emailClienteEdicao = findViewById(R.id.emailClienteEdicao);
        atualizaClienteEdicao = findViewById(R.id.atualizaClienteEdicao);
        cancelaClienteEdicao = findViewById(R.id.cancelaClienteEdicao);

        carregarInformações();
        botaoCancela();
        botaoAtualiza();
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
                nomeClienteEdicao.setText(c.getNome());
                emailClienteEdicao.setText(c.getEmail());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void botaoCancela(){
        cancelaClienteEdicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EdicaoClienteActivity.this, PerfilClienteActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void botaoAtualiza(){
        atualizaClienteEdicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable n = nomeClienteEdicao.getText();
                Editable e = emailClienteEdicao.getText();
                String user = mAuth.getUid();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Usuarios/Cliente/" + user);
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Cliente c = (Cliente) snapshot.getValue(Cliente.class);
                        System.out.println("teste"+c.getNome());
                        myRef.child("Usuarios").child(c.getId()).child("nome").setValue(n);
                        myRef.child("Usuarios").child(c.getId()).child("nome").setValue(e);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}