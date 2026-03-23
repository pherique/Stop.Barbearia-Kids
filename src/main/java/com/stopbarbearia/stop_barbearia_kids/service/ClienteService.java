package com.stopbarbearia.stop_barbearia_kids.service;


import com.stopbarbearia.stop_barbearia_kids.dto.ClienteRequestDTO;
import com.stopbarbearia.stop_barbearia_kids.dto.ClienteResponseDTO;
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
    public ClienteResponseDTO saveCliente(ClienteRequestDTO clienteDTO) {
        Cliente cliente = new Cliente();

        cliente.setNomeCompleto(clienteDTO.getNomeCompleto());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setCpf(clienteDTO.getCpf());

       final var clienteExistente = clienteRepository.findByCpf(cliente.getCpf());
       if (clienteExistente != null) {
           throw new ClienteJaExisteException("Cliente já existe com esse CPF");
       }

       Cliente clientesalvo = clienteRepository.save(cliente);
       return new ClienteResponseDTO(
               clientesalvo.getId(),
               cliente.getNomeCompleto(),
               cliente.getEmail(),
               cliente.getTelefone()
       );
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
