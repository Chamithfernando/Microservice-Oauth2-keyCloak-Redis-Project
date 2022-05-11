package redis.springboot.example.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StartupCacheListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private CacheManager cacheManager;

    private static final Logger LOGGER = LoggerFactory.getLogger(StartupCacheListener.class);


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        LOGGER.info("Application cache listener executing");
        cacheManager.getCacheNames().parallelStream().forEach(n -> {
           LOGGER.info("the cache name is"+n);
        });
    }
}
