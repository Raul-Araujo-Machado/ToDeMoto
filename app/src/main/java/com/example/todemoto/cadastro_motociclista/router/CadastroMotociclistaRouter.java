package com.example.todemoto.cadastro_motociclista.router;

import android.content.Intent;

import com.example.todemoto.PrincipalActivity;
import com.example.todemoto.cadastro_motociclista.CadastroMotociclistaContracts;
import com.example.todemoto.cadastro_motociclista.entity.Motociclista;
import com.example.todemoto.login.view.LoginActivity;
import com.example.todemoto.perfil_motociclista.view.PerfilMotociclistaActivity;

public class CadastroMotociclistaRouter implements CadastroMotociclistaContracts.Router {
    private final CadastroMotociclistaContracts.View view;

    public CadastroMotociclistaRouter(CadastroMotociclistaContracts.View view) {
        this.view = view;
    }

    @Override
    public void goToPerfilMotociclista() {
        Intent intent = new Intent(view.getContext(), PerfilMotociclistaActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        view.getContext().startActivity(intent);
        System.out.println("teste: consegui ir para o perfil motociclista pelo cadastro");
        view.finish();
    }

    @Override
    public void goToLogin() {
        Intent intent = new Intent(view.getContext(), LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        view.getContext().startActivity(intent);
        System.out.println("teste: consegui ir para login pelo perfil do motociclista");
        view.finish();
    }
}
