package com.castromateriais.castro_materiais.controller;

import com.castromateriais.castro_materiais.model.ItemPedido;
import com.castromateriais.castro_materiais.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;




@RestController
@RequestMapping("/api/itens-pedido")
public class ItemPedidoController {
    
    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping
    public List<ItemPedido> listaTodos(){
        return itemPedidoService.listarTodos();
    }
    @GetMapping("/{id}")
    public ItemPedido buscarPorId(@PathVariable Long id) {
        return itemPedidoService.buscarPorId(id);

    }
    @PostMapping
    public ItemPedido Criar(@RequestBody ItemPedido itemPedido ){
        return itemPedidoService.salvar(itemPedido);
    }

    @PutMapping("/{id}") 
    public ItemPedido atualizar(@PathVariable Long id, @RequestBody ItemPedido itemPedido ) {
        return itemPedidoService.atualizar(id, itemPedido);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id ) {
        itemPedidoService.deletar(id);
    }
    
    
}
