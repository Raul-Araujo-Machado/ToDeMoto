package com.example.todemoto.perfil_motociclista.interactor;

import androidx.annotation.NonNull;

import com.example.todemoto.cadastro_motociclista.entity.Motociclista;
import com.example.todemoto.perfil_motociclista.PerfilMotociclistaContracts;
import com.example.todemoto.perfil_motociclista.entity.CardMotociclista;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PerfilMotociclistaInteractor implements PerfilMotociclistaContracts.Interactor {
    private final PerfilMotociclistaContracts.Presenter presenter;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseDatabase database = FirebaseDatabase.getInstance();

    public PerfilMotociclistaInteractor(PerfilMotociclistaContracts.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void carregandoInfoMotociclista() {
        DatabaseReference myRef = database.getReference("Usuarios/Motociclista/" + mAuth.getUid());
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Motociclista m = (Motociclista) snapshot.getValue(Motociclista.class);
                presenter.onCarregarInfoMotociclista(m);
                presenter.chamarEdicaoMotociclista(m);
                presenter.motociclistaStatus(m);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                presenter.onErrorCarregarInfo("Erro ao carregar informações: "+error.getMessage());
            }
        });
    }

    @Override
    public void logOutingMotociclista() {
        mAuth.signOut();
        presenter.onLogOutMotociclista();
    }

    @Override
    public void ficarDisponivel(Motociclista m) {
        DatabaseReference myRef = database.getReference("Usuarios").child("Motociclista").child(m.getId());
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                myRef.child("disponivel").setValue(true);
                CardMotociclista cm = new CardMotociclista("imagem", m.getNome(), m.getId(), "Avaliação: 5", "10km");
                presenter.onFicarDispovivel(cm);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                presenter.onErrorCarregarInfo("Não é possível coloca-lo disponível no momento! ");
            }
        });
        System.out.println("teste: motociclista disponivel: "+m.getDisponivel());
    }

    @Override
    public void ficarIndisponivel(Motociclista m) {
        DatabaseReference myRef = database.getReference("Usuarios").child("Motociclista").child(m.getId());
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                myRef.child("disponivel").setValue(false);
                presenter.onFicarIndispovivel(m.getId());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                presenter.onErrorCarregarInfo("Não é possível coloca-lo disponível no momento! ");
            }
        });

    }

    @Override
    public void addCardMotociclista(CardMotociclista cm) {
        Task<Void> myRef = database.getReference().child("cardMoto").child(cm.getId()).setValue(cm);
        myRef.addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                presenter.messageSucess("Você está disponível!");
            }
        });
        myRef.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                presenter.onErrorCarregarInfo("Não foi possivel estar disponivel no momento!"+e.getLocalizedMessage());
                e.printStackTrace();
            }
        });
    }

    @Override
    public void removeCardMotociclista(String id) {
        Task<Void> myRef = database.getReference().child("cardMoto").child(id).removeValue();
        myRef.addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                presenter.messageSucess("Você está indisponível!");
            }
        });
        myRef.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                presenter.onErrorCarregarInfo("Algo de errado não está certo! "+e.getLocalizedMessage());
                e.printStackTrace();
            }
        });
    }

}
