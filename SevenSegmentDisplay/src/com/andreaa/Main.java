package com.andreaa;

import java.awt.*;
import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Main extends JPanel{

    int[] bin = new int[7];
    Polygon a = new Polygon(new int[]{299,249,299}, new int[]{25,50,75},3);
    Polygon a1 = new Polygon(new int[]{399,449,399}, new int[]{25,50,75},3);
    Polygon b = new Polygon(new int[]{454,479,504}, new int[]{126,76,126},3);
    Polygon b1 = new Polygon(new int[]{454,479,504}, new int[]{226,276,226},3);
    Polygon c = new Polygon(new int[]{454,479,504}, new int[]{377,327,377},3);
    Polygon c1 = new Polygon(new int[]{454,479,504}, new int[]{477,527,477},3);
    Polygon d = new Polygon(new int[]{299,249,299}, new int[]{528,553,578},3);
    Polygon d1 = new Polygon(new int[]{399,449,399}, new int[]{528,553,578},3);
    Polygon e = new Polygon(new int[]{195,220,245}, new int[]{377,327,377},3);
    Polygon e1 = new Polygon(new int[]{195,220,245}, new int[]{477,527,477},3);
    Polygon f = new Polygon(new int[]{195,220,245}, new int[]{126,76,126},3);
    Polygon f1 = new Polygon(new int[]{195,220,245}, new int[]{226,276,226},3);
    Polygon gi = new Polygon(new int[]{299,249,299}, new int[]{276,301,326},3);
    Polygon g1 = new Polygon(new int[]{399,449,399}, new int[]{276,301,326},3);

    /** This method build paints the components
     *  The components are builded according to the binary number contained in the binary number contained in the bin array
     *  The number is insert in the array by the main method
     **/
    public void paintComponent(Graphics g){
        //A
        if(bin[0] == 1){
            g.setColor(Color.red);
            g.fillPolygon(a);
            g.fillRect(299,25,100,50);
            g.fillPolygon(a1);
        }

        else{
            g.setColor(Color.black);
            g.fillPolygon(a);
            g.fillRect(299,25,100,50);
            g.fillPolygon(a1);
        }

        //B
        if(bin[1] == 1){
            g.setColor(Color.red);
            g.fillPolygon(b);
            g.fillRect(454,126,50,100);
            g.fillPolygon(b1);
        }

        else{
            g.setColor(Color.black);
            g.fillPolygon(b);
            g.fillRect(454,126,50,100);
            g.fillPolygon(b1);
        }

        //C
        if(bin[2] == 1){
            g.setColor(Color.red);
            g.fillPolygon(c);
            g.fillRect(454, 377, 50, 100);
            g.fillPolygon(c1);
        }
        else{
            g.setColor(Color.black);
            g.fillPolygon(c);
            g.fillRect(454, 377, 50, 100);
            g.fillPolygon(c1);
        }

        //D
        if(bin[3] == 1){
            g.setColor(Color.red);
            g.fillPolygon(d);
            g.fillRect(299,528,100,50);
            g.fillPolygon(d1);
        }

        else{
            g.setColor(Color.black);
            g.fillPolygon(d);
            g.fillRect(299,528,100,50);
            g.fillPolygon(d1);
        }

        //E
        if(bin[4] == 1){
            g.setColor(Color.red);
            g.fillPolygon(e);
            g.fillRect(195, 377, 50, 100);
            g.fillPolygon(e1);
        }

        else{
            g.setColor(Color.black);
            g.fillPolygon(e);
            g.fillRect(195, 377, 50, 100);
            g.fillPolygon(e1);
        }

        //F
        if(bin[5] == 1){
            g.setColor(Color.red);
            g.fillPolygon(f);
            g.fillRect(195, 126, 50, 100);
            g.fillPolygon(f1);
        }

        else{
            g.setColor(Color.black);
            g.fillPolygon(f);
            g.fillRect(195, 126, 50, 100);
            g.fillPolygon(f1);
        }

        //G
        if(bin[6] == 1){
            g.setColor(Color.red);
            g.fillPolygon(gi);
            g.fillRect(299,276,100,50);
            g.fillPolygon(g1);
        }

        else{
            g.setColor(Color.black);
            g.fillPolygon(gi);
            g.fillRect(299,276,100,50);
            g.fillPolygon(g1);
        }
    }

    /** The main method generate the JFrame and runs endlessly the counter
     *  In this case we've an DOWN counter which starts from 15(F in EX codification) and when its reaches 0 goes up to 15, and restarts again endlessly
     **/
    public static void main(String[] args)throws InterruptedException{
        int[] exNums = {0x7E, 0x30, 0x6D, 0x79, 0x33, 0x5B, 0x5F, 0x70, 0x7F, 0x7B, 0x77, 0x1F, 0x4E, 0x3D, 0x4F, 0x47};
        JFrame f;
        f = new JFrame("7 Segment Display UP-Counter");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBackground(Color.black);
        f.setSize(700,722);
        int k = 15;
        Main panel;
        while(1==1){
            panel = new Main();
            panel.bin = printNumbers(exNums, k);
            f.add(panel);
            f.setVisible(true);
            k--;
            if(k == -1)
                k=15;
            TimeUnit.SECONDS.sleep(1);
        }

    }

    /** This method prints the numbers in the JFrame turning on only the rights segments to display the correct number **/
    public static int[] printNumbers(int[] exNum, int k){
        String num = Integer.toBinaryString(exNum[k]);
        if(k == 1 || k == 4 || k == 13)
            num = "0"+num;
        else if(k == 11)
            num = "00"+num;
        int bin[] = new int[7];
        for(int i = 0; i<7; i++){
            bin[i] = Integer.parseInt(Character.toString(num.charAt(i)));
            System.out.print(bin[i]+"("+i+") | ");
        }
        System.out.println(k);
        return bin;
    }
}
