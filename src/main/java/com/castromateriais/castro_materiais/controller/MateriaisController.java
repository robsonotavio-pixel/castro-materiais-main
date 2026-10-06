package com.castromateriais.castro_materiais.controller;

import com.castromateriais.castro_materiais.model.Material;
import com.castromateriais.castro_materiais.service.MateriaisServece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materiais")
public class MateriaisController {
   
    @Autowired
    private MateriaisServece materiaisServece;

    @GetMapping
    public List<Material> listarTodos() {
        return  materiaisServece.listarTodos();
    }
    @GetMapping("/{id}")
    public Material buscarPorId(@PathVariable Long id) {
        return materiaisServece.buscarPorId(id);
    }

    @PostMapping
    public Material criar(@RequestBody Material material ) {
        return materiaisServece.salvar(material);
    }
    @PutMapping("/{id}")
    public Material atualizar(@PathVariable Long id, @RequestBody Material material) {
        return materiaisServece.atualizar(id, material);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        materiaisServece.deletar(id);
    }
}
