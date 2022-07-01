package com.example.todemoto.cadastro_motociclista.router;

import com.example.todemoto.cadastro_motociclista.CadastroMotociclistaContracts;
import com.example.todemoto.cadastro_motociclista.entity.Motociclista;

public class CadastroMotociclistaRouter implements CadastroMotociclistaContracts.Router {
    private final CadastroMotociclistaContracts.View view;

    public CadastroMotociclistaRouter(CadastroMotociclistaContracts.View view) {
        this.view = view;
    }

    @Override
    public void goToPerfilMotociclista(Motociclista motociclista) {

    }
}
