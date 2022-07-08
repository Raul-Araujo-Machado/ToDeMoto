package com.example.todemoto.cadastro_motociclista;

import android.content.Context;

import com.example.todemoto.cadastro_motociclista.entity.Motociclista;

public interface CadastroMotociclistaContracts {
    interface View {
        void onSavedErrorAuth(String message);
        void onSavedErrorRT(String message);
        Context getContext();
        void finish();
    }

    interface Presenter {
        void salvarMotociclista(Motociclista motociclista);
        void onMotociclistaSaved();
        void onMotociclistaAuthSaved(Motociclista motociclista);
        void onSavedErrorAuth(String message);
        void onSavedErrorRT(String message);
        void goToLogin();
    }

    interface Interactor {
        void salvaMotociclistaAuth(Motociclista motociclista);
        void salvaMotociclistaRT(Motociclista motociclista);
    }

    interface Router {
        void goToPerfilMotociclista();
        void goToLogin();
    }
}
