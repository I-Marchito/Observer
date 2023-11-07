package com.example;

import java.util.Observable;

public class Servidor extends Observable {

    private String nome;
    private String status;

    public Servidor(String nome, String status){
        this.nome = nome;
        this.status = status;
    }

    public void trocarStatus(){
        if(this.status == "Online"){
            this.status = "Offline";
        }else{
            this.status = "Online";
        }
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString(){
        return nome + " Status: " + status;
    }
}
