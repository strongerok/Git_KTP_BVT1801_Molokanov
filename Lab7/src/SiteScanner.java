package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SiteScanner {
    public  ArrayList<String> Line = new ArrayList<String>() {
    };
    public SiteScanner(){
    }
    public void Scanning (InputStream pack){
        ArrayList<String> line1 = new ArrayList<String>() {
        };
        InputStreamReader in = new InputStreamReader(pack);
        BufferedReader Scan = new BufferedReader(in);
        try {
            String linew;
            while ((linew=Scan.readLine())!=null){
                if (linew.length()>10) {
                    if (linew.contains("http://")) {
                        linew = linew.substring(linew.indexOf("http://"));
                        line1.add(linew.substring(0, linew.indexOf(" ")));
                    }
                }
                System.out.println(linew);
            }
            Line=line1;
        }
        catch(IOException ex) {
            Line = line1;
        }
    }
    public ArrayList<String> getLine(){
        return Line;
    }
}