package com.example.todemoto.login.presenter;

import com.example.todemoto.login.LoginContracts;
import com.example.todemoto.login.interactor.LoginInteractor;
import com.example.todemoto.login.router.LoginRouter;
import com.example.todemoto.login.view.LoginActivity;

public class LoginPresenter implements LoginContracts.Presenter {
    private final LoginContracts.View view;
    private final LoginContracts.Interactor interactor;
    private final LoginContracts.Router router;

    public LoginPresenter(LoginContracts.View view) {
        this.view = view;
        this.interactor = new LoginInteractor(this);
        this.router = new LoginRouter(view);
    }

    @Override
    public void fazerLogin(String email, String senha) {
        interactor.fazendoLogin(email, senha);
    }

    @Override
    public void goToLoading() {
        router.goToLoading();
    }

    @Override
    public void onErroFazerLogin(String message) {
        view.onFazerLoginError(message);
    }

    @Override
    public void goToCadastro() {
        router.goToCadastro();
    }
}
