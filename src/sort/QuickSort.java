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
}
