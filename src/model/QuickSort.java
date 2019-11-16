/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * @author lino4000
 */
public class QuickSort extends Sorter {

    @Override
    public void sort() {
        aux(0,super.data.length - 1);
    }

    private void aux(int first, int last) {
        if (first < last) {
            int index = getIndex(first, last);
            aux(first, index - 1);
            aux(index + 1, last);
        }
    }

    private int getIndex(int first, int last) {
        
        int index = super.data[last];
        int i = first, j = last - 1;
        
        while(i < j) {
            if (super.data[i] <= index)
                i++;
            else if (index < super.data[j])
                j--;
            else {
                int temp = super.data[i];
                super.data[i] = super.data[j];
                super.data[j] = temp;
                i++;
                j--;
            }
        }
        if (super.data[i] > index){
            super.data[last] = super.data[i];
            super.data[i] = index;
        }
    return i;
    }
    
    private int searchIndex(int first, int last){
        int search[] = new int[3];
        int i=0;
        for(int s:search){
            s = super.data[new Random().nextInt(last-first)+ first];
            i++;
        }
        Arrays.sort(search);
        return search[1];
    }
}
