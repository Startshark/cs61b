public class TestPlanet {
    static Planet p1 = new Planet(1.0, 2.0, 3.0, 4.0, 5.0e11, "jupiter.gif");
    static Planet p2 = new Planet(2.0, 3.0, 4.0, 5.0, 6.0e11, "mars.gif");
    static Planet p3 = new Planet(3.0, 4.0, 5.0, 6.0, 7.0e11, "earth.gif");
    static Planet[] allPlanets = {p1, p2, p3};
    public static void main(String[] args) {
        System.out.println("Testing Planet class...");
        System.out.println("calcForceExertedBy: " + p1.calcForceExertedBy(p2));
        System.out.println("calcForceExertedByX: " + p1.calcForceExertedByX(p2));
        System.out.println("calcForceExertedByY: " + p1.calcForceExertedByY(p2));
        System.out.println("calcNetForceExertedByX: " + p1.calcNetForceExertedByX(allPlanets));
        System.out.println("calcNetForceExertedByY: " + p1.calcNetForceExertedByY(allPlanets));
        p1.update(2.0, 1.0, 2.0);
    }   
}
