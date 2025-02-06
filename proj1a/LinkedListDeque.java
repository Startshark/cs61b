public class LinkedListDeque<T> {
    public class TNode{
        public T item;
        public TNode next;
        public TNode prev;

        public TNode(T item0, TNode next0, TNode prev0){
            item = item0;
            next = next0;
            prev = prev0;
        }
    }
    
    /** Circular Deque */
    private TNode sentinel;
    private int size;

    public LinkedListDeque(){
        /* sentinel = new TNode(null, sentinel, sentinel); (x)
         * sentinel 节点在初始化时还没有被赋值，所以在这个语句中使用 sentinel 会导致它引用一个未初始化的对象。
         * 为了正确地形成循环链表，需要先创建一个 TNode 对象，然后再将 sentinel 赋值给它。
        */
        sentinel = new TNode(null, null, null); 
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T item){
        TNode nextNode = sentinel.next;
        TNode firstNode = new TNode(item, nextNode, sentinel);
        sentinel.next = firstNode;
        if(nextNode != null) nextNode.prev = firstNode;
        else sentinel.prev = firstNode;
        size++;
    }

    public void addLast(T item){
        TNode prevNode = sentinel.prev;
        TNode lastNode = new TNode(item, sentinel, prevNode);
        sentinel.prev = lastNode;
        if(prevNode != null) prevNode.next = lastNode;
        else sentinel.next = lastNode;
        size++;
    }

    public boolean isEmpty(){
        return size == 0;
        // return sentinel.next == sentinel;
    }

    public int size(){
        return size;
    }
    
    public void printDeque(){
        TNode start = sentinel.next;
        while(start != sentinel){
            System.out.print(start.item + " ");
            start = start.next;
        }
        System.out.println();
    }

    public T removeFirst(){
        /** Is there loitering? */
        TNode returnNode = sentinel.next;
        if(returnNode == sentinel) return null;
        TNode FirstNode = returnNode.next;
        sentinel.next = FirstNode;
        FirstNode.prev = sentinel;
        size--;
        return returnNode.item;
    }

    public T removeLast(){
        TNode returnNode = sentinel.prev;
        if(returnNode == sentinel) return null;
        TNode LastNode = returnNode.prev;
        sentinel.prev = LastNode;
        LastNode.next = sentinel;
        size--;
        return returnNode.item;
    }

    public T get(int index){
        TNode p = sentinel.next;
        for(int i = 0; i < index; i++){
            if(p == sentinel) return null;
            p = p.next;
        }
        return p.item;
    }

    private T getRecursiveHelper(TNode node, int index){
        /** 调用helper函数可以允许我们多传参数进去！ */
        if(node == sentinel) return null;
        if(index == 0) return node.item;
        return getRecursiveHelper(node.next, index - 1);
    }

    public T getRecursive(int index){
        assert(index >= 0);
        return getRecursiveHelper(sentinel.next, index);
    }

    // public static void main(String[] args) {
    //     LinkedListDeque<String> lld1 = new LinkedListDeque<>();
	// 	boolean passed = lld1.isEmpty();
    //     System.out.println("passed: " + passed);

    //     lld1.addFirst("front");

    //     passed = !lld1.isEmpty();
    //     System.out.println("passed: " + passed);

    //     lld1.addLast("middle");
    //     lld1.addLast("back");
        
    //     System.out.println("Size: " + lld1.size());

    //     lld1.printDeque();

    //     String first = lld1.removeFirst();
    //     System.out.println("Remove First: " + first);
        
    //     String back = lld1.getRecursive(1);
    //     System.out.println("Get Back: " + back);

    //     back = lld1.removeLast();
    //     System.out.println("Remove Back: " + back);

    //     String middle = lld1.removeLast();
    //     System.out.println("Remove Middle: " + middle);

    //     lld1.printDeque();
    //     passed = lld1.isEmpty();
    //     System.out.println("passed: " + passed);

    //     System.out.println(lld1.getRecursive(0));
    // }
}
