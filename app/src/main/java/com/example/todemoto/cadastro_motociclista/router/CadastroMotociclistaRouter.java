package com.example.todemoto.cadastro_motociclista.router;

import android.content.Context;

import com.example.todemoto.cadastro_motociclista.CadastroMotociclistaContracts;
import com.example.todemoto.cadastro_motociclista.entity.Motociclista;

public class CadastroMotociclistaRouter implements CadastroMotociclistaContracts.Router {
    private final Context context;

    public CadastroMotociclistaRouter(Context context) {
        this.context = context;
    }

    @Override
    public void goToPerfilMotociclista(Motociclista motociclista) {
        
    }
}
