package com.example.todemoto.cadastro_cliente;

import android.content.Context;

import com.example.todemoto.cadastro_cliente.entity.Cliente;

public interface CadastroClienteContracts {
    interface View {
        void onSavedError(String message);
        Context getContext();
        void finish();
    }

    interface Presenter {
        void salvarCliente(Cliente cliente);
        void onClienteSaved();
        void onClienteAuthSaved(Cliente cliente);
        void onSavedErrorAuth(String message);
        void onSavedErrorRT(String message);
    }

    interface Interactor {
        void salvaClienteAuth(Cliente cliente);
        void salvaClienteRT(Cliente cliente);
    }

    interface Router {
        void goToPrincipalActivity();
    }
}
