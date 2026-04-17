package ejercicios.Plataforma_Streaming.src.controller;

import ejercicios.Plataforma_Streaming.src.model.Artista;
import ejercicios.Plataforma_Streaming.src.model.Cancion;

import ejercicios.Plataforma_Streaming.src.model.UsuarioGratuito;
import ejercicios.Plataforma_Streaming.src.model.UsuarioPremium;
import ejercicios.Plataforma_Streaming.src.model.Playlist;
import ejercicios.Plataforma_Streaming.src.model.Podcast;

public class Main {
    public static void main(String[] args) {

        Plataforma campus = new Plataforma("Campus");

        // --- ARTISTAS ---
        Artista a1 = new Artista("JP", "Mexico");
        Artista a2 = new Artista("Nacho", "España");

        campus.añadirArtista(a1);
        campus.añadirArtista(a2);

        // --- CANCIONES ---
        Cancion c1 = new Cancion("Me Rehuso", 3.5, "14/11/2004", "Pop", 100);
        Cancion c2 = new Cancion("La Bicicleta", 4.0, "01/06/2016", "Vallenato", 200);
        Cancion c3 = new Cancion("Despacito", 3.8, "12/01/2017", "Reggaeton", 999);

        a1.addCancion(c1);
        a1.addCancion(c2);
        a2.addCancion(c3);

        // --- PODCAST ---
        // ⚠️ FALTA: el constructor de Podcast no recibe nombrePodcast ni numeroEpisodio
        Podcast p1 = new Podcast("El Podcast de la IA", 45.0, "01/01/2024");

        // --- USUARIOS ---
        UsuarioPremium u1 = new UsuarioPremium("Carlos", "carlos@mail.com", "2023-01-01", "Mensual");
        UsuarioGratuito u2 = new UsuarioGratuito("Laura", "laura@mail.com", "2023-06-15", 10);

        campus.añadirUsuario(u1);
        campus.añadirUsuario(u2);

        // --- PLAYLIST ---
        Playlist pl1 = new Playlist("Mis favoritas");
        pl1.agregarContenido(c1);
        pl1.agregarContenido(c2);
        pl1.agregarContenido(p1);

        // ==================== PRUEBAS ====================

        System.out.println("=== Artistas en la plataforma ===");
        System.out.println(campus.getArtistas());

        System.out.println("\n=== Canciones de a1 (JP) ===");
        // ⚠️ FALTA: artista dentro de Cancion saldrá null — Cancion no tiene setArtista()
        a1.mostrarCanciones();

        System.out.println("\n=== Info usuarios ===");
        campus.mostrarInfoUsuario(u1);
        System.out.println("---");
        campus.mostrarInfoUsuario(u2);

        System.out.println("\n=== Contenido playlist ===");
        campus.mostrarContenidoPlaylist(pl1);

        System.out.println("\n=== Identificar tipo de contenido ===");
        campus.identificarTipoContenido(c1);
        campus.identificarTipoContenido(p1);
    }
}
