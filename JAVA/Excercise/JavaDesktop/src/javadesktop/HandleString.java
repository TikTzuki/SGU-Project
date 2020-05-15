/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadesktop;

import java.util.ArrayList;

/**
 *
 * @author Tik
 */
public class HandleString {
    public static int getLength(String mess){
        return mess.length();
    }
    public static String getStandardized(String mess){
        String temp = mess;
        temp = temp.trim();
        temp = temp.replaceAll("\\s+", " ");
        return temp;
    }
    public static int countWord(String mess){
        String temp = mess;
        temp = temp.trim();
        temp = temp.replaceAll("\\s+", " ");
        int begin = 0, end, count = 0, i;
        for (i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == ' ') {
                count++;
                end = i;
                String child = temp.substring(begin, end);
                begin = end + 1;
                //System.out.println(child);
            }
        }
        end = i;
        System.out.println(mess.substring(begin, end));
        return (count+1);
    }
    public static ArrayList<String> decayString(String mess){
        ArrayList<String> arr = new ArrayList<String>();
        String temp[];
        temp = getStandardized(mess).split(" ");
        for(String i: temp){
            arr.add(i);
        }
        return arr;
    }
    
    public static String getKLeftWord(String mess, int k){
        String result = mess.substring(0, k - 1);
        return result;
    }
    
    public static String getKRightWord(String mess, int k){
        String result =  mess.substring(mess.length() - k, mess.length());
        return result;
    }
    
    public static String getNCharFromK(int n,int k,String mess){
        return mess.substring(k, k + n);
    }
    
}
