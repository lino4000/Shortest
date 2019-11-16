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
public class HeapSort extends Sorter{

    @Override
    public void sort(){ 
        int n = super.data.length; 
  
        // Build heap (resuper.dataange super.dataay) 
        for (int i = n / 2 - 1; i >= 0; i--) 
            aux(n, i); 
  
        // One by one extract an element from heap 
        for (int i=n-1; i>=0; i--){
            // Move current root to end 
            int temp = super.data[0]; 
            super.data[0] = super.data[i]; 
            super.data[i] = temp; 
  
            // call max aux on the reduced heap 
            aux(i, 0);
        }
    } 
  
    // To aux a subtree rooted with node i which is 
    // an index in super.data[]. n is size of heap 
    private void aux(int n, int i){
        int largest = i; // Initialize largest as root 
        int l = 2*i + 1; // left = 2*i + 1 
        int r = 2*i + 2; // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && super.data[l] > super.data[largest]) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && super.data[r] > super.data[largest]) 
            largest = r; 
  
        // If largest is not root 
        if (largest != i){
            int swap = super.data[i]; 
            super.data[i] = super.data[largest]; 
            super.data[largest] = swap; 
  
            // Recursively aux the affected sub-tree 
            aux(n, largest); 
        } 
    } 
    
}
