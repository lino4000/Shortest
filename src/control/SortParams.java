/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.Component;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListModel;
import model.DefaultSortParams;
import view.Screen;
import view.Screen;

/**
 *
 * @author lino4000
 */
public class SortParams {
    private final DefaultSortParams model;
    
    public SortParams(Screen screen){
        model = new DefaultSortParams();
        model.setPaths(getPaths(screen));
        model.setMethods(getMethods(screen));
        model.setPriority(getPriority(screen));
        screen.getStatusDialog().setModel(model.getStatus());
    }
    
    public DefaultSortParams getModel(){
        return model;
    }
    
    private List<String> getPaths(Screen screen){
        ListModel listModel = screen.getFilesList().getModel();
        return IntStream.range(0,listModel.getSize())
                .mapToObj(listModel::getElementAt)
                .filter((o)-> o instanceof String)
                .map((Object o)-> (String) o)
                .collect(Collectors.toList());
    }
    
    private List<String> getMethods(Screen screen){
        return getComponentsOf(screen, JCheckBox.class).stream()
            .filter((c) -> c.isSelected())
            .map((c) -> c.getText())
            .collect(Collectors.toList());
    }

    private int getPriority(Screen screen){
        return 3;
    }
    
    private <T> List<T> getComponentsOf(Screen screen, Class<T> cls){
        return Arrays.stream(screen.getMethodsPanel().getComponents())
                .filter(cls::isInstance)
                .map(cls::cast)
                .collect(Collectors.toList());
    }

}