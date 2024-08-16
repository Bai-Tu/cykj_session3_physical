package com.util;

import java.util.Random;

/**
 * @author 李璟瑜
 * @date 2024/8/14 9:03
 * @description:
 */
public class RandomOrderNumber {

    private static final Random RANDOM = new Random();

    public static String generateOrderNumber() {
        // 获取当前时间戳（毫秒级）
        long timestamp = System.currentTimeMillis();

        // 获取时间戳的最后6位作为前缀
        String timestampPrefix = String.format("%06d", timestamp % 1000000);

        // 生成6位随机数
        String randomComponent = String.format("%06d", RANDOM.nextInt(1000000));

        // 组合前缀和随机数
        String uniqueString = timestampPrefix + randomComponent;

        // 如果生成的字符串长度小于16位，使用前缀补齐到16位
        // 这里选择用时间戳前缀和随机数组合的方式，因为它们的组合可能会产生超长字符串
        // 确保最终字符串为16位
        return uniqueString.length() < 16 ? String.format("%-16s", uniqueString).replace(' ', '0') : uniqueString.substring(0, 16);
    }

}
