package com.example.todemoto.perfil_motociclista.router;

import android.content.Intent;

import com.example.todemoto.cadastro_motociclista.entity.Motociclista;
import com.example.todemoto.edicao_cliente.view.EdicaoClienteActivity;
import com.example.todemoto.edicao_motociclista.view.EdicaoMotociclistaActivity;
import com.example.todemoto.login.view.LoginActivity;
import com.example.todemoto.perfil_motociclista.PerfilMotociclistaContracts;

import java.io.Serializable;

public class PerfilMotociclistaRouter implements PerfilMotociclistaContracts.Router {
    private final PerfilMotociclistaContracts.View view;

    public PerfilMotociclistaRouter(PerfilMotociclistaContracts.View view) {
        this.view = view;
    }

    @Override
    public void goToEditarPerfilMotociclista(Motociclista m) {
        Intent intent = new Intent(view.getContext(), EdicaoMotociclistaActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("motociclista", (Serializable) m);
        view.getContext().startActivity(intent);
        System.out.println("teste: consegui ir para a edicao motociclista");
    }

    @Override
    public void goToLogin() {
        Intent intent = new Intent(view.getContext(), LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        view.getContext().startActivity(intent);
        System.out.println("teste: consegui ir pro login pelo motociclista");
        view.finish();
    }
}
