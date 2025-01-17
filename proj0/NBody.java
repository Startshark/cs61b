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
        Planet[] Planets = new Planet[numPlanets];
        for(int i = 0; i < numPlanets; i++){
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            Planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
        }
        return Planets;
    }
    
    private static String background = "images/starfield.jpg";

    private static void drawBackground(double radius){
		StdDraw.clear();
        StdDraw.picture(0, 0, background);
        // StdDraw.show();

        // StdDraw.pause(2000);
    }

    private static void drawPlanets(Planet Planets[]){
        for(int i = 0; i < Planets.length; i++){
            Planets[i].draw();
        }
    }

    private static void animation(double T, double dt, double radius, Planet[] Planets){
        int length = Planets.length;
        StdAudio.play("audio/2001.mid");
        for(double cur_time = 0; cur_time <= T; cur_time += dt){  // Problem Must be Here, it must be <= ! WTF!
            double[] xForces = new double[length];
            double[] yForces = new double[length];
            
            for(int i = 0; i < length; i++){
                xForces[i] = Planets[i].calcNetForceExertedByX(Planets);
                yForces[i] = Planets[i].calcNetForceExertedByY(Planets);
            }
            
            for(int i = 0; i < length; i++){
                Planets[i].update(dt, xForces[i], yForces[i]);
            }

            drawBackground(radius);
            drawPlanets(Planets);
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
        Planet[] Planets = readPlanets(filename);

        StdDraw.setScale(-radius, radius);
        StdDraw.enableDoubleBuffering();

        animation(T, dt, radius, Planets);

        StdOut.printf("%d\n", Planets.length);
        StdOut.printf("%.2e\n", radius);
        for(int i = 0; i < Planets.length; i++){
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            Planets[i].xxPos, Planets[i].yyPos, Planets[i].xxVel,
            Planets[i].yyVel, Planets[i].mass, Planets[i].imgFileName);
        }
        
    }
}
