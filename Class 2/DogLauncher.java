public class DogLauncher {
    public static void main(String[] args) {
        Dog[] dogs = new Dog[2];
        dogs[0] = new Dog(8);
        dogs[1] = new Dog(20);
        Dog d = new Dog(51);
        d.MakeNoise();
        dogs[1].MakeNoise();
        System.out.println();

        Dog bigger = Dog.maxDog(dogs[0], dogs[1]);
        bigger.MakeNoise();
        
        System.out.println();

        Dog bigger2 = dogs[0].maxDog(dogs[1]);
        bigger2.MakeNoise();
        System.out.println();
        
        Dog.WhatSpecies(); // static method use static variable  
        
    }
}
