/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author blasphemeous
 */
import java.lang.*; 
import java.io.PrintStream; 
import java.util.Arrays; 
import java.io.IOException; 

public class Donut {
    public static void main(String[] args) throws InterruptedException, IOException{
        float A = 0, B = 0;
        float i, j;
        int k;
        float[] z = new float[1760];
        char[] b = new char[1760];
        String green = "\u001B[32m";
         
        while (true) {
            Arrays.fill(b, ' ');
            Arrays.fill(z, 0);

            for (j = 0; j < 6.28; j += 0.07) {
                for (i = 0; i < 6.28; i += 0.02) {
                    float sini = (float) Math.sin(i);
                    float cosj = (float) Math.cos(j);
                    float sinA = (float) Math.sin(A);
                    float sinj = (float) Math.sin(j);
                    float cosA = (float) Math.cos(A);
                    float cosj2 = cosj + 2;
                    float mess = 1 / (sini * cosj2 * sinA + sinj * cosA + 5);
                    float cosi = (float) Math.cos(i);
                    float cosB = (float) Math.cos(B);
                    float sinB = (float) Math.sin(B);
                    float t = sini * cosj2 * cosA - sinj * sinA;
                    
                    int x = (int) (40 + 30 * mess * (cosi * cosj2 * cosB - t * sinB));
                    int y = (int) (12 + 15 * mess * (cosi * cosj2 * sinB + t * cosB));
                    int o = x + 80 * y;
                    int N = (int) (8 * ((sinj * sinA - sini * cosj * cosA) * cosB - sini * cosj * sinA - sinj * cosA - cosi * cosj * sinB));
                    
                    if (22 > y && y > 0 && x > 0 && 80 > x && mess > z[o]) {
                        z[o] = mess;
                        b[o] = ".,-~:;=!*#$@".charAt(N > 0 ? N : 0);
                    }
                }
            }
            Clear(); 
            for (k = 0; k < 1761; k++) {
                System.out.print(k % 80 > 0 ? b[k] : "\n");
            }

            A += 0.08;
            B += 0.06;
            Thread.sleep(30);
        }
    }
        public static void Clear(){
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }    
    }
} 