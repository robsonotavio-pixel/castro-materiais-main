package com.castromateriais.castro_materiais.Repository;
import com.castromateriais.castro_materiais.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository  extends JpaRepository <Pedido,Long>{
    
}
