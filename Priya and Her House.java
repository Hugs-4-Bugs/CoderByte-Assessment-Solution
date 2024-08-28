import java.util.*; 
import java.io.*;

class Main {

  public static String Priyaandherhouse(String str) {
        String[] sides = str.split(" ");
        double A = Double.parseDouble(sides[0]);
        double B = Double.parseDouble(sides[1]);
        double C = Double.parseDouble(sides[2]);

        double s = (A + B + C) / 2;
        double areaOfTriangle = Math.sqrt(s * (s - A) * (s - B) * (s - C));

        double varOcg = (A * B * C) / (4 * areaOfTriangle); // __define-ocg__
        double areaOfPlot = 3.1415 * varOcg * varOcg;

        return String.format("%.4f", areaOfPlot);
    }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(Priyaandherhouse(s.nextLine())); 
  }

}
