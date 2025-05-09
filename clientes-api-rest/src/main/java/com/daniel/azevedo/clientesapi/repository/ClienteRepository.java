package com.daniel.azevedo.clientesapi.repository;

import com.daniel.azevedo.clientesapi.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ClienteRepository {

    private final Map<Long, Cliente> banco = new HashMap<>();
    private long sequencia = 1;

    public Cliente salvar(Cliente cliente) {
        cliente.setId(sequencia++);
        banco.put(cliente.getId(), cliente);
        return cliente;
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return Optional.ofNullable(banco.get(id));
    }

    public List<Cliente> listarTodos() {
        return new ArrayList<>(banco.values());
    }
}
