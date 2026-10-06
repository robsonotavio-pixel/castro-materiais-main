package com.castromateriais.castro_materiais.controller;
 import com.castromateriais.castro_materiais.model.Pagamento;
 import com.castromateriais.castro_materiais.service.PagamentoService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.*;

 import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


 @RestController
 @RequestMapping("/api/pagamentos")
public class PagamentoController {
    
    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping
    public List<Pagamento> listarTodos(){
        return pagamentoService.listarTodos();
    }

    @GetMapping("/{id}" ) 
    public Pagamento buscarPorId(@PathVariable Long id) {
        return pagamentoService.buscarPorId(id);
    }

    @PostMapping
    public Pagamento criar(@RequestBody Pagamento pagamento) {
        return pagamentoService.salvar(pagamento);
    }
    @PutMapping("/{id}")
    public Pagamento atualizar(@PathVariable Long id,@RequestBody Pagamento pagamento) {
        return pagamentoService.atualizar(id, pagamento);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id ){
        pagamentoService.deletar(id);
    }
   
}
