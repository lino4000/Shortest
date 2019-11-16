/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lino4000
 */
public class DefaultSortResults {
    
    private List<DefaultSortResult> results;
    
    public DefaultSortResults(List<String> methods){
        results = new ArrayList();
        for(String m : methods){
            results.add(new DefaultSortResult(m));
        }
    }
    
    public void addResult(int i, Double time, Double elementsQty){
        results.get(i).add(time, elementsQty);
    }
    
    public Collection<Map<Double, Double>> getSerie(int i){
        return results.get(i).getData();
    }

    public List<DefaultSortResult> getSeries(int i){
        return results;
    }
    
    private class DefaultSortResult{
        
        private final String mathodName;
        private final Map<Integer,Map<Double,Double>> data;
        
        
        private DefaultSortResult(String methodName){
            this.mathodName = methodName;
            data = new HashMap();
        }
        
        private void add(Double time, Double elementsQty){
            HashMap<Double,Double> result = new HashMap<>();
            result.put(time, elementsQty);
            add(result);
        }
        
        private void add(Map<Double,Double> data){
            this.data.put(this.data.size(),data);
        }
        
        private Map<Double, Double> getLast(){
            return data.get(data.size()-1);
        }
        
        private Collection<Map<Double, Double>> getData(){
            return data.values();
        }

        public String toString(){
            return mathodName + data.toString();
        }
    }
    
    public String toString(){
        return results.toString();
    }
}