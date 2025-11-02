package Neetcode250.graphs;

import java.util.*;

public class OpenTheLock {
    public int openLock(String deadends[], String target) {
        HashSet<String> dead = new HashSet<>(Arrays.asList(deadends));
        String start = "0000";
        if (dead.contains(start)) {
            return -1;
        }

        Queue<String> q = new LinkedList<>();
        q.offer(start);
        dead.add(start);
        int moves = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String curr = q.poll();
                if (curr.equals(target)) {
                    return moves;
                }
                StringBuilder current = new StringBuilder(curr);
                for (int i = 0; i < 4; i++) {
                    char ch = curr.charAt(i);
                    char inc = (ch == '9' ? '0' : (char) (ch + 1));
                    char dec = (ch == '0' ? '9' : (char) (ch - 1));

                    current.setCharAt(i, dec);
                    if (!dead.contains(current.toString())) {
                        q.offer(current.toString());
                        dead.add(current.toString());
                    }
                    current.setCharAt(i, inc);
                    if (!dead.contains(current.toString())) {
                        q.offer(current.toString());
                        dead.add(current.toString());
                    }
                    current.setCharAt(i, ch);
                }
            }
            moves++;

        }

        return -1;
    }
}
