public class NBody {
    public static double readRadius(String filename) { // This is a static method
        In in = new In(filename);
        int numPlanets = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String filename){
        In in = new In(filename);
        int numPlanets = in.readInt();
        double radius = in.readDouble();
        Planet allPlanets[] = new Planet[numPlanets];
        for(int i = 0; i < numPlanets; i++){
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            allPlanets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
        }
        return allPlanets;
    }
    
    public static String background = "images/starfield.jpg";

    private static void drawBackground(double radius){
        StdDraw.setScale(-radius, radius);
		StdDraw.clear();
        StdDraw.picture(0, 0, background);
        // StdDraw.show();

        // StdDraw.pause(2000);
    }

    private static void drawPlanets(Planet allPlanets[]){
        for(int i = 0; i <allPlanets.length; i++){
            allPlanets[i].draw();
        }
    }

    private static void animation(double T, double dt, double radius, Planet[] allPlanets){
        int length = allPlanets.length;
        for(double cur_time = 0; cur_time < T; cur_time += dt){
            double[] xForces = new double[length];
            double[] yForces = new double[length];
            
            for(int i = 0; i < length; i++){
                xForces[i] = allPlanets[i].calcNetForceExertedByX(allPlanets);
                yForces[i] = allPlanets[i].calcNetForceExertedByY(allPlanets);
            }
            
            for(int i = 0; i < length; i++){
                allPlanets[i].update(dt, xForces[i], yForces[i]);
            }

            drawBackground(radius);
            drawPlanets(allPlanets);
            StdDraw.show();
            StdDraw.pause(10);

            cur_time += dt;            
        }
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet allPlanets[] = readPlanets(filename);

        // drawBackground(radius);
        // drawPlanets(allPlanets);

        StdDraw.enableDoubleBuffering();

        animation(T, dt, radius, allPlanets);

        StdOut.printf("%d\n", allPlanets.length);
        StdOut.printf("%.2e\n", radius);
        for(int i = 0; i < allPlanets.length; i++){
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            allPlanets[i].xxPos, allPlanets[i].yyPos, allPlanets[i].xxVel,
            allPlanets[i].yyVel, allPlanets[i].mass, allPlanets[i].imgFileName);
        }
    }
}
