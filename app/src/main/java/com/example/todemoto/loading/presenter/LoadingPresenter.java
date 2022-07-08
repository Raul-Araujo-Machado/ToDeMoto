package com.example.todemoto.loading.presenter;

import com.example.todemoto.loading.LoadingContracts;
import com.example.todemoto.loading.interactor.LoadingInteractor;
import com.example.todemoto.loading.router.LoadingRouter;
import com.example.todemoto.loading.view.Loading;

public class LoadingPresenter implements LoadingContracts.Presenter {
    private final LoadingContracts.View view;
    private final LoadingContracts.Interactor interactor;
    private final LoadingContracts.Router router;

    public LoadingPresenter(LoadingContracts.View view) {
        this.view = view;
        this.interactor = new LoadingInteractor(this);
        this.router = new LoadingRouter(view);
    }

    @Override
    public void verificaSessao() {
        System.out.println("teste: vou enviar para interactor verificar a sessão");
        interactor.verificandoSessao();

    }

    @Override
    public void goToLogin() {
        router.goToLogin();
    }

    @Override
    public void onLoadingError(String message) {
        view.onLoadingError(message);
    }


    @Override
    public void goToPrincipalActivity() {
        router.goToPrincipalActivity();
    }

    @Override
    public void goToPerfilMotociclista() {
        router.goToPerfilMotociclista();
    }
}
