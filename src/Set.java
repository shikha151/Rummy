/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rummygame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author test
 */
public class Set {
    
    private String generateKeyString(int i,int size)
    {
        String temp = "";
        for(int j=0;j<size;j++)
        {
            if( i < 10)
                temp += "0"+i+"|";
            else
                temp += i+"|";
            
        }
        return temp;
    }
    
    private void getNaturalset(TreeMap<String,Integer> result)
    {
        for(int i = 1; i <=52; i++)
        {
            result.put(generateKeyString(i,3),4);
        }   
    }
    
    private void generateCombinations(TreeMap<String,Integer> result,ArrayList<Integer> arrayset,int size)
    {
        CombinationMaker cm =  new CombinationMaker(arrayset.size(),size);
        while (cm.hasNext())
        {
            int[] a = cm.next();
            int[] b = new int[a.length];
            for(int j=0;j<a.length;j++)
            {
                b[j] = arrayset.get(a[j]);
            }
            Arrays.sort(b);
            String temp = "";
            int i =0;
            for(i = 0; i<b.length;i++)
            {
                if(b[i]<10)
                {
                    temp +="0"+b[i]+"|";
                }
                else
                {
                    temp +=b[i]+"|";
                }
                
            }
            
            result.put(temp, 1);
            
        }
    }
    
    private void getSetofLengthN(TreeMap<String,Integer> result,int size)
    {
        ArrayList<Integer> arrayset = new ArrayList<Integer>();
        for(int i= 1 ;i <=13; i++)
        {
            for(int j=0;j<3;j++)
            {
                arrayset.add(i);
                arrayset.add(i+13);
                arrayset.add(i+26);
                arrayset.add(i+39);
            }
            
            generateCombinations(result,arrayset,size);
            
            arrayset.clear();
        }
    }
    private void removeUnusedEntry(TreeMap<String,Integer> results)
    {
        for(int i=1;i<=52;i++)
        {
            String temp=generateKeyString(i,4);   
         results.remove(temp);
        }
        for(int i=1;i<=52;i++)
        {
            String temp=generateKeyString(i,5);   
         results.remove(temp);
        }
        
    }
    public TreeMap<String,Integer> getAllSet()
    {
        TreeMap<String,Integer> results = new TreeMap<String,Integer>();
    //   
        getSetofLengthN(results,3);
        getSetofLengthN(results,4);
        getSetofLengthN(results,5);
        removeUnusedEntry(results);
        getNaturalset(results);
        
        Iterator it = results.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        System.out.println(pair.getKey() + " = " + pair.getValue());
    }
    return results;
    }
    
    public static void main (String[] args)
    {
        Set s= new Set();
        s.getAllSet();
    }
}
