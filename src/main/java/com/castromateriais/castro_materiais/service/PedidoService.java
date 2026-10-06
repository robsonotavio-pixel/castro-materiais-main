package com.castromateriais.castro_materiais.service;
 
import com.castromateriais.castro_materiais.model.Pedido;
import com.castromateriais.castro_materiais.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido buscarPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("pedido não encontrado com id " + id));
    }  
    public Pedido salvar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido atualizar(Long id,Pedido pedidoAtualizado) {
        Pedido pedido = buscarPorId(id);
        pedido.setData(pedidoAtualizado.getData());
        pedido.setValorTotal(pedidoAtualizado.getValorTotal());
        pedido.setStatus(pedidoAtualizado.getStatus());
        pedido.setCliente(pedidoAtualizado.getCliente());
        return pedidoRepository.save(pedido);
    }
    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }
}
