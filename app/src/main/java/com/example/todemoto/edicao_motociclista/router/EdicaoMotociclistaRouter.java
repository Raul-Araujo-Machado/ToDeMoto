package com.example.todemoto.edicao_motociclista.router;

import android.content.Intent;

import com.example.todemoto.edicao_motociclista.EdicaoMotociclistaContracts;
import com.example.todemoto.perfil_cliente.view.PerfilClienteActivity;
import com.example.todemoto.perfil_motociclista.view.PerfilMotociclistaActivity;

public class EdicaoMotociclistaRouter implements EdicaoMotociclistaContracts.Router {
    private final EdicaoMotociclistaContracts.View view;

    public EdicaoMotociclistaRouter(EdicaoMotociclistaContracts.View view) {
        this.view = view;
    }

    @Override
    public void goToPerfilMotociclista() {
        Intent intent = new Intent(view.getContext(), PerfilMotociclistaActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        view.getContext().startActivity(intent);
        System.out.println("teste: consegui ir para a perfil motociclista  pela edicao");
        view.finish();
    }
}
