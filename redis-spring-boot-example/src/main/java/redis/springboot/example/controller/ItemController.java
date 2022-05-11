package redis.springboot.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import redis.springboot.example.entity.Item;
import redis.springboot.example.service.ItemService;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RolesAllowed({"item_read"})
    @GetMapping
    public ResponseEntity<Object> getAllItems(Principal principal) {
        List<Item> items = this.itemService.getAllItem();
        System.out.println(principal.getName());
        return ResponseEntity.status(HttpStatus.OK).body(items);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getItemById(@PathVariable("id") Integer id) {
        Item item = this.itemService.getItemById(id);
        return ResponseEntity.ok(item);
    }

    @PostMapping
    public ResponseEntity<Object> addItem(@RequestBody Item item) {
        Item createdItem = this.itemService.add(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteItemById(@PathVariable("id") Integer id) {
        this.itemService.delete(id);
        return ResponseEntity.ok().build();
    }
}
