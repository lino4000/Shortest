/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import sort.Bubble;
import sort.QuickSort;
import sort.Radix;
import sort.Selection;
import sort.Bitonic;
import sort.Merge;
import sort.Insertion;
import sort.Sorter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import model.*;
import sort.QuickSortIterative;
import view.Chart;

/**
 *
 * @author lino4000
 */
public class Sorting {
    
    private final StopWatch stopWatch;
    private ArrayList<SorterElement> sorter;
    private List<Path> paths;
    private int size;
    private Chart chart;
    private DefaultListModel status;
    
    public Sorting(JPanel pn){
        stopWatch = new StopWatch();
        chart = new Chart(pn);
        sorter = new ArrayList<>();
    }
    
    public void run(DefaultSortParams params, JList statusDialog) throws InterruptedException{
        setParams(params);
        chart.removeAll();
        chart.addSeries(sorter.stream()
                        .map((e) -> e.name)
                        .collect(Collectors.toList())
        );
        
        for(Path p : paths) {
            for(SorterElement s : sorter){
                addStatus("Carregando arquivo: "+p.toString().substring(p.toString().lastIndexOf("\\")), statusDialog);
                s.sorter.setData(getData(p));
                stopWatch.setSorter(s.sorter);
                addStatus("Ordenando com: " + s.name, statusDialog);
                stopWatch.run();
                stopWatch.join();
                Double timed = stopWatch.getTimed();
                addStatus("Tempo: " + timed, statusDialog);
                chart.update(sorter.indexOf(s), this.size, timed);

                // POG
                if(timed > 2)
                    chart.repaint();
                // Last time. I swear
                if(timed > 60){
                    Thread.sleep(timed.intValue()/10);
                }
            }
        }
        addStatus("Concluído.", statusDialog);
    }
    
    private void setParams(DefaultSortParams params){
        addSorters(params.getMethods());
        addPaths(params.getPaths());
        setPriority(params.getPriority());
        setStatus(params.getStatus());
    }
    
    private void addSorters(List<String> methods){
        sorter.clear();
        for(String s : methods){
            if(s.contains("Insertion"))
                sorter.add(new SorterElement(extractFromClass(Insertion.class), new Insertion()));
            if(s.contains("Selection"))
                sorter.add(new SorterElement(extractFromClass(Selection.class), new Selection()));
            if(s.contains("Bubble"))
                sorter.add(new SorterElement(extractFromClass(Bubble.class), new Bubble()));
            if(s.contains("Merge"))
                sorter.add(new SorterElement(extractFromClass(Merge.class), new Merge()));
            if(s.contains("Quicksort"))
                sorter.add(new SorterElement(extractFromClass(QuickSort.class), new QuickSort()));
            if(s.contains("Bitonic"))
                sorter.add(new SorterElement(extractFromClass(Bitonic.class), new Bitonic()));
            if(s.contains("QuickSort 2"))
                sorter.add(new SorterElement(extractFromClass(QuickSortIterative.class), new QuickSortIterative()));
            if(s.contains("Radix"))
                sorter.add(new SorterElement(extractFromClass(Radix.class), new Radix()));
        }
    }
    
    private String extractFromClass(Class c){
        String s = c.toString();
        return s.substring(s.lastIndexOf(".")+1);
    }
    
    private void addPaths(List<String> paths){
        this.paths = paths.stream()
                .map((p) -> Paths.get(p))
                .collect(Collectors.toList());
    }
    
    private void setPriority(int p){
        stopWatch.setPriority(p);
    }
    
    private List<String> loadData(Path path){
        List<String> contents = null;
        try {
            contents = Files.lines(path).skip(1).collect(Collectors.toList());
            this.size = contents.size();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return contents;
    }
        
    private int[] getData(Path path){

        List<String> contents = loadData(path);
        int data[] = new int[contents.size()];

        if(!contents.isEmpty()){
            int i = 0;
            for(String l : contents){
                String d[] = l.split(",");
                
                // Counting seconds
                data[i] =   (Integer.parseInt(d[5]))+
                            (Integer.parseInt(d[4]) * 60)+
                            (Integer.parseInt(d[3]) * 3600)+
                            ((Integer.parseInt(d[2]) -1 ) * 86400)+
                            ((Integer.parseInt(d[0])- 2014) * 31536000);
                switch (d[2]) {
                case "2":
                    data[i]+=2678400;
                    break;
                case "3":
                    data[i]+=5097600;
                    break;
                case "4":
                    data[i]+=7776000;
                    break;
                case "5":
                    data[i]+=10368000;
                    break;
                case "6":
                    data[i]+=13046400;
                    break;
                case "7":
                    data[i]+=15638400;
                    break;
                case "8":
                    data[i]+=18316800;
                    break;
                case "9":
                    data[i]+=20995200;
                    break;
                case "10":
                    data[i]+=23587200;
                    break;
                case "11":
                    data[i]+=26265600;
                    break;
                case "12":
                    data[i]+=28857600;
                    break;
                default:
                    break;
                }
                i++;
            }
        }
        return data;
    }

    private void setStatus(DefaultListModel status) {
        this.status = status;
    }
    
    private void addStatus(String s, JList statusDialog){
        status.addElement(s);
        statusDialog.setModel(status);
    }
    
    private class SorterElement{
        private String name;
        private Sorter sorter;
        
        private SorterElement(String name, Sorter sorter){
            this.name = name;
            this.sorter = sorter;
        }
    }
}
