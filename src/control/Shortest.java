/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Arrays;
import java.util.Random;
import javax.swing.JList;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import model.DefaultSortParams;
import sort.QuickSortIterative;
import sort.Sorter;
import view.Screen;

/**
 *
 * @author lino4000
 */
public class Shortest {
    private static final Screen screen = new Screen();
    private static final Sorting sorting = new Sorting(screen.getChartPanel());
    
    public static void main(String[] args) {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        screen.setVisible(true);
    }
    
    public static void sorting(DefaultSortParams params, JList statusDialog) throws InterruptedException{
        sorting.run(params, statusDialog);
    }
}
