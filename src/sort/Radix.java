/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.HashSet;

/**
 *
 * @author lino4000
 */
public class Radix extends Sorter{

    @Override
    public void sort() {
        for(int digit = 0; digit < 9; digit ++){
            int power = (int) Math.pow(10, digit+1);

            int z[][] = new int[super.data.length][10];
            int n[] = new int[10];

            for(int i = 0; i < super.data.length; i ++){
                    int num = super.data[i];
                    z[n[(num%power)/(power/10)]][(num%power)/(power/10)] = num;
                    n[(num%power)/(power/10)]++;

            }
            int c = 0;
            for(int i = 0; i < 10; i ++){

                    for(int j = 0; j < super.data.length; j ++){
                            if(j < n[i]){
                                    super.data[c] = z[j][i];
                                    c++;
                            }else{break;}
                    }
            }
			
        }
    }
}
