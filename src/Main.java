public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.delete(7);
        tree.containsNode(7);
        System.out.println(tree.containsNode(7));

    }
}