package redis.springboot.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.stereotype.Repository;
import redis.springboot.example.entity.Purchase;


public interface PurchaseDao extends JpaRepository<Purchase, Integer>{

    Purchase findByCode(String code);

}
