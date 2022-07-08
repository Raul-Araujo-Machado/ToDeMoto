package com.example.todemoto.loading;

import android.content.Context;

import com.example.todemoto.cadastro_motociclista.entity.Motociclista;

public interface LoadingContracts {
    interface View{
        Context getContext();
        void onLoadingError(String message);
        void finish();
    }
    interface Presenter{
       void verificaSessao();
       void goToLogin();
       void onLoadingError(String message);
       void goToPrincipalActivity();
       void goToPerfilMotociclista();
    }
    interface Interactor{
        void verificandoSessao();
    }
    interface Router{
        void goToPrincipalActivity();
        void goToPerfilMotociclista();
        void goToLogin();

    }
}
