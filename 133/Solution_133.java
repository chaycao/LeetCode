import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Created by chayc on 2017/10/1.
 */
public class Solution_133 {
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    };
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        int[] visited = new int[1000];
        Stack<UndirectedGraphNode> old_stack = new Stack<>();
        Stack<UndirectedGraphNode> new_stack = new Stack<>();
        UndirectedGraphNode start = new UndirectedGraphNode(node.label);
        old_stack.push(node);
        new_stack.push(start);
        HashMap<Integer, UndirectedGraphNode> hasCreated = new HashMap<>();
        hasCreated.put(start.label, start);
        while (!old_stack.empty()) {
            UndirectedGraphNode current_old = old_stack.pop();
            UndirectedGraphNode current_new = new_stack.pop();
            for (int i = 0; i < current_old.neighbors.size(); i++) {
                UndirectedGraphNode old_node = current_old.neighbors.get(i);
                if (hasCreated.containsKey(old_node.label)) {
                    current_new.neighbors.add(hasCreated.get(old_node.label));
                    continue;
                }
                UndirectedGraphNode new_node = new UndirectedGraphNode(old_node.label);
                hasCreated.put(new_node.label, new_node);
                old_stack.push(old_node);
                new_stack.push(new_node);
                current_new.neighbors.add(new_node);
            }
        }
        return start;
    }

}
