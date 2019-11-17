/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.ListModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.util.ExportUtils;
import view.Screen;

/**
 *
 * @author lino4000
 */
public class Export{
    
    public void toJPG(Screen screen){
        for(Component c : screen.getChartPanel().getComponents()){
            if(c instanceof ChartPanel){
                ChartPanel cp = (ChartPanel) c;
                JFreeChart chart = cp.getChart();
                File file = null;

                JFileChooser chooser = new JFileChooser();
                chooser.setFileFilter(new FileNameExtensionFilter("JPEG", "*.jpg"));
                if(chooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
                    file = chooser.getSelectedFile();
                    try {
                        ExportUtils.writeAsJPEG(chart, 1024,1024, file);
                    } catch (IOException ex) {
                        // FIXME: show a dialog with the error
                        throw new RuntimeException(ex);
                    }
                }
            }
        }
    }

    public void toTXT(Screen screen){
        ListModel model = screen.getStatusDialog().getModel();
        List lines = new ArrayList();
        for(int i=0;i<model.getSize();i++){
            lines.add(model.getElementAt(i));
        }

        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("TXT", "*.txt"));
        Path file = null;
        if(chooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
            file = chooser.getSelectedFile().toPath();
            try {
                Files.write(file, lines, StandardCharsets.UTF_8);
            } catch (IOException ex) {
               ex.getStackTrace();
            }
        }
    }
}