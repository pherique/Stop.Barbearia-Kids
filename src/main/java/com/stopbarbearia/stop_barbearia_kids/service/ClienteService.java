package com.stopbarbearia.stop_barbearia_kids.service;


import com.stopbarbearia.stop_barbearia_kids.exception.ClienteJaExisteException;
import com.stopbarbearia.stop_barbearia_kids.exception.ClienteNaoEncontradoException;
import com.stopbarbearia.stop_barbearia_kids.entity.Cliente;
import com.stopbarbearia.stop_barbearia_kids.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public Cliente  saveCliente(Cliente cliente) {
       final var clienteExistente = clienteRepository.findByCpf(cliente.getCpf());
       if (clienteExistente != null) {
           throw new ClienteJaExisteException("Cliente já existe com esse CPF");
       }
       return clienteRepository.save(cliente);
    }

    public Cliente getClienteByCpf(String cpf) {
        final var cliente = clienteRepository.findByCpf(cpf);
        if (cliente == null) {
            throw  new ClienteNaoEncontradoException("Cliente não encontrado");
        }
        return cliente;
    }

    public void deleteClienteByCpf(String cpf) {
        final var cliente = clienteRepository.findByCpf(cpf);
        if (cliente == null) {
            throw  new ClienteNaoEncontradoException("Cliente nao encontrado");
        }
        clienteRepository.delete(cliente);
    }

}
