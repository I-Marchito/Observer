package com.example;

import java.util.Observable;
import java.util.Observer;

public class Jogador implements Observer {
    
    private String login;
    private String ultimaNotificacao;

    public Jogador (String login){
        this.login = login;
    }

    public String getUltimaNotificacao(){
        return this.ultimaNotificacao;
    }

    public void logar(Servidor servidor){
        servidor.addObserver(this);
    }

    public void update(Observable servidor, Object arg1){
        this.ultimaNotificacao = "Servidor " + servidor.toString();
    }
}