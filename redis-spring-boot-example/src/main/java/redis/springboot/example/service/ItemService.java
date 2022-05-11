package redis.springboot.example.service;

import redis.springboot.example.entity.Item;

import java.util.List;

public interface ItemService {

    public List<Item> getAllItem();
    public Item getItemById(Integer id);
    public Item add(Item item);
    public Item update(Item item);
    public void delete(Integer id);
}
