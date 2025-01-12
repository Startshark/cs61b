public class Dog {
    public int WeightInPounds;
    public static String species;
    
    /** One interger constructor for dogs. */
    public Dog(int w){
        WeightInPounds = w;
    }
    /* def __init__(): */

    public void MakeNoise(){
        if(WeightInPounds < 10)
            System.out.println("Yip!");
        else if(WeightInPounds < 30)
            System.out.println("Bark.");
        else
            System.out.println("Wooof!");}

    public static void WhatSpecies(){ 
        /** This method cannot access WeightInPounds */
        species = "Cat";
        species = "Dog";
        System.out.println("Anyway, this is a " + species);
    }

    public static Dog maxDog(Dog d, Dog d2){ 
        /** static method can only access static variables. */
        if(d.WeightInPounds > d2.WeightInPounds)
            return d;
        return d2;
    }

    public Dog maxDog(Dog d2){
        if(this.WeightInPounds > d2.WeightInPounds)
            return this;
        return d2;
    }
}
