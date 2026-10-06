package com.castromateriais.castro_materiais.Repository;

import com.castromateriais.castro_materiais.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  ClienteRepository extends JpaRepository<Cliente,Long>{
}
