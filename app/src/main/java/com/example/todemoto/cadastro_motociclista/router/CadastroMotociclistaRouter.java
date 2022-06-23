package com.example.todemoto.cadastro_motociclista.router;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.provider.SyncStateContract;

import com.example.todemoto.PerfilMotociclistaActivity;
import com.example.todemoto.cadastro_motociclista.CadastroMotociclistaContracts;
import com.example.todemoto.cadastro_motociclista.entity.Motociclista;
import com.example.todemoto.cadastro_motociclista.view.CadastroMotociclista;
import com.google.android.gms.common.internal.Constants;

import java.io.Serializable;

public class CadastroMotociclistaRouter implements CadastroMotociclistaContracts.Router {
    private final Context context;
    private CadastroMotociclistaContracts.View view;


    public CadastroMotociclistaRouter(CadastroMotociclistaContracts.View view) {
        this.context = view.getContext();
        this.view = view;
    }

    @Override
    public void goToPerfilMotociclista(Motociclista motociclista) {
        System.out.println("teste: Entrei na router 1");
        Intent intent = new Intent(context, PerfilMotociclistaActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);


        System.out.println("teste: Entrei na router 2");

        intent.putExtra("motociclista", (Serializable) motociclista);
        System.out.println("teste: Entrei na router 3");

        context.startActivity(intent);
        System.out.println("teste: Entrei na router 4");

    }
}
