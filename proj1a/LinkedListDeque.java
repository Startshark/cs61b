public class LinkedListDeque<T> {
    private class TNode {
        private T item;
        private TNode next;
        private TNode prev;

        private TNode(T item0, TNode next0, TNode prev0) {
            item = item0;
            next = next0;
            prev = prev0;
        }
    }

    /** Circular Deque */
    private TNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new TNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        TNode nextNode = sentinel.next;
        TNode firstNode = new TNode(item, nextNode, sentinel);
        sentinel.next = firstNode;
        if (nextNode != null) {
            nextNode.prev = firstNode;
        } else {
            sentinel.prev = firstNode;
        }
        size++;
    }

    public void addLast(T item) {
        TNode prevNode = sentinel.prev;
        TNode lastNode = new TNode(item, sentinel, prevNode);
        sentinel.prev = lastNode;
        if (prevNode != null) {
            prevNode.next = lastNode;
        } else {
            sentinel.next = lastNode;
        }
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        TNode start = sentinel.next;
        while (start != sentinel) {
            System.out.print(start.item + " ");
            start = start.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        TNode returnNode = sentinel.next;
        if (returnNode == sentinel) {
            return null;
        }
        TNode firstNode = returnNode.next;
        sentinel.next = firstNode;
        firstNode.prev = sentinel;
        size--;
        return returnNode.item;
    }

    public T removeLast() {
        TNode returnNode = sentinel.prev;
        if (returnNode == sentinel) {
            return null;
        }
        TNode lastNode = returnNode.prev;
        sentinel.prev = lastNode;
        lastNode.next = sentinel;
        size--;
        return returnNode.item;
    }

    public T get(int index) {
        TNode p = sentinel.next;
        for (int i = 0; i < index; i++) {
            if (p == sentinel) {
                return null;
            }
            p = p.next;
        }
        return p.item;
    }

    private T getRecursiveHelper(TNode node, int index) {
        if (node == sentinel) {
            return null;
        }
        if (index == 0) {
            return node.item;
        }
        return getRecursiveHelper(node.next, index - 1);
    }

    public T getRecursive(int index) {
        assert (index >= 0);
        return getRecursiveHelper(sentinel.next, index);
    }
}
