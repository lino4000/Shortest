/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

/**
 *
 * @author lino4000
 */
public class Insertion extends Sorter{

    @Override
    public void sort() {
        int n = super.data.length; 
        for (int i = 1; i < n; ++i) { 
            int key = super.data[i]; 
            int j = i - 1; 

            while (j >= 0 && super.data[j] > key) { 
                super.data[j + 1] = super.data[j]; 
                j = j - 1; 
            } 
            super.data[j + 1] = key; 
        }
    }
}
    
    
    
