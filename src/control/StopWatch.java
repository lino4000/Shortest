/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import sort.Sorter;

/**
 *
 * @author lino4000
 */
public class StopWatch extends Thread{
    
    private Double timed;
    private Sorter sorter;
    
    public void setSorter(Sorter sorter){
        this.sorter = sorter;
    }
    
    @Override
    public void run(){
        timed = 0.0;
        Long initialTime, finalTime;
        initialTime = System.nanoTime();
        sorter.sort();
        finalTime = System.nanoTime();
        timed = (double) (finalTime - initialTime) / 1000000000;
        sorter = null;
    }
    
    public Double getTimed(){
        return timed;
    }
}
