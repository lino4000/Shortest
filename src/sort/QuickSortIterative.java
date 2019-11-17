/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.Stack;

/**
 *
 * @author lino4000
 */
public class QuickSortIterative extends Sorter{
    
    @Override
    public void sort() {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(super.data.length);

        while (!stack.isEmpty()) {
            int last = stack.pop();
            int first = stack.pop();
            if (last - first < 2) {
                continue;
            }
            int index = first + ((last - first) / 2);
            index = getIndex(index, first, last);

            stack.push(index + 1);
            stack.push(last);

            stack.push(first);
            stack.push(index);

        }
    }

    private int getIndex(int index, int first, int last) {
        int i = first;
        int j = last - 2;
        int pivot = super.data[index];
        swap(index, last - 1);

        while (i < j) {
            if (super.data[i] < pivot) {
                i++;
            } else if (super.data[j] >= pivot) {
                j--;
            } else {
                swap(i, j);
            }
        }
        index = j;
        if (super.data[j] < pivot) {
            index++;
        }
        swap(last - 1, index);
        return index;
    }

    private void swap (int i, int j) {
        int temp = super.data[i];
        super.data[i] = super.data[j];
        super.data[j] = temp;
    }
}