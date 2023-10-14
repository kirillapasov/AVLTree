/**
 * Бинарное Дерево пойска
 * @author Apasov, Zhuravlev
 */
public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(8);
        tree.add(1);
        tree.add(2);
        tree.delete(7);
        tree.containsNode(7);
        System.out.println(tree.containsNode(7));
        System.out.println("In-order traversal using iterator:");
        BinaryTree.TreeIterator iterator = tree.new TreeIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

    }
}