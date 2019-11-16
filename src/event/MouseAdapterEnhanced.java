/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import view.Screen;

/**
 *
 * @author lino4000
 * @param <T>
 */
public class MouseAdapterEnhanced<T> extends MouseAdapter implements FunctionsListener<T> {

    @Override
    public Class<T> getComponentOf(Component c, Class<T> cls) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> List<T> getComponentsOf(Container c, Class<T> cls){
        return Arrays.stream(c.getComponents())
                .filter(cls::isInstance)
                .map(cls::cast)
                .collect(Collectors.toList());
    }

    @Override
    public Class<T> getParentComponentOf(Component c, Class<T> cls) {
        if(cls.isInstance(c)){
            return (Class<T>) (T) c;
        }
        return getParentComponentOf(c.getParent(), cls);
    }

    @Override
    public Class<T> getRootComponentOf(Component c, Class<T> cls) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
