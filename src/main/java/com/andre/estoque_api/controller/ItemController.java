package com.andre.estoque_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andre.estoque_api.model.Item;
import com.andre.estoque_api.service.ItemService;

@RestController
@RequestMapping("/itens")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> listarTodos() {
        return itemService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> buscarPorId(@PathVariable Long id) {
        return itemService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Item criar(@RequestBody Item item) {
        return itemService.salvar(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> atualizar(@PathVariable Long id, @RequestBody Item itemAtualizado) {
        return itemService.buscarPorId(id)
                .map(item -> {
                    item.setNome(itemAtualizado.getNome());
                    item.setQuantidade(itemAtualizado.getQuantidade());
                    item.setCategoria(itemAtualizado.getCategoria());
                    item.setQuantidadeMinima(itemAtualizado.getQuantidadeMinima());
                    return ResponseEntity.ok(itemService.salvar(item));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        itemService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/alerta-estoque")
    public List<Item> listarAlertaEstoque() {
        return itemService.listarAlertaEstoque();
    }
}