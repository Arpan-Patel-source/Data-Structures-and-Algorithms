class Solution {
    private List<Integer>[] adj;
    private int[] lastSeen;
    private int[] ans;
    private String s;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        this.s = s;
        this.ans = new int[n];
        this.lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int i = 1; i < n; i++)
            adj[parent[i]].add(i);

        dfs(0, -1);
        return ans;
    }
    private void dfs(int u, int origParent) {
        int c = s.charAt(u) - 'a';
        int prev = lastSeen[c];
        int target = (prev != -1) ? prev : origParent;
        lastSeen[c] = u;
        ans[u] = 1;
        for (int v : adj[u]) {
            dfs(v, u);
        }
        lastSeen[c] = prev;
        if (target != -1) {
            ans[target] += ans[u];
        }
    }
}
