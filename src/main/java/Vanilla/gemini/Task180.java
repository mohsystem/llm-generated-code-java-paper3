package Vanilla.gemini;
import java.util.*;

class Task180 {
    public static Map<Integer, List<Integer>> reparentTree(Map<Integer, List<Integer>> tree, int newRoot) {
        Map<Integer, List<Integer>> newTree = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();

        Queue<Integer> q = new LinkedList<>();
        q.offer(newRoot);
        parent.put(newRoot, null);

        while (!q.isEmpty()) {
            int curr = q.poll();
            newTree.put(curr, new ArrayList<>());

            for (int neighbor : tree.getOrDefault(curr, new ArrayList<>())) {
                if (!parent.containsKey(neighbor)) {
                    parent.put(neighbor, curr);
                    newTree.get(curr).add(neighbor);
                    q.offer(neighbor);
                }
            }
            if (parent.get(curr) != null && !newTree.getOrDefault(parent.get(curr), new ArrayList<>()).contains(curr)) {
                newTree.get(parent.get(curr)).add(curr);
            }

        }
        return newTree;
    }



    public static void main(String[] args) {
        Map<Integer, List<Integer>> tree1 = new HashMap<>();
        tree1.put(0, Arrays.asList(1, 2, 3));
        tree1.put(1, Arrays.asList(4, 5));
        tree1.put(2, Arrays.asList(6, 7));
        tree1.put(3, Arrays.asList(8, 9));
        System.out.println(reparentTree(tree1, 6));

        Map<Integer, List<Integer>> tree2 = new HashMap<>();
        tree2.put(1, Arrays.asList(2,3));
        tree2.put(2, Arrays.asList(4,5));
        System.out.println(reparentTree(tree2, 2));

        Map<Integer, List<Integer>> tree3 = new HashMap<>();
        tree3.put(0, Arrays.asList(1,2));
        System.out.println(reparentTree(tree3, 1));

        Map<Integer, List<Integer>> tree4 = new HashMap<>();
        System.out.println(reparentTree(tree4, 0));

        Map<Integer, List<Integer>> tree5 = new HashMap<>();
        tree5.put(0, Arrays.asList(1));
        tree5.put(1, Arrays.asList(2));
        System.out.println(reparentTree(tree5, 2));
    }
}