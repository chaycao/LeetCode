import java.util.ArrayList;

/**
 * Created by chaycao on 2017/11/27.
 * chaycao@163.com
 */
public class Solution_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            if (graph[prerequisites[i][0]] == null)
                graph[prerequisites[i][0]] = new ArrayList<Integer>();
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (graph[i] == null)
                continue;
            for (int j = 0; j < graph[i].size(); j++) {
                if (dfs(i, (int)graph[i].get(j), graph, visited) == false)
                    return false;
            }
        }
        return true;
    }
    public boolean dfs(int x, int y, ArrayList[] graph, boolean[] visited) {
        if (visited[x] == true)
            return false;
        if (graph[y] == null)
            return true;
        visited[x] = true;
        // 根据y走下一个点
        for (int i = 0; i < graph[y].size(); i++) {
            if (dfs(y, (int)graph[y].get(i), graph, visited) == false)
                return false;
        }
        visited[x] = false;
        return true;
    }
}
