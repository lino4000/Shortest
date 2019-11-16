/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author lino4000
 */
public class Bitonic extends Sorter{

    @Override
    public void sort() {
        aux( 0, super.data.length, 1); 
    }
    
    void aux(int low, int cnt, int dir) 
    { 
        if (cnt>1) 
        { 
            int k = cnt/2; 
  
            aux(low, k, 1); 
            aux(low+k, k, 0); 
            merge(low, cnt, dir); 
        } 
    }

    private void compAndSwap(int i, int j, int dir){ 
        if ( (super.data[i] > super.data[j] && dir == 1) || 
             (super.data[i] < super.data[j] && dir == 0)) 
        { 
            // Swapping elements 
            int temp = super.data[i]; 
            super.data[i] = super.data[j]; 
            super.data[j] = temp; 
        } 
    } 
  
    private void merge(int low, int cnt, int dir){ 
        if (cnt>1) 
        { 
            int k = cnt/2; 
            for (int i=low; i<low+k; i++) 
                compAndSwap(i, i+k, dir); 
            merge(low, k, dir); 
            merge(low+k, k, dir); 
        } 
    } 
  
}
