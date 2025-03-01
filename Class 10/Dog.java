import java.util.Comparator;

public class Dog implements Comparable<Dog> {
    private String name;
    private int weight;

    public Dog(String n, int w) {
        name = n;
        weight = w;
    }

    public void bark() {
        System.out.println(name + " says: bark");
    }
    
    @Override
    public int compareTo(Dog o) {
        return this.weight - o.weight;
    }

    private static class Namecomparator implements Comparator<Dog> {
        /** Somtimes a function needs the help of another function,
         *  Unlike Python we explicitly use function passing,
         *  In Java we do this by warpping up the needed function in an interface.
         */
        
        /** It doesn't need an instantiated dog, so we could use static. */
        public int compare(Dog a, Dog b){
            return a.name.compareTo(b.name);
        }
    }

    public static Comparator<Dog> getNameComparator() {
        return new Namecomparator();
    }

}
