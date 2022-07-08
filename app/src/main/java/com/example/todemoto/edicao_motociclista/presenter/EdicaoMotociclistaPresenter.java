package com.example.todemoto.edicao_motociclista.presenter;

import com.example.todemoto.cadastro_motociclista.entity.Motociclista;
import com.example.todemoto.edicao_cliente.interactor.EdicaoClienteInteractor;
import com.example.todemoto.edicao_cliente.router.EdicaoClienteRouter;
import com.example.todemoto.edicao_motociclista.EdicaoMotociclistaContracts;
import com.example.todemoto.edicao_motociclista.interactor.EdicaoMotociclistaInteractor;
import com.example.todemoto.edicao_motociclista.router.EdicaoMotociclistaRouter;
import com.example.todemoto.edicao_motociclista.view.EdicaoMotociclistaActivity;

public class EdicaoMotociclistaPresenter implements EdicaoMotociclistaContracts.Presenter {
    private final EdicaoMotociclistaContracts.View view;
    private final EdicaoMotociclistaContracts.Interactor interactor;
    private final EdicaoMotociclistaContracts.Router router;

    public EdicaoMotociclistaPresenter(EdicaoMotociclistaContracts.View view) {
        this.view = view;
        this.interactor = new EdicaoMotociclistaInteractor(this);
        this.router = new EdicaoMotociclistaRouter(view);
    }


    @Override
    public void atualizaDados(Motociclista m, String n, String t, String d) {
        interactor.atualizandodados(m, n, t, d);
    }

    @Override
    public void goToPerfilMotociclista() {
        router.goToPerfilMotociclista();
    }

    @Override
    public void onAtualizadados(String message) {
        view.onSavedSucess(message);
    }

    @Override
    public void onErrorAtualiza(String message) {
        view.onSavedError(message);
    }
}
