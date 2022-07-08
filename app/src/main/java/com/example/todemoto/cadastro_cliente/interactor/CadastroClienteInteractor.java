package com.example.todemoto.cadastro_cliente.interactor;

import androidx.annotation.NonNull;

import com.example.todemoto.cadastro_cliente.CadastroClienteContracts;
import com.example.todemoto.cadastro_cliente.entity.Cliente;
import com.example.todemoto.cadastro_cliente.presenter.CadastroClientePresenter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class CadastroClienteInteractor implements CadastroClienteContracts.Interactor {
    private CadastroClienteContracts.Presenter presenter;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseStorage storage = FirebaseStorage.getInstance();
    private StorageReference storageRef = storage.getReference();
    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();


    public CadastroClienteInteractor(CadastroClienteContracts.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void salvaClienteAuth(Cliente cliente) {
        System.out.println("teste: " +cliente.getEmail() +cliente.getSenha());
        Task<AuthResult> resposta = mAuth.createUserWithEmailAndPassword(cliente.getEmail(), cliente.getSenha());
        resposta.addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                cliente.setId(mAuth.getUid());
                presenter.onClienteAuthSaved(cliente);
                System.out.println("teste: consegui salvar no Auth");
            }
        });
        resposta.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                presenter.onSavedErrorAuth("Erro ao salves no FireAuth: "+e.getLocalizedMessage());
                e.printStackTrace();
            }
        });


    }
    @Override
    public void salvaClienteRT(Cliente cliente) {
        Task<Void> resposta = referencia.child("Usuarios").child("Cliente").child(cliente.getId()).setValue(cliente);
        resposta.addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                presenter.onClienteSaved();
                System.out.println("teste: consegui salvar no Auth");
            }
        });
        resposta.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                presenter.onSavedErrorRT("Erro ao salvar no FireRealTime: "+e.getLocalizedMessage());
                e.printStackTrace();
            }
        });
    }
}
