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

public class CadastroMotociclistaRouter implements CadastroMotociclistaContracts.Router {
    private final Context context;
    private CadastroMotociclistaContracts.View view;

    public CadastroMotociclistaRouter(Context context) {
        this.context = context;
    }

    @Override
    public void goToPerfilMotociclista(Motociclista motociclista) {
        Intent intent = new Intent((Context) view, PerfilMotociclistaActivity.class);
        intent.putExtra("motociclista", (Parcelable) motociclista);
        context.startActivity(intent);
    }
}
