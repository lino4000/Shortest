/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import java.awt.Component;
import java.awt.Container;
import java.util.List;

/**
 *
 * @author lino4000
 */
public interface FunctionsListener<T> {
    public Class<T> getComponentOf(Component c, Class<T> cls);
    public <T> List<T> getComponentsOf(Container c, Class<T> cls);
    public Class<T> getParentComponentOf(Component c, Class<T> cls);
    public Class<T> getRootComponentOf(Component c, Class<T> cls);
}
