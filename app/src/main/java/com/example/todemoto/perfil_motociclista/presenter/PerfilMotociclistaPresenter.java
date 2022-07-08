package com.example.todemoto.perfil_motociclista.presenter;

import com.example.todemoto.cadastro_motociclista.entity.Motociclista;
import com.example.todemoto.perfil_motociclista.PerfilMotociclistaContracts;
import com.example.todemoto.perfil_motociclista.entity.CardMotociclista;
import com.example.todemoto.perfil_motociclista.interactor.PerfilMotociclistaInteractor;
import com.example.todemoto.perfil_motociclista.router.PerfilMotociclistaRouter;

public class PerfilMotociclistaPresenter implements PerfilMotociclistaContracts.Presenter {
    private final PerfilMotociclistaContracts.View view;
    private final PerfilMotociclistaInteractor interactor;
    private final PerfilMotociclistaRouter router;

    public PerfilMotociclistaPresenter(PerfilMotociclistaContracts.View view) {
        this.view = view;
        this.interactor = new PerfilMotociclistaInteractor(this);
        this.router = new PerfilMotociclistaRouter(view);
    }

    @Override
    public void carregarInfoMotociclista() {
        interactor.carregandoInfoMotociclista();
    }

    @Override
    public void onCarregarInfoMotociclista(Motociclista m) {
        view.carregarTelaMotociclista(m);
    }

    @Override
    public void goToEditarPerfilMotociclista(Motociclista m) {
        router.goToEditarPerfilMotociclista(m);
    }

    @Override
    public void logOutMotociclista() {
        interactor.logOutingMotociclista();
    }

    @Override
    public void onLogOutMotociclista() {
        router.goToLogin();
    }

    @Override
    public void onErrorCarregarInfo(String message) {
        view.onCarregarInfoError(message);
    }

    @Override
    public void chamarEdicaoMotociclista(Motociclista m) {
        view.chamarTelaEdicaoMotociclista(m);
    }

    @Override
    public void motociclistaStatus(Motociclista m) {
        view.motociclistaStatus(m);
    }

    @Override
    public void estarIndisponivel(Motociclista m) {
        interactor.ficarIndisponivel(m);
    }

    @Override
    public void estarDisponivel(Motociclista m) {
        interactor.ficarDisponivel(m);
    }

    @Override
    public void onFicarDispovivel(CardMotociclista cm) {
        interactor.addCardMotociclista(cm);
    }

    @Override
    public void onFicarIndispovivel(String cm) {
        interactor.removeCardMotociclista(cm);
    }

    @Override
    public void messageSucess(String message) {
        view.onCarregarInfoError(message);
    }

}
