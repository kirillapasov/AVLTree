import java.util.Iterator;
import java.util.Stack;
/** BinaryTree - Бинарное дерево с итератором для обхода "in-order"
 BinaryTree представляет собой простую реализацию бинарного дерева на языке Java. Этот класс позволяет добавлять и удалять узлы, а также проверять наличие узла в дереве.
 * @author Apasov, Zhuravlev
 Структура класса
 • Node: Представляет узел в бинарном дереве.
 • BinaryTree: Основной класс, реализующий структуру и операции с бинарным деревом.
 • add(int value): Добавляет значение в бинарное дерево.
 • containsNode(int value): Проверяет наличие значения в бинарном дереве.
 • delete(int value): Удаляет узел с заданным значением из бинарного дерева.
 • TreeIterator: Вложенный класс, реализующий итератор для обхода в порядке "in-order".
 Итератор для обхода в порядке "in-order"
 Класс TreeIterator является вложенным классом внутри BinaryTree и реализует интерфейс Iterator<Integer> для обхода в порядке "in-order". Он позволяет итерироваться по бинарному дереву в следующем порядке: левый потомок, корень, правый потомок.
 Также создан вложенный класс Node, который представляет собой узел с полями ключя и ссылок на правый и левый узел. В классе создан метод Main, для примера использования BST.
 Использование:

 Создайте экземпляр BinaryTree и добавьте узлы с помощью метода add(int value).
 Создайте экземпляр TreeIterator для обхода дерева в порядке "in-order".
 Используйте hasNext(), чтобы проверить наличие следующего узла для обхода.
 Используйте next(), чтобы получить следующий узел при обходе.
 */
public class BinaryTree  {
    public static class Node {
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
    Node root;
    private Node addRecursive(Node current, int value){
        if (current == null){
            return new Node(value);
        }
        if (value < current.value) {
            current.left = addRecursive(current.left, value);

        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);

        }
        else {
            return current;
        }
        return current;

    }
    public void add (int value){
        root = addRecursive(root, value);
    }
    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value <current.value ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }
    public boolean containsNode(int value) {

        return containsNodeRecursive(root, value);

    }


    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }
    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }
    class TreeIterator implements Iterator<Integer> {
        private Node current;
        private final Stack<Node> stack;

        public TreeIterator() {
            stack = new Stack<>();
            current = root;
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty() || current != null;
        }

        @Override
        public Integer next() {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            Node node = stack.pop();
            current = node.right;
            return node.value;
        }
    }

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
        BinaryTree.TreeIterator iterator = tree.new TreeIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

    }


}
