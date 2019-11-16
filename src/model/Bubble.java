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
public class Bubble extends Sorter{

    @Override
    public void sort() {
        boolean swop = true;
        int aux;
        while (swop) {
            swop = false;
            for (int i = 0; i < super.data.length - 1; i++) {
                if (super.data[i] > super.data[i + 1]) {
                    aux = super.data[i];
                    super.data[i] = super.data[i + 1];
                    super.data[i + 1] = aux;
                    swop = true;
                }
            }
        }
    }
    
}
