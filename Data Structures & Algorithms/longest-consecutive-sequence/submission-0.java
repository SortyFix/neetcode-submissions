class Solution {
    private static class UnionTree {
        private int[] parent;
        private int[] size;

        UnionTree(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i; 
                size[i] = 1;
            }
        }

        // Recursively travel through tree until root is reached
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); 
            }
            return parent[x];
        }

        // Connects the root of given elements a, b and connects the smaller tree
        // to the larger tree by comparing size. The smaller tree therefore becomes
        // subtree of the larger tree with the root being the one from the larger tree.
        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) return;

            if (size[rootA] < size[rootB]) {
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
                return;
            }

            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }

        // Get max value from size array
        public int getMaxSize() {
            int max = 0;
            for (int s : size) {
                max = Math.max(max, s);
            }
            return max;
        }
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], i);
        }

        UnionTree uf = new UnionTree(nums.length);

        // Check if currently viewed element + 1 is present in HashMap. If yes,
        // connect both trees together. Afterwards, check maximum height of full connected tree. 
        for (int i = 0; i < nums.length; i++) {
            Integer next = hm.get(nums[i] + 1);
            if (next != null) {
                uf.union(hm.get(nums[i]), next);
            }
        }

        return uf.getMaxSize();
    }
}