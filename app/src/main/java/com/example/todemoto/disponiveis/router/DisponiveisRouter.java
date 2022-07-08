package com.example.todemoto.disponiveis.router;

import android.content.Intent;

import com.example.todemoto.disponiveis.DisponiveisContracts;
import com.example.todemoto.login.view.LoginActivity;
import com.example.todemoto.perfil_cliente.view.PerfilClienteActivity;
import com.example.todemoto.ui.Favoritos.FavoritosFragment;

public class DisponiveisRouter implements DisponiveisContracts.Router{
    private final DisponiveisContracts.View view;

    public DisponiveisRouter(DisponiveisContracts.View view) {
        this.view = view;
    }

    @Override
    public void goToFavoritos() {
        Intent intent = new Intent(view.getAplicationContext(), PerfilClienteActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        view.getAplicationContext().startActivity(intent);

    }
}
