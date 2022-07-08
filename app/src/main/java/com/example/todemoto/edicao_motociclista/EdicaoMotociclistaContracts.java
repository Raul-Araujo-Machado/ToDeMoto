package com.example.todemoto.edicao_motociclista;

import android.content.Context;

import com.example.todemoto.cadastro_cliente.entity.Cliente;
import com.example.todemoto.cadastro_motociclista.entity.Motociclista;

public interface EdicaoMotociclistaContracts {
    interface View {
        void onSavedError(String message);
        void onSavedSucess(String message);
        Context getContext();
        void finish();


    }

    interface Presenter {
        void atualizaDados(Motociclista m, String n, String t, String d);
        void goToPerfilMotociclista();
        void onAtualizadados(String message);
        void onErrorAtualiza(String message);
    }

    interface Interactor {

        void atualizandodados(Motociclista m, String n, String t, String d);
    }

    interface Router {
        void goToPerfilMotociclista();
    }

}
