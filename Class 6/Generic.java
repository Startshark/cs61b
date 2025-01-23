public class Generic<Technoblade> {
    /** Put any name in <> you like as Template! */
    private class StaffNode {
        public Technoblade item;
        public StaffNode next;
        public StaffNode(Technoblade i, StaffNode n){
            item = i;
            next = n;
        }
    }

    private StaffNode sentinel;
    private int size = 0;
    private Technoblade dummy;
    
    public Generic(){ 
        sentinel = new StaffNode(dummy, null);
        size = 0;
    }

    public Generic(Technoblade x){
        sentinel = new StaffNode(dummy, null);
        sentinel.next = new StaffNode(x, null);
        size = 1;
    }

    public void addFirst(Technoblade x){
        sentinel.next = new StaffNode(x, sentinel.next); 
        size += 1;
    }

    public Technoblade getFirst(){
        return sentinel.next.item;
    }

    public void addLast(Technoblade x){
        size += 1;
        StaffNode p = sentinel;
        while(p.next != null){
            p = p.next;
        }
        p.next = new StaffNode(x, null);
    }

    public int const_time_size(){
        return size;
    }
    
    public static void main(String[] args) {
        Generic L = new Generic(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(17);
        System.out.println(L.getFirst());
        System.out.println(L.const_time_size());
    }
}
