/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.JPanel;
import model.*;
import org.jfree.chart.ChartPanel;
import service.SortResults;
import view.Chart;

/**
 *
 * @author lino4000
 */
public class Sorting {
    
    private final StopWatch stopWatch;
    private ArrayList<Sorter> sorter;
    private List<Path> paths;
    private int size;
    private int file[] = {10000,100000};
    private Chart chart;
    private SortResults results;
    
    public Sorting(JPanel pn){
        stopWatch = new StopWatch();
        chart = new Chart(pn);
        sorter = new ArrayList<>();
        results = new SortResults();
    }
    
    public void run(DefaultSortParams params) throws InterruptedException{
        setParams(params);
        
        // Méééé
        chart.addSeries(results.setup(sorter));
        
        if(params.getTypeAutoData()>0 || true){
            for(int f : file){
                for(Sorter s : sorter){
                    s.setData(getFile(f));
                    stopWatch.setSorter(s);
                    stopWatch.run();
                    stopWatch.join();
                    Double timed = stopWatch.getTimed();
                    // Méé
                    chart.update(sorter.indexOf(s), f, timed);
                    
                    results.addResult(sorter.indexOf(s), (double) f, timed);

                    // POG
                    if(timed > 2)
                        chart.repaint();
                    // Last time. I swear
                    if(timed > 60){
                        Thread.sleep(timed.intValue()/10);
                    }
                }
            }
        }else{
            for(Path p : paths) {
                for(Sorter s : sorter){
                    s.setData(getData(p));
                    stopWatch.setSorter(s);
                    stopWatch.run();
                    stopWatch.join();
                    Double timed = stopWatch.getTimed();

                    // Méé
                    chart.update(sorter.indexOf(s), this.size, timed);
                    
                    results.addResult(sorter.indexOf(s), (double) this.size, timed);
                    
                    // POG
                    if(timed > 2)
                        chart.repaint();
                    // Last time. I swear
                    if(timed > 60){
                        Thread.sleep(timed.intValue()/10);
                    }
                }
            }
        }
    }
    
    private void setParams(DefaultSortParams params){
        addSorters(params.getMethods());
        addPaths(params.getPaths());
        setPriority(params.getPriority());
    }
    
    private void addSorters(List<String> methods){
        for(String s : methods){
            if(s.contains("Insertion"))
                sorter.add(new Insertion());
            if(s.contains("Selection"))
                sorter.add(new Selection());
            if(s.contains("Bubble"))
                sorter.add(new Bubble());
            if(s.contains("Merge"))
                sorter.add(new Merge());
            if(s.contains("Quicksort"))
                sorter.add(new QuickSort());
            if(s.contains("Bitonic"))
                sorter.add(new Bitonic());
            if(s.contains("HeapSort"))
                sorter.add(new HeapSort());
            if(s.contains("Radix"))
                sorter.add(new Radix());
        }
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
/*    
    private int[] getFile(int size){
        int data[] = new int[size];
        Random r = new Random();
        for(int i=0;i<size;i++){
            data[i] = r.nextInt(size * 10);
        }
        return data;
    }
*/
    private int[] getFile(int size){
        int data[] = new int[size];
        //Random r = new Random();
        for(int i=size;i>0;i--){
            data[size-i] = i;//r.nextInt(size * 10);
        }
        return data;
    }

}
