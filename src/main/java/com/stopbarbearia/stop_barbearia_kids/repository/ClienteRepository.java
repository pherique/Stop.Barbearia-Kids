package com.stopbarbearia.stop_barbearia_kids.repository;


import com.stopbarbearia.stop_barbearia_kids.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByCpf(String cpf);

}
