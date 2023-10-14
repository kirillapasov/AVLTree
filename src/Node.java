/** Класс, реализующий ноду, имеющий поля
 * Ключ(Значение), ссылки на левую и правую
 * ноду. Также реализован конструктор класса
 */

public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}
