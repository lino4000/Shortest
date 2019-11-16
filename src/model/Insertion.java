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
public class Insertion extends Sorter{

    @Override
    public void sort() {
        int j;
        int key;
        int i;

        for (j = 1; j < super.data.length; j++)
        {
          key = super.data[j];
          for (i = j - 1; (i >= 0) && (super.data[i] > key); i--)
          {
             super.data[i + 1] = super.data[i];
           }
            super.data[i + 1] = key;
        }
    }
    
}
