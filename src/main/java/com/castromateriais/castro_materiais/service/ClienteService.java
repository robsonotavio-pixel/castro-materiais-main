package com.castromateriais.castro_materiais.service;

import com.castromateriais.castro_materiais.model.Cliente;
import com.castromateriais.castro_materiais.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                          .orElseThrow(() -> new RuntimeException("cliente não encontrado com id" + id));
    }
    public Cliente salvar(Cliente cliente) {
         return clienteRepository.save(cliente);
    }
    public Cliente atualizar(Long id,Cliente clienteAtualizado) {
        Cliente cliente = buscarPorId(id);
        cliente.setNome(clienteAtualizado.getNome());
        cliente.setTelefone(clienteAtualizado.getTelefone());
        cliente.setCpf(clienteAtualizado.getCpf());
        cliente.setEmail(clienteAtualizado.getEmail());
        cliente.setEndereco(clienteAtualizado.getEndereco());
        cliente.setCidade(clienteAtualizado.getCidade());
        cliente.setEstado(clienteAtualizado.getEstado());
        return clienteRepository.save(cliente);
    }
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}
