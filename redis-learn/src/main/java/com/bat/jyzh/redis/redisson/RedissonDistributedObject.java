package com.bat.jyzh.redis.redisson;

import com.bat.jyzh.redis.entity.User;
import org.redisson.Redisson;
import org.redisson.api.RBitSet;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * Redisson 分布式对象
 *
 * @author ZhengYu
 * @version 1.0 2021/1/27 14:17
 **/
public class RedissonDistributedObject {
//    public static void main(String[] args) {
//        Config config = new Config();
//        config.useSingleServer()
//                .setAddress("redis://192.168.9.102:12007")
//                .setDatabase(3)
//                .setUsername("golang")
//                .setPassword("a884ebd3ab5e4fc4")
//                .setTimeout(3000);
//
//        RedissonClient redisson = Redisson.create(config);
//
//        // 通用对象桶（Object Bucket） 测试
////        testObjectBucket(redisson);
//
//        // BitSet 测试
////        testBitSet(redisson);
//
//        // 布隆过滤器（Bloom Filter） 测试
//        testBloomFilter(redisson);
//    }

    /**
     * 通用对象桶（Object Bucket） 测试
     *
     * @author ZhengYu
     */
    private static void testObjectBucket(RedissonClient redisson) {
        RBucket<User> bucket = redisson.getBucket("object:bucket:test");

        User user1 = new User(1L, "jy-zh");
        User user2 = new User(2L, "zy");

        bucket.set(user1);

        bucket.set(user2);
    }

    /**
     * BitSet 测试
     *
     * @author ZhengYu
     */
    private static void testBitSet(RedissonClient redisson) {
        RBitSet bitSet = redisson.getBitSet("bit:set:test");
        for (int i = 0; i < 64; i++) {
            bitSet.set(i, true);
        }
        System.out.println(bitSet.cardinality());
        System.out.println(Long.toBinaryString(bitSet.getLong(0)));
    }

    /**
     * 布隆过滤器（Bloom Filter） 测试
     *
     * @author ZhengYu
     */
    private static void testBloomFilter(RedissonClient redisson) {
        RBloomFilter<Integer> bloomFilter = redisson.getBloomFilter("bloom:filter:test");
        // 初始化布隆过滤器，预计统计元素数量为55000000，期望误差率为0.03
        bloomFilter.tryInit(55000000L, 0.03);

        bloomFilter.add(1);
        bloomFilter.add(100001);

        System.out.println(bloomFilter.contains(1));
    }
}
