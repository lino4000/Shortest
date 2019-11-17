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
public abstract class Sorter {
    
    int data[];
    
    public final void setData(int data[]){
        this.data = data;
    }
    
    abstract public void sort();
  
}
