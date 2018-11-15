package com.dumbdodo.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * Get data from redis
     *
     * @param key     The key of the hash cache
     * @param hashKey The key to get the particular object of the type hash cache
     * @return
     */
    public Object getFromRedis(String key, Object hashKey) {
        HashOperations hashOperations = redisTemplate.opsForHash();
        return hashOperations.get(key, hashKey);
    }

    /**
     * Add data to Redis
     *
     * @param key     The key of the hash cache
     * @param hashKey The key to get the particular object of the type hash cache
     * @param data    The payload object to be persisted
     */
    public void putDataToRedis(String key, Object hashKey, Object data) {
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put(key, hashKey, data);
    }

    /**
     * Delete value for a hashKey
     *
     * @param key     The key of the hash cache
     * @param hashKey The key to get the particular object of the type hash cache
     */
    public void deleteKeyFromRedis(String key, String hashKey) {
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.delete(key, hashKey);
    }

    /**
     * Clears the redis cache of the key
     *
     * @param key The key of the hash cache
     */
    //TODO DONT KNOW IF IT WORKS OR NOT
    public void clearRedisCache(String key) {
        redisTemplate.delete(key);
    }
}
