public class RotatingSLList<Item> extends SLList<Item> {
    /** Rotate list to the right */
    SLList<Item> deletedItems;

    public RotatingSLList(){
        // explicitly call the superclass's constructor
        super(); 
        deletedItems = new SLList<>();
    }

    public RotatingSLList(Item x){
        super(x); 
        // must be explicitly called, 
        // or it will call the default constructor in SLList.
        deletedItems = new SLList<>();
    }
    
    @Override
    public Item removeLast() {
        Item x = super.removeLast();
        /** calls superclass's method */
        deletedItems.addLast(x);
        return x;
    }

    public void rotateRight() {
        Item x = super.removeLast();
        addFirst(x);
    }
    
    public void printLostItems() {
        deletedItems.print();
    }

    public static void main(String[] args){
        RotatingSLList<Integer> L = new RotatingSLList<>(0);
        L.addFirst(10);
        L.addFirst(5);
        L.addFirst(2);
        L.addFirst(1);
        L.print();
        System.out.println();
        L.rotateRight();
        L.print();
        System.out.println();
        L.removeLast();
        L.removeLast();
        L.print();
        System.out.println();
        L.printLostItems();
    }
}

/**
 * (Type Checking)
 * SLList<Item> x = new RotatingSLList<>(); // OK, A RotatingSLList is a SLList.
 * RotatingSLList<Item> y = new SLList<>(); // Error, A SLList is not surely a RotatingSLList.
 * x.printLostItems(); // Error
 * 
 *  
 * (Type Casting)
 * Poodle frank = new Poodle("Frank", 5);
 * Malamute frankJr = new Poodle("Frank Jr.", 2);
 * Dog largerDog = maxDog(frank, frankJr); // Dog maxDog(Dog d1, Dog d2)
 * Poodle largerPoodle = (Poodle)maxDog(frank, frankJr); // Ok, now compile-time type is poodle, compiler ignore type checking 
 *
 *  
 * Java is a static type checking language, which means .
 * 
 * Example:
 * 
 * Object o2 = new Poodle("Frank", 5);
 * 
 * (1)
 * Poodle p = ((Poodle) o2); // Ok, now compile-time type is poodle, compiler ignore type checking
 * p.bark(); // Ok, it calls the Poodle's bark method.
 * 
 * (2)
 * 
 * Dog d = ((Dog) o2); // Ok, now compile-time type is Dog, compiler ignore type checking
 * d.bark(); // Ok, because Dog has bark method, but it calls the Poodle's bark method !!!
 * 
 * (3)
 * 
 * ((Dog) o2).bark(); // Ok, because Dog has bark method, but it calls the Poodle's bark method.
 * 
 * (4)
 * 
 * Object o3 = (Dog) o2;
 * o3.bark(); // Error, because Object does not have bark method. Although run-time type of o3 is Dog, but compile-time type(static) is Object.
 */