package com.andre.estoque_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.estoque_api.model.Item;
import com.andre.estoque_api.repository.ItemRepository;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> listarTodos() {
        return itemRepository.findAll();
    }

    public Optional<Item> buscarPorId(Long id) {
        return itemRepository.findById(id);
    }

    public Item salvar(Item item) {
        return itemRepository.save(item);
    }

    public void deletar(Long id) {
        itemRepository.deleteById(id);
    }

    public List<Item> listarAlertaEstoque() {
        return itemRepository.findAll()
                .stream()
                .filter(item -> item.getQuantidade() < item.getQuantidadeMinima())
                .toList();
    }
}