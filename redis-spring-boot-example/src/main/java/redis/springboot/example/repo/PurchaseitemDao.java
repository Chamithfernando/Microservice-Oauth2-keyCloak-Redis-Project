package redis.springboot.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.stereotype.Repository;
import redis.springboot.example.entity.Purchaseitem;


public interface PurchaseitemDao extends JpaRepository<Purchaseitem, Integer>{
}