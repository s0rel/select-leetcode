package org.sorel.leetcode.problem.design.p0535;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Codec {
    private Map</*随机数*/Integer, /*longUrl*/String> dataBase = new HashMap<>();
    private Random random = new Random();

    public String encode(String longUrl) {
        int key;
        while (true) {
            key = random.nextInt();
            if (!dataBase.containsKey(key)) {
                break;
            }
        }
        dataBase.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    public String decode(String shortUrl) {
        int position = shortUrl.lastIndexOf('/') + 1;
        int key = Integer.parseInt(shortUrl.substring(position));
        return dataBase.get(key);
    }
}

