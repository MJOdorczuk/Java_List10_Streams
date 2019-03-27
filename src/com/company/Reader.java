package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Reader {

    public static ArrayList<Integer> readInts(String path) throws Exception {
        ArrayList<Integer> ret = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(path));
        for(String line = br.readLine(); line != null; line = br.readLine())
        {
            String consideredPart = line.split("//")[0].trim();
            if(consideredPart.length() != 0)
            {
                ret.add(Integer.parseInt(consideredPart));
            }
        }
        return ret;
    }

    public static LinkedList<Triangle> readTriangles(String path) throws Exception {
        LinkedList<Triangle> ret = new LinkedList<>();
        BufferedReader br = new BufferedReader(new FileReader(path));
        for(String line = br.readLine(); line != null; line = br.readLine()) {
            String[] consideredParts = line.split("//")[0].trim().split(" ");

            for (int i = 3; i < consideredParts.length; i++) {
                if (consideredParts[i].trim().length() > 0) throw new NumberFormatException();
            }
            double a = Double.parseDouble(consideredParts[0]);
            double b = Double.parseDouble(consideredParts[1]);
            double c = Double.parseDouble(consideredParts[2]);
            if (a <= 0 || b <= 0 || c <= 0) throw new Exception("Non-positive side found");
            ret.add(new Triangle(a, b, c));
        }
        return ret;
    }
}
