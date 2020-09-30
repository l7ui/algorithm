package leetcode.p146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 构建 LRU 缓存
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int MAX_ENTRIES;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.MAX_ENTRIES = capacity;
    }

    public int get(int key) {
        return getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_ENTRIES;
    }
}
