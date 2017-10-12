import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by chayc on 2017/10/12.
 */
public class Solution_146 {
    class LRUCache {

        class Node {
            int key;
            int value;
            Node pre;
            Node next;

            public Node(int key, int value, Node pre, Node next) {
                this.key = key;
                this.value = value;
                this.pre = pre;
                this.next = next;
            }
        }

        private HashMap<Integer, Node> map;
        private Node head = null;
        private Node tail = null;
        private int capacity;

        public LRUCache(int capacity) {
            map = new HashMap<>(capacity, 1);
            this.capacity = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key))
            {
                Node node = map.get(key);
                int value = node.value;

                if (node != head) //往前移
                {
                    if (node == tail) { //若是尾巴则 修改tail，指向上一个节点
                        tail = tail.pre;
                        tail.next = null;
                    }

                    node.pre.next = node.next;
                    if (node.next != null)
                        node.next.pre = node.pre;
                    node.next = head;
                    head.pre = node;
                    node.pre =null;
                    head = node;
                }

                return value;
            }
            else
                return -1;
        }

        public void put(int key, int value) {
            if (map.size() == capacity && !map.containsKey(key)) {
                map.remove(tail.key);
                tail = tail.pre;
                if(tail!=null) tail.next = null;
            }

            // 检查是否有这个key
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;

                if (node != head) //往前移
                {
                    if (node == tail) { //若是尾巴则 修改tail，指向上一个节点
                        tail = tail.pre;
                        tail.next = null;
                    }
                    node.pre.next = node.next;
                    if (node.next != null)
                        node.next.pre = node.pre;
                    node.next = head;
                    head.pre = node;
                    node.pre =null;
                    head = node;
                }
            } else {
                Node node;// 插到队列开头
                if (head != null)
                {
                    node = new Node(key, value, null , head);
                    head.pre = node;
                    head = node;
                }
                else
                {
                    node = new Node(key, value, null , null);
                    head = node;
                    tail = node;
                }
                map.put(key, node);
            }
        }
    }
}
