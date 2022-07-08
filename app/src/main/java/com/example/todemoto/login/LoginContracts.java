package com.example.todemoto.login;

import android.content.Context;

public interface LoginContracts {
    interface View {
        void onFazerLoginError(String message);
        Context getContext();
        void finish();
    }
    interface Presenter {
        void fazerLogin(String email, String senha);
        void goToLoading();
        void onErroFazerLogin(String message);
        void goToCadastro();

    }

    interface Interactor {
        void fazendoLogin(String email, String senha);

    }

    interface Router {
        void goToLoading();
        void goToCadastro();
    }
}
