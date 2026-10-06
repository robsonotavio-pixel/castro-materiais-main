package com.castromateriais.castro_materiais.service;

   
   import com.castromateriais.castro_materiais.model.Pagamento;
   import com.castromateriais.castro_materiais.Repository.PagamentoRepository;
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.stereotype.Service;

   import java.util.List;

   @Service
public class PagamentoService {
    
    @Autowired
    private PagamentoRepository pagamentoRepository;


    public List<Pagamento> listarTodos() {
        return pagamentoRepository.findAll();
    }
    public Pagamento buscarPorId(Long id) {
        return pagamentoRepository.findById(id) 
                          .orElseThrow(() -> new RuntimeException("Pagamento não encontrado com id " + id));
    }
    public Pagamento salvar(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }
    public Pagamento atualizar(Long id, Pagamento pagamentoAtualizado) { 
        Pagamento pagamento = buscarPorId(id);
        pagamento.setValor(pagamentoAtualizado.getValor());
        pagamento.setMetodo(pagamentoAtualizado.getMetodo());
        pagamento.setStatus(pagamentoAtualizado.getStatus());
        pagamento.setData(pagamentoAtualizado.getData());
        pagamento.setCliente(pagamentoAtualizado.getCliente());
        pagamento.setPedido(pagamentoAtualizado.getPedido());
        return pagamentoRepository.save(pagamento);
    }
    public void deletar(Long id){
        pagamentoRepository.deleteById(id);
    }
}
