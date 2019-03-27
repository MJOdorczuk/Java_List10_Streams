package com.company;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> ints = Reader.readInts("D:\\Desktop\\studia\\Informatyka\\Java\\List10\\src\\res\\dane.txt");
        LinkedList<Triangle> triangles = Reader.readTriangles("D:\\Desktop\\studia\\Informatyka\\Java\\List10\\src\\res\\dane2.txt");

        System.out.println("Sorted ints:");
        ints.stream().sorted((a,b) -> a < b ? 1 : -1).forEach(x -> System.out.println(x));

        System.out.println("\n\nPrime ints:");
        ints.stream().filter(x -> {
            if(x < 2) return false;
            int rootx = (int)Math.sqrt(x);
            if(x % 2 == 0) return false;
            for(int i = 3; i <= rootx; i += 2)
            {
                if(x % i == 0) return false;
            }
            return true;
        }).forEach(x -> System.out.println(x));

        System.out.println("\n\nSum of ints lower than 1000:");
        System.out.println(ints.stream().filter(x -> x < 1000).mapToInt(i -> i).sum());

        System.out.println("\n\nTriangles sorted by circumferences:");
        triangles.stream().sorted((a,b) -> a.getCircumference() > b.getCircumference() ? 1 : -1).
                forEach(x -> System.out.println(MessageFormat.format
                        ("a:{0}, b:{1}, c:{2}, circumference:{3}",
                                x.getA(), x.getB(), x.getC(), x.getCircumference())));

        System.out.println("\n\nRight triangles:");
        triangles.stream().filter(x -> x.isRight()).forEach(x -> System.out.println(MessageFormat.format
                ("a:{0}, b:{1}, c:{2}", x.getA(), x.getB(), x.getC())));

        System.out.println("\n\nThe smallest triangle:");
        Triangle smallest = triangles.stream().sorted((a,b) -> a.getArea() > b.getArea() ? 1 : -1).findFirst().get();
        System.out.println(MessageFormat.format("a:{0}, b:{1}, c:{2}, area:{3}",
                smallest.getA(), smallest.getB(), smallest.getC(), smallest.getArea()));

        System.out.println("\n\nThe largest triangle:");
        Triangle largest = triangles.stream().sorted((a,b) -> a.getArea() < b.getArea() ? 1 : -1).findFirst().get();
        System.out.println(MessageFormat.format("a:{0}, b:{1}, c:{2}, area:{3}",
                largest.getA(), largest.getB(), largest.getC(), largest.getArea()));

    }
}
