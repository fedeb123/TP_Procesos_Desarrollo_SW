package com.uade.tpo.models;

public class Comentario {
    
    private String comentario;
    private Usuario autor;

    public Comentario(String comentario, Usuario autor){
        this.autor = autor;
        this.comentario = comentario;
    }

    public Usuario getAutor(){
        return this.autor;
    }

    public String getComentario(){
        return this.comentario;
    }

}