package redis.springboot.example.service.implementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import redis.springboot.example.entity.Item;
import redis.springboot.example.repo.ItemDao;
import redis.springboot.example.service.ItemService;
import java.util.List;

@Service
@CacheConfig(cacheNames = "itemCache")
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;

    @Cacheable(cacheNames = "items")
    @Override
    public List<Item> getAllItem() {
        waitSomeTime();
        return itemDao.findAll();
    }

    @Cacheable(cacheNames = "item", key = "#id", unless = "#result == null")
    @Override
    public Item getItemById(Integer id) {
        waitSomeTime();
        return  itemDao.findById(id).orElse(null);
    }

    @CacheEvict(cacheNames = "item", allEntries = true)
    @Override
    public Item add(Item item) {
        return itemDao.save(item);
    }

    @CacheEvict(cacheNames = "item", allEntries = true)
    @Override
    public Item update(Item item) {
        return null;
    }

    @Caching(evict = { @CacheEvict(cacheNames = "item", key = "#id"),
            @CacheEvict(cacheNames = "items", allEntries = true) })
    @Override
    public void delete(Integer id) {

    }

    private void waitSomeTime() {
        System.out.println("Long Wait Begin");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Long Wait End");
    }
}
