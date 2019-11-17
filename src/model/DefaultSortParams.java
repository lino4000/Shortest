/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListModel;
import view.Screen;

/**
 *
 * @author lino4000
 */
public class DefaultSortParams {
    private List<String> paths;
    private List<String> methods;
    private int priority;
    private int type;
    private DefaultListModel status;

    public DefaultSortParams() {
        status = new DefaultListModel();
    }

    public void setPaths(List<String> paths){
        this.paths = paths;
    }
    
    public void setMethods(List<String> methods){
        this.methods = methods;
    }
    
    public void setPriority(int priority){
        this.priority = priority;
    }
    
    public void setTypeAutoData(int type){
        this.type = type;
    }

    public List<String> getPaths(){
        return this.paths;
    }
    
    public List<String> getMethods(){
        return this.methods;
    }
    
    public int getPriority(){
        return this.priority;
    }

    public int getTypeAutoData(){
        return type;
    }

    public DefaultListModel getStatus() {
        return status;
    }
}
