package CoT.llama31;
public class Task169 {
    public static int[] countSmaller(int[] nums) {
        int n = nums.length;
        int[] counts = new int[n];
        MergeSortTree mst = new MergeSortTree(nums);
        for (int i = n - 1; i >= 0; i--) {
            counts[i] = mst.query(nums[i]);
            mst.remove(nums[i]);
        }
        return counts;
    }

    static class MergeSortTree {
        private Node root;

        public MergeSortTree(int[] nums) {
            for (int num : nums) {
                insert(num);
            }
        }

        public void insert(int val) {
            root = insert(root, val);
        }

        public int query(int val) {
            return query(root, val);
        }

        public void remove(int val) {
            root = remove(root, val);
        }

        private Node insert(Node node, int val) {
            if (node == null) return new Node(val);
            if (val <= node.val) {
                node.left = insert(node.left, val);
                node.count++;
            } else {
                node.right = insert(node.right, val);
            }
            return node;
        }

        private int query(Node node, int val) {
            if (node == null) return 0;
            if (val <= node.val) {
                return query(node.left, val);
            } else {
                return node.count + query(node.right, val);
            }
        }

        private Node remove(Node node, int val) {
            if (node == null) return null;
            if (val < node.val) {
                node.left = remove(node.left, val);
                node.count--;
            } else if (val > node.val) {
                node.right = remove(node.right, val);
            } else {
                if (node.left == null) return node.right;
                if (node.right == null) return node.left;
                Node min = findMin(node.right);
                node.val = min.val;
                node.right = remove(node.right, min.val);
            }
            return node;
        }

        private Node findMin(Node node) {
            while (node.left != null) node = node.left;
            return node;
        }
    }

    static class Node {
        int val;
        Node left;
        Node right;
        int count;

        public Node(int val) {
            this.val = val;
            this.count = 1;
        }
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {5, 2, 6, 1},
            {-1},
            {-1, -1},
            {10, 5, 11, 10, 5},
            {0, 0, 0, 0}
        };

        for (int[] testCase : testCases) {
            int[] result = countSmaller(testCase);
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}