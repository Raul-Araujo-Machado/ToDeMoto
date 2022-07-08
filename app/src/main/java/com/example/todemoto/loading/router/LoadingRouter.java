package com.example.todemoto.loading.router;

import android.content.Intent;

import com.example.todemoto.PrincipalActivity;
import com.example.todemoto.loading.LoadingContracts;
import com.example.todemoto.login.view.LoginActivity;
import com.example.todemoto.perfil_motociclista.view.PerfilMotociclistaActivity;

public class LoadingRouter implements LoadingContracts.Router {
    private final LoadingContracts.View view;

    public LoadingRouter(LoadingContracts.View view) {
        this.view = view;
    }

    @Override
    public void goToPrincipalActivity() {
        Intent intent = new Intent(view.getContext(), PrincipalActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        view.getContext().startActivity(intent);
        System.out.println("teste: vou para principal activity pelo loading");
        view.finish();
    }

    @Override
    public void goToPerfilMotociclista() {
        Intent intent = new Intent(view.getContext(), PerfilMotociclistaActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        view.getContext().startActivity(intent);
        System.out.println("teste: vou para o perfil mtociclista pela loading ");
        view.finish();
    }

    @Override
    public void goToLogin() {
        Intent intent = new Intent(view.getContext(), LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        view.getContext().startActivity(intent);
        System.out.println("teste: consegui ir para o loging pelo loading");
        view.finish();
    }
}
