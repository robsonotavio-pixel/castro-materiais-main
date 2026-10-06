package com.castromateriais.castro_materiais.controller;

import com.castromateriais.castro_materiais.model.Pedido;
import com.castromateriais.castro_materiais.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    
   
    @Autowired
    private PedidoService pedidoService;

   

    @GetMapping
    public List<Pedido> listarTodos() {
        return pedidoService.listarTodos();
    }
    @GetMapping("/{id}") 
    public Pedido buscarPorId(@PathVariable Long id ) {
        return pedidoService.buscarPorId(id);
    }

    @PostMapping
    public Pedido crair(@RequestBody Pedido pedido ){
        return pedidoService.salvar(pedido);
    }
    
    @PutMapping("/{id}")
    public Pedido atualizar(@PathVariable Long id, @RequestBody Pedido pedido) {
        return pedidoService.atualizar(id, pedido);
    }
   @DeleteMapping("/{id}")
     public void deletar(@PathVariable Long id) {
        pedidoService.deletar(id);
     }
   
}
