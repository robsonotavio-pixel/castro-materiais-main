package com.castromateriais.castro_materiais.Repository;
import com.castromateriais.castro_materiais.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento,Long>{
    
}
