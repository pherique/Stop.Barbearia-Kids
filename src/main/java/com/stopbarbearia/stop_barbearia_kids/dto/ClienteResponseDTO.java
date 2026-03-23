package com.stopbarbearia.stop_barbearia_kids.dto;

public class ClienteResponseDTO {

     private Long id;
     private String nomeCompleto;
     private String email;
     private String telefone;

     public ClienteResponseDTO() {
    }

    public ClienteResponseDTO(Long id, String nomeCompleto, String email, String telefone) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.telefone = telefone;
    }

    public Long getId() {
         return id;
    }

    public String getNomeCompleto() {
         return nomeCompleto;
    }

    public String getEmail() {
         return email;
    }

    public String getTelefone() {
         return telefone;
    }
}
