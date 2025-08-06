class Solution {
    int tree[];

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = baskets.length;
        tree = new int[4 * n];
        buildSegmentTree(tree, baskets, 0, n - 1, 0);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += leftMostBasket(tree, fruits[i], 0, n - 1, 0);
        }
        return ans;
    }

    int leftMostBasket(int[] tree, int k, int i, int j, int node) {
        if (k > tree[node]) {
            return 1; // Cannot place fruit
        }
        if (i == j) {
            tree[node] = -1; // Mark as used
            return 0; // Successfully placed
        }

        int mid = i + (j - i) / 2;
        int pos;
        if (k <= tree[2 * node + 1]) {
            pos = leftMostBasket(tree, k, i, mid, 2 * node + 1);
        } else {
            pos = leftMostBasket(tree, k, mid + 1, j, 2 * node + 2);
        }

        tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
        return pos;
    }

    void buildSegmentTree(int[] tree, int[] baskets, int i, int j, int node) {
        if (i == j) {
            tree[node] = baskets[i];
            return;
        }

        int mid = i + (j - i) / 2;
        buildSegmentTree(tree, baskets, i, mid, 2 * node + 1);
        buildSegmentTree(tree, baskets, mid + 1, j, 2 * node + 2);

        tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
    }
}