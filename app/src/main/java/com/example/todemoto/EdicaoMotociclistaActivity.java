package com.example.todemoto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.todemoto.Model.Cliente;
import com.example.todemoto.Model.Motociclista;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EdicaoMotociclistaActivity extends AppCompatActivity {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();;
    private EditText nomeMotociclistaEdicao;
    private EditText telefoneMotociclistaEdicao;
    private EditText descricaoMotociclistaEdicao;
    private Button atualizaMotociclistaEdicao;
    private Button cancelaMotociclistaEdicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicao_motociclista);

        nomeMotociclistaEdicao = findViewById(R.id.nomeMotociclistaEdicao);
        telefoneMotociclistaEdicao = findViewById(R.id.telefoneMotociclistaEdicao);
        descricaoMotociclistaEdicao = findViewById(R.id.descricaoMotociclistaEdicao);
        atualizaMotociclistaEdicao = findViewById(R.id.atualizaMotociclistaEdicao);
        cancelaMotociclistaEdicao = findViewById(R.id.cancelaMotociclistaEdicao);

        carregarInformações();
        botaoAtualiza();
        botaoCancela();

    }

    private void carregarInformações(){
        String user = mAuth.getUid();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Usuarios/Motociclista/" + user);
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Motociclista m = (Motociclista) snapshot.getValue(Motociclista.class);
                System.out.println("teste"+m.getNome());
                nomeMotociclistaEdicao.setText(m.getNome());
                telefoneMotociclistaEdicao.setText(m.getTelefone());
                descricaoMotociclistaEdicao.setText(m.getDescricao());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void botaoCancela(){
        cancelaMotociclistaEdicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EdicaoMotociclistaActivity.this, PerfilMotociclistaActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void botaoAtualiza(){
        atualizaMotociclistaEdicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = nomeMotociclistaEdicao.getText().toString();
                String t = telefoneMotociclistaEdicao.getText().toString();
                String d = descricaoMotociclistaEdicao.getText().toString();
                String user = mAuth.getUid();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Usuarios").child("Motociclista").child(user);
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Motociclista m = (Motociclista) snapshot.getValue(Motociclista.class);
                        System.out.println("teste"+m.getNome());
                        myRef.child("nome").setValue(n);
                        myRef.child("telefone").setValue(t);
                        myRef.child("descricao").setValue(d);
                        Toast.makeText(EdicaoMotociclistaActivity.this, "Dados atualizados!", Toast.LENGTH_SHORT).show();
                        chamarPerfil();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
    public void chamarPerfil(){
        Intent intent = new Intent(this, PerfilMotociclistaActivity.class);
        startActivity(intent);
        finish();
    }
}