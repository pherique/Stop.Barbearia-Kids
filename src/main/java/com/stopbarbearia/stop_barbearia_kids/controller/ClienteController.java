package com.stopbarbearia.stop_barbearia_kids.controller;

import com.stopbarbearia.stop_barbearia_kids.dto.ClienteRequestDTO;
import com.stopbarbearia.stop_barbearia_kids.entity.Cliente;
import com.stopbarbearia.stop_barbearia_kids.repository.ClienteRepository;
import com.stopbarbearia.stop_barbearia_kids.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {


    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public Cliente saveCliente(@RequestBody ClienteRequestDTO clienteDTO) {
        return clienteService.saveCliente(clienteDTO);
    }

    @GetMapping("/cpf/{cpf}")
    public Cliente getByCpf(@PathVariable String cpf) {
        return clienteService.getClienteByCpf(cpf);
    }

    @DeleteMapping("/cpf/{cpf}")
    public void deleteByCpf(@PathVariable String cpf) {
        clienteService.deleteClienteByCpf(cpf);
    }
}
