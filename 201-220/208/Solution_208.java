import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by chaycao on 2017/11/28.
 * chaycao@163.com
 */
public class Solution_208 {
    static class Trie {

        class ListNode {
            char val;
            boolean end;
            List<ListNode> next;
            ListNode(char x) {
                val = x;
                next = new ArrayList<>();
            }
        }

        private ListNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new ListNode('#');
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            ListNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char target = word.charAt(i);
                Iterator<ListNode> iterator = node.next.iterator();
                int flag = 0;
                ListNode next = null;
                while (iterator.hasNext()) {
                    ListNode n = iterator.next();
                    if (n.val == target) {
                        flag = 1;
                        next = n;
                        break;
                    }
                }
                if (flag == 1) {
                    node = next;
                } else { //不存在，自己加节点
                    ListNode n = new ListNode(target);
                    node.next.add(n);
                    node = n;
                }
            }
            node.end = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            ListNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char target = word.charAt(i);
                Iterator<ListNode> iterator = node.next.iterator();
                int flag = 0;
                ListNode next = null;
                while (iterator.hasNext()) {
                    ListNode n = iterator.next();
                    if (n.val == target) {
                        flag = 1;
                        next = n;
                        break;
                    }
                }
                if (flag == 1) {
                    node = next;
                } else { //不存在
                    return false;
                }
            }
            if (node.end == true)
                return true;
            else
                return false;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            ListNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                char target = prefix.charAt(i);
                Iterator<ListNode> iterator = node.next.iterator();
                int flag = 0;
                ListNode next = null;
                while (iterator.hasNext()) {
                    ListNode n = iterator.next();
                    if (n.val == target) {
                        flag = 1;
                        next = n;
                        break;
                    }
                }
                if (flag == 1) {
                    node = next;
                } else { //不存在
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("a");
        trie.insert("abc");
        trie.insert("abcdef");
        trie.insert("bcd");
        System.out.println(trie.search("abc"));
        System.out.println(trie.startsWith("ab"));
    }
}
