/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rummygame;

import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author test
 */
public class Groups {
    
    public TreeMap<String,Integer> getGrouplength3()
    {
        rummygame.Set s= new rummygame.Set();
        Sequence t = new Sequence();
        TreeMap<String,Integer> results = new TreeMap<String,Integer>();
        results = s.getlength3set();
        results.putAll(t.getSequencelength3());
        
        return results;
    }
    public TreeMap<String,Integer> getGrouplength4()
    {
        rummygame.Set s= new rummygame.Set();
        Sequence t = new Sequence();
        TreeMap<String,Integer> results = new TreeMap<String,Integer>();
        results = s.getlength4set();
        results.putAll(t.getSequencelength4());
        
        return results;
    }
    public TreeMap<String,Integer> getGrouplength5()
    {
        rummygame.Set s= new rummygame.Set();
        Sequence t = new Sequence();
        TreeMap<String,Integer> results = new TreeMap<String,Integer>();
        results = s.getlength5set();
        results.putAll(t.getSequencelength5());
        
        return results;
    }


    public static void  main(String args[]){
        Groups gg = new Groups();
        TreeMap<String,Integer> map = gg.getGrouplength3();
        System.out.println(map);
    }
}
