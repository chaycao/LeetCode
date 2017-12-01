import java.util.ArrayList;

/**
 * Created by chaycao on 2017/12/1.
 * chaycao@163.com
 */
public class Solution_211 {
    class WordDictionary {

        class ListNode {
            char val;
            ArrayList<ListNode> next;
            boolean end;

            ListNode(char val) {
                this.val = val;
                next = new ArrayList<>();
            }
        }

        private ListNode root;

        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new ListNode('#');
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            char[] chars = word.toCharArray();
            ListNode p = root;
            boolean isNew = false;
            for (int i = 0; i < chars.length; i++) {
                boolean flag = false;
                if (isNew == false) {
                    for (int j = 0; j < p.next.size(); j++) {
                        if (chars[i] == p.next.get(j).val) {
                            flag = true;
                            p = p.next.get(j);
                            break;
                        }
                    }
                }
                if (flag == false) {
                    ListNode new_node = new ListNode(chars[i]);
                    p.next.add(new_node);
                    p = new_node;
                    isNew = true;
                }
                if (i == chars.length-1)
                    p.end = true;
            }
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return helperSearch(word, 0, root);
        }

        public boolean helperSearch(String s, int index, ListNode root) {
            boolean flag = false;
            char c = s.charAt(index);
            if (index == s.length()-1) { //到末尾了
                System.out.println(c+" "+root.next.size());
                if (c == '.' && root.next.size() != 0){
                    for (int i = 0; i < root.next.size(); i++) {
                        if (root.next.get(i).end == true)
                            return true;
                    }
                }

                for (int i = 0; i < root.next.size(); i++) {
                    if (root.next.get(i).val == c && root.next.get(i).end == true)
                        return true;
                }
                return false;
            }

            if (c == '.') {
                for (int i = 0; i < root.next.size(); i++) {
                    if (helperSearch(s, index+1, root.next.get(i)) == true) {
                        return true;
                    }
                }
            }
            for (int i = 0; i < root.next.size(); i++) {
                if (root.next.get(i).val == c)
                    if (helperSearch(s, index+1, root.next.get(i)) == true)
                        return true;
            }
            return false;
        }
    }

}
