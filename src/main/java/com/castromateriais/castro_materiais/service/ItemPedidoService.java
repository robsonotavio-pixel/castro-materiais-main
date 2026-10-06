package com.castromateriais.castro_materiais.service;

import com.castromateriais.castro_materiais.model.ItemPedido;
import com.castromateriais.castro_materiais.Repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {
    
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public List<ItemPedido> listarTodos() {
        return itemPedidoRepository.findAll();
    }
    public ItemPedido buscarPorId(Long id) {
        return itemPedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("item de pedido não encontrado com id" + id));

    }

    public ItemPedido salvar(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }
    public ItemPedido atualizar(Long id,ItemPedido itemAtualizado) {
        ItemPedido itemPedido = buscarPorId(id);
        itemPedido.setQuantidade(itemAtualizado.getQuantidade());
        itemPedido.setPedido(itemAtualizado.getPedido());
        itemPedido.setMaterial(itemAtualizado.getMaterial());
        return itemPedidoRepository.save(itemPedido);
    }
    public void deletar(Long id) {
        itemPedidoRepository.deleteById(id);
    }
}
