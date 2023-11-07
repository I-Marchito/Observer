package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JogadorTest {

    @Test
    void deveNotificarPlayersServerOff(){
        Servidor servidor = new Servidor("Arcadia", "Online");
        Jogador jogador1 = new Jogador("Darkfeak");
        Jogador jogador2 = new Jogador("Pororoca");
        jogador1.logar(servidor);
        jogador2.logar(servidor);
        servidor.trocarStatus();
        assertEquals("Servidor Arcadia Status: Offline", jogador1.getUltimaNotificacao());
        assertEquals("Servidor Arcadia Status: Offline", jogador2.getUltimaNotificacao());
    }

     @Test
    void deveNotificarPlayersServerOn(){
        Servidor servidor = new Servidor("Arcadia", "Offline");
        Jogador jogador = new Jogador("Darkfeak");
        jogador.logar(servidor);
        servidor.trocarStatus();
        assertEquals("Servidor Arcadia Status: Online", jogador.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarPlayers(){
        Servidor servidor = new Servidor("Arcadia", "Online");
        Jogador jogador = new Jogador("Darkfeak");
        servidor.trocarStatus();
        assertEquals(null, jogador.getUltimaNotificacao());
    }

    @Test
    void deveNotificarPlayersArcadia(){
        Servidor servidor1 = new Servidor("Arcadia", "Online");
        Servidor servidor2 = new Servidor("Vivaldi", "Online");
        Jogador jogador1 = new Jogador("Darkfeak");
        Jogador jogador2 = new Jogador("Pororoca");
        jogador1.logar(servidor1);
        jogador2.logar(servidor2);
        servidor1.trocarStatus();
        assertEquals("Servidor Arcadia Status: Offline", jogador1.getUltimaNotificacao());
        assertEquals(null, jogador2.getUltimaNotificacao());
    }

}
