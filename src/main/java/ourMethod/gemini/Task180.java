package ourMethod.gemini;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task180 {

    public static Map<Integer, List<Integer>> reparentTree(Map<Integer, List<Integer>> tree, int newRoot) {
        Map<Integer, List<Integer>> newTree = new HashMap<>();
        Map<Integer, Integer> parentMap = new HashMap<>();

        // Build parent map using DFS
        buildParentMap(tree, 0, -1, parentMap);


        if (!parentMap.containsKey(newRoot)) {
            return tree; // Or throw exception if newRoot is invalid
        }

        // Build new tree using parent map
        buildNewTree(newTree, parentMap, newRoot, -1);
        return newTree;
    }


    private static void buildParentMap(Map<Integer, List<Integer>> tree, int node, int parent, Map<Integer, Integer> parentMap) {
        parentMap.put(node, parent);
        if (!tree.containsKey(node)) return;

        for (int child : tree.get(node)) {
            if (child != parent) {
                buildParentMap(tree, child, node, parentMap);
            }
        }
    }

    private static void buildNewTree(Map<Integer, List<Integer>> newTree, Map<Integer, Integer> parentMap, int node, int parent) {
        newTree.putIfAbsent(node, new ArrayList<>());
        if (parent != -1) {
            newTree.get(node).add(parent);
        }

        int originalParent = parentMap.get(node);
        if (originalParent != -1 && originalParent != parent) {
            buildNewTree(newTree, parentMap, originalParent, node);
        }

        if (!parentMap.containsKey(node)) return;
        for (Map.Entry<Integer,Integer> entry : parentMap.entrySet()) {
            if (entry.getValue() == node && entry.getKey() != parent && entry.getKey() != originalParent)
                buildNewTree(newTree, parentMap, entry.getKey(), node);
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
        System.out.println(reparentTree(tree1, 0));
        System.out.println(reparentTree(tree1, 9));



        Map<Integer, List<Integer>> tree2 = new HashMap<>();
        tree2.put(1, List.of(2, 3));
        tree2.put(2, List.of(4));

        System.out.println(reparentTree(tree2, 4));
        System.out.println(reparentTree(tree2, 1));

    }
}