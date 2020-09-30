package leetcode.p332;

import java.util.*;

/**
 * 安排行程
 */
public class Solution {
    private Map<String, PriorityQueue<String>> map = new HashMap<>();
    private List<String> list = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null || tickets.size() == 0) {
            return list;
        }
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (!map.containsKey(from)) {
                map.put(from, new PriorityQueue<>());
            }
            map.get(from).offer(to);
        }
        dfs("JFK");
        Collections.reverse(list);
        return list;
    }

    public void dfs(String cur) {
        while (map.containsKey(cur) && map.get(cur).size() > 0) {
            String to = map.get(cur).poll();
            dfs(to);
        }
        list.add(cur);
    }
}
