package com.example.todemoto.cadastro_motociclista;

import android.content.Context;

import com.example.todemoto.cadastro_motociclista.entity.Motociclista;

public interface CadastroMotociclistaContracts {
    interface View {
        void onSavedError(String message);
        Context getContext();
    }

    interface Presenter {
        void salvarMotociclista(Motociclista motociclista);
        void onMotociclistaSaved(Motociclista motociclista);
        void onMotociclistaAuthSaved(Motociclista motociclista);
        void onSavedErrorAuth(String message);
        void onSavedErrorRT(String message);
    }

    interface Interactor {
        void salvaMotociclistaAuth(Motociclista motociclista);
        void salvaMotociclistaRT(Motociclista motociclista);
    }

    interface Router {
        void goToPerfilMotociclista(Motociclista motociclista);
    }
}
