public class Planet {
    public double xxPos, yyPos, xxVel, yyVel, mass;
    public static double G = 6.67e-11;
    public String imgFileName;

    public Planet(double xP, double yp, double xV, double yV, double m, String img){
        this.xxPos = xP;
        this.yyPos = yp;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet p){
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        return Math.sqrt(Math.pow(this.xxPos - p.xxPos, 2) + Math.pow(this.yyPos - p.yyPos, 2));
    }

    public double calcForceExertedBy(Planet p){
        return G * this.mass * p.mass / Math.pow(this.calcDistance(p), 2); 
    }

    public double calcForceExertedByX(Planet p){
        double dx = p.xxPos - this.xxPos;
        if(dx == 0) return 0; // avoid division by zero
        return this.calcForceExertedBy(p) * dx / this.calcDistance(p);
    }

    public double calcForceExertedByY(Planet p){
        double dy = p.yyPos - this.yyPos;
        if(dy == 0) return 0;
        return this.calcForceExertedBy(p) * dy / this.calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet allPlanets[]){
        double netForceX = 0;
        for (Planet allPlanet : allPlanets) {
            netForceX += this.calcForceExertedByX(allPlanet);
        }
        return netForceX;
    }

    public double calcNetForceExertedByY(Planet allPlanets[]){
        double netForceY = 0;
        for (Planet allPlanet : allPlanets) {
            netForceY += this.calcForceExertedByY(allPlanet);
        }
        return netForceY;
    }

    public void update(double dt, double fX, double fY){
        double aX = fX / this.mass;
        double aY = fY / this.mass;
        this.xxVel += aX * dt;
        this.yyVel += aY * dt;
        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
    }

    public void draw(){
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }

}
