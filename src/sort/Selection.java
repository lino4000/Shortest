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
public class Selection extends Sorter{

    @Override
    public void sort() {
        for (int comb = 0; comb < super.data.length - 1; comb++) {
                int smaller = comb;

            for (int i = smaller + 1; i < super.data.length; i++) {
                if (super.data[i] < super.data[smaller]) {
                   smaller = i;
                }
            }
            if (smaller != comb) {
                int t = super.data[comb];
                super.data[comb] = super.data[smaller];
                super.data[smaller] = t;
            }
        }
    }
    
}
