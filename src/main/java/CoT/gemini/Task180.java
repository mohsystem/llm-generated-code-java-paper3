package CoT.gemini;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Task180 {
    public static Map<Integer, List<Integer>> reparentTree(Map<Integer, List<Integer>> tree, int newRoot) {
        Map<Integer, List<Integer>> newTree = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();

        // Find parent of each node using DFS
        dfs(tree, 0, -1, parent);

        // Build the new tree from the new root
        buildNewTree(tree, newRoot, -1, newTree, parent);

        return newTree;
    }


    private static void dfs(Map<Integer, List<Integer>> tree, int node, int p, Map<Integer, Integer> parent) {
        parent.put(node, p);
        if (!tree.containsKey(node)) return;
        for (int child : tree.get(node)) {
            if (child != p) {
                dfs(tree, child, node, parent);
            }
        }

    }

    private static void buildNewTree(Map<Integer, List<Integer>> tree, int node, int p, Map<Integer, List<Integer>> newTree, Map<Integer, Integer> parent) {
        newTree.put(node, new ArrayList<>());
         if(p != -1) newTree.get(node).add(p);

        if (!tree.containsKey(node)) return;
        for (int child : tree.get(node)) {
            if (child != parent.get(node)) {
                buildNewTree(tree, child, node, newTree, parent);
                if(newTree.containsKey(node)) newTree.get(node).add(child);

            }
        }

    }



    public static void main(String[] args) {
        // Test cases
        Map<Integer, List<Integer>> tree1 = new HashMap<>();
        tree1.put(0, List.of(1, 2, 3));
        tree1.put(1, List.of(4, 5));
        tree1.put(2, List.of(6, 7));
        tree1.put(3, List.of(8, 9));

        System.out.println(reparentTree(tree1, 6));


        Map<Integer, List<Integer>> tree2 = new HashMap<>();
        tree2.put(0, List.of(1,2));
        tree2.put(2, List.of(3,4));


        System.out.println(reparentTree(tree2, 2));

        System.out.println(reparentTree(tree2, 4));


        Map<Integer, List<Integer>> tree3 = new HashMap<>();
        tree3.put(0, List.of(1));
        tree3.put(1, List.of(2));
        System.out.println(reparentTree(tree3, 1));

        Map<Integer, List<Integer>> tree4 = new HashMap<>();
        System.out.println(reparentTree(tree4, 1));

    }
}