package com.example.demo.repository;

import com.example.demo.dto.ItemDto;
import com.example.demo.dto.ItemFormDto;
import com.example.demo.entity.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>();
    private static final Map<Long, ItemFormDto> storeDto = new HashMap<>();
    private static long sequence = 0L;

    public Item save(Item item) {
        item.setItemId(++sequence);
        store.put(item.getItemId(), item);
        return item;
    }


    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public List<ItemFormDto> findAllDto() {
        return new ArrayList<>(storeDto.values());
    }

    public void update(Long id, Item updateParam) {
        Item findItem = findById(id);
        findItem.setItemName(updateParam.getItemName());
        findItem.setStarName(updateParam.getStarName());
        findItem.setPrice(updateParam.getPrice());
    }

    public void clearStore() {
        store.clear();
    }
}
