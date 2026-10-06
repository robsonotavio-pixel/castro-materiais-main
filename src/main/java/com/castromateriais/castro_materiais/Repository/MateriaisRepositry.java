package com.castromateriais.castro_materiais.Repository;
import com.castromateriais.castro_materiais.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateriaisRepositry extends JpaRepository <Material,Long>{
    
}
