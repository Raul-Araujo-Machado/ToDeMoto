package com.example.todemoto.perfil_motociclista;

import android.content.Context;

import com.example.todemoto.cadastro_motociclista.entity.Motociclista;
import com.example.todemoto.perfil_motociclista.entity.CardMotociclista;

public interface PerfilMotociclistaContracts {

    interface View {
        void onCarregarInfoError(String message);
        Context getContext();
        void carregarTelaMotociclista(Motociclista m);
        void chamarTelaEdicaoMotociclista(Motociclista m);
        void finish();
        void motociclistaStatus(Motociclista m);
    }
    interface Presenter {
        void carregarInfoMotociclista();
        void onCarregarInfoMotociclista(Motociclista m);
        void goToEditarPerfilMotociclista(Motociclista m);
        void logOutMotociclista();
        void onLogOutMotociclista();
        void onErrorCarregarInfo(String message);
        void chamarEdicaoMotociclista(Motociclista m);
        void motociclistaStatus(Motociclista m);
        void estarIndisponivel(Motociclista m);
        void estarDisponivel(Motociclista m);
        void onFicarDispovivel(CardMotociclista cm);
        void onFicarIndispovivel(String cm);
        void messageSucess(String message);

    }

    interface Interactor {
        void carregandoInfoMotociclista();
        void logOutingMotociclista();
        void ficarDisponivel(Motociclista m);
        void ficarIndisponivel(Motociclista m);
        void addCardMotociclista(CardMotociclista cm);
        void removeCardMotociclista(String cm);
    }

    interface Router {
        void goToEditarPerfilMotociclista(Motociclista m);
        void goToLogin();
    }


}
