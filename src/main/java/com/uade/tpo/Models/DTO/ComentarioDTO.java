package com.uade.tpo.models.dto;

public class ComentarioDTO {

    private String comentario;
    private UsuarioDTO autor;

    public ComentarioDTO(String comentario, UsuarioDTO autor){
        this.autor = autor;
        this.comentario = comentario;
    }

    public UsuarioDTO getAutor(){
        return this.autor;
    }

    public String getComentario(){
        return this.comentario;
    }

}