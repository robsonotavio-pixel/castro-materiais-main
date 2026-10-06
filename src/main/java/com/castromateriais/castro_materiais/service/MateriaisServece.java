package com.castromateriais.castro_materiais.service;

import com.castromateriais.castro_materiais.model.Material;
import com.castromateriais.castro_materiais.Repository.MateriaisRepositry;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.RuntimeBeanNameReference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaisServece {
    @Autowired 
    private MateriaisRepositry materiaisRepositry;
    
    public List<Material> listarTodos() {
       return materiaisRepositry.findAll();
    }

    public Material buscarPorId(Long id) {
        return materiaisRepositry.findById(id)
                   .orElseThrow(() -> new RuntimeException("material não encontrado com id" + id ));
    }
    public Material salvar(Material material) {
        return materiaisRepositry.save(material);
    }
    public Material atualizar(Long id, Material materiaAtaulizado) {
        Material material = buscarPorId(id);
        material.setNome(materiaAtaulizado.getNome());
        material.setUnidade(materiaAtaulizado.getUnidade());
        material.setPreco(materiaAtaulizado.getPreco());
        material.setEstoque(materiaAtaulizado.getEstoque());
        return materiaisRepositry.save(material);
        
    }
    public void deletar(Long id) {
        materiaisRepositry.deleteById(id);
    }
}
