public class LinkedListDeque<T> {
    private Node<T> sentinel;
     
    public void add(T item) {
        Node<T> newNode = new Node<T>(item);
        if (size == 0) {
            sentinel.next = newNode;
            newNode.prev = sentinel;
            newNode.next = sentinel;
            sentinel.prev = newNode;
        } else {
            Node<T> lastNode = sentinel.prev;
            lastNode.next = newNode;
            newNode.prev = lastNode;
            newNode.next = sentinel;
            sentinel.prev = newNode;
        }
        size += 1;

    }
}
