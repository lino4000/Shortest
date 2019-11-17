/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import view.Screen;

/**
 *
 * @author lino4000
 */
public class StartSorter extends MouseAdapter{
    
    @Override
    public void mouseClicked(MouseEvent e) {
        Screen screen = getScreen(e.getComponent());
//        screen = getParentComponentOf(e.getComponent(), Screen.class);
        try {
            Shortest.sorting(new SortParams(screen).getModel(), screen.getStatusDialog());
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    private Screen getScreen(Component c){
        if(c instanceof Screen)
            return (Screen) c;
        return getScreen(c.getParent());
    }
}