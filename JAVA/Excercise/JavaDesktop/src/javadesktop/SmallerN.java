/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadesktop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Tik
 */
public class SmallerN{
    private static ArrayList<Integer> arr = new ArrayList<Integer>();
    public static ArrayList primeSmallerN(int n){
        arr.removeAll(arr);
        for(int i=2; i<=n; i++){
            if(isPrime(i)){
                arr.add(i);
            }
        }
        return arr;
    }
    
    public static int sumPrimeSmallerN(int n){
        int sum=0;
        arr.removeAll(arr);
        arr = primeSmallerN(n);
        for(int temp:arr){
            sum+=temp;
        }
        return sum;
    }
    
    public static ArrayList evenSmallerN(int n){
        arr.removeAll(arr);
        for(int i=2; i<=n; i++){
            if(i%2==0){
                arr.add(i);
            }
        }
        return arr;
    }
    
    public static int sumEvenSmallerN(int n){
        int sum=0;
        arr.removeAll(arr);
        arr = evenSmallerN(n);
        for(int temp:arr){
            sum+=temp;
        }
        return sum;
    }
    
    public static ArrayList oddSmallerN(int n){
        arr.removeAll(arr);
        for(int i=1; i<=n; i++){
            if(i%2!=0){
                arr.add(i);
            }
        }
        return arr;
    }
    
    public static int sumOddSmallerN(int n){
        int sum=0;
        arr.removeAll(arr);
        arr = oddSmallerN(n);
        for(int temp:arr){
            sum+=temp;
        }
        return sum;
    }
    
    public static ArrayList nNumPrime(int n){
        arr.removeAll(arr);
        int i=2, count=0;
        while(true){
            if(isPrime(i)){
                arr.add(i);
                count++;
                if(count==n)
                    break;
            }
            i++;
        }
        return arr;
    }
    
    public static int sumNNumPrime(int n){
        int sum=0;
        arr.removeAll(arr);
        arr = nNumPrime(n);
        for(int temp:arr){
            sum+=temp;
        }
        return sum;
    }

    public static ArrayList getEvenItem(ArrayList<Integer> array) {
        arr.clear();
        for (int temp : array) {
            if (temp % 2 == 0) {
                arr.add(temp);
            }
        }
        return arr;
    }

    public static ArrayList getOddItem(ArrayList<Integer> array) {
        arr.clear();
        for (int temp : array) {
            if (temp % 2 != 0) {
                arr.add(temp);
            }
        }
        return arr;
    }

    public static ArrayList getPrimeItem(ArrayList<Integer> array) {
        arr.clear();
        for (int temp : array) {
            if (isPrime(temp)) {
                arr.add(temp);
            }
        }
        return arr;
    }
    public static int sumAllItem(ArrayList<Integer> array) {
        int sum = 0;
        for (int temp : array) {
            sum += temp;
        }
        return sum;
    }
    public static int sumEvenItem(ArrayList<Integer> array) {
        int sum = 0;
        for (int temp : array) {
            if (temp % 2 == 0) {
                sum += temp;
            }
        }
        return sum;
    }

    public static int sumOddItem(ArrayList<Integer> array) {
        int sum = 0;
        for (int temp : array) {
            if (temp % 2 != 0) {
                sum += temp;
            }
        }
        return sum;
    }

    public static int sumPrimeItem(ArrayList<Integer> array) {
        int sum = 0;
        for (int temp : array) {
            if (isPrime(temp)) {
                sum += temp;
            }
        }
        return sum;
    }
    public static boolean isPrime(int n){
        for(int i=2; i<n; i++){
            if(n%i==0)
                return false;
        }
        return true;
    } 
    
}
