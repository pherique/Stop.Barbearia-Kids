package com.stopbarbearia.stop_barbearia_kids.dto;

public class ClienteRequestDTO {

    private String nomeCompleto;
    private String email;
    private String telefone;
    private String cpf;


    public ClienteRequestDTO() {
    }

    public ClienteRequestDTO(String nomeCompleto, String email, String telefone, String cpf) {
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
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

    public String getCpf() {
        return cpf;
    }
}
