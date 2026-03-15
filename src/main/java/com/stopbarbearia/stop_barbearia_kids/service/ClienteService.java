package com.stopbarbearia.stop_barbearia_kids.service;


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
       final var cliente1 = clienteRepository.findByCpf(cliente.getCpf());
       if (cliente1 != null) {
           throw  new RuntimeException("Cliente ja existe");
       }
       return clienteRepository.save(cliente);
    }

    public Cliente getClienteByCpf(String cpf) {
        final var cliente = clienteRepository.findByCpf(cpf);
        if (cliente == null) {
            throw  new RuntimeException("Cliente nao encontrado");
        }
        return cliente;
    }

    public void deleteClienteByCpf(String cpf) {
        final var cliente = clienteRepository.findByCpf(cpf);
        if (cliente == null) {
            throw  new RuntimeException("Cliente nao encontrado");
        }
        clienteRepository.delete(cliente);
    }

}
