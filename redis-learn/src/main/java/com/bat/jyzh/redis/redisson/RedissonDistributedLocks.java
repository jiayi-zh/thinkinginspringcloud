package com.bat.jyzh.redis.redisson;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 * Redisson 分布式锁
 *
 * @author ZhengYu
 * @version 1.0 2021/1/27 10:22
 **/
public class RedissonDistributedLocks {
    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://192.168.9.102:12007")
                .setDatabase(3)
                .setUsername("golang")
                .setPassword("a884ebd3ab5e4fc4")
                .setTimeout(3000);

        RedissonClient redisson = Redisson.create(config);

        // 可重入锁 测试
        testReentrantLock(redisson);
    }

    /**
     * 可重入锁 测试
     *
     * @author ZhengYu
     */
    private static void testReentrantLock(RedissonClient redisson) {
        RLock lock = redisson.getLock("lock:reentrant:business:15EED65A02274A16A169BD4C540E1014");

        lock.lock();

        System.out.println("lock");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}