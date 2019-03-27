package com.company;

public class Triangle {
    final double a, b, c;

    public Triangle(double a, double b, double c) throws Exception {
        this.a = a;
        this.b = b;
        this.c = c;
        if(a + b < c || a + c < b || b + c < a) throw new Exception(a + " " + b + " " + c + " not possible as triangle");
    }

    public double getA(){return a;}

    public double getB(){return b;}

    public double getC(){return c;}

    public double getCircumference(){return a + b + c;}

    public double getArea(){
        double p = getCircumference()/2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public boolean isRight(){
        return a*a+b*b==c*c || a*a+c*c==b*b || b*b+c*c==a*a;
    }
}
