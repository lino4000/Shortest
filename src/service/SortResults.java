/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import java.util.Observable;
import java.util.stream.Collectors;
import model.DefaultSortResults;
import model.Sorter;

/**
 *
 * @author lino4000
 */
public class SortResults extends Observable{
    private DefaultSortResults results;
    
    public SortResults(){
        
    }
    
    public List<String> setup(List<Sorter> methods){
        List setup = methods.stream()
                        .map((e) -> e.getClass().toString())
                        .map((String e) -> e.substring(e.lastIndexOf(".")+1))
                        .collect(Collectors.toList());
        results = new DefaultSortResults(setup);
        return setup;
    }
    
    public void addResult(int i, Double time, Double elementsQty){
        results.addResult(i, time, elementsQty);
        notifyObservers();
        System.out.println(results.toString());
    }
}
