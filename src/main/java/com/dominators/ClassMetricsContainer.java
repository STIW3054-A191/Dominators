package com.dominators;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class ClassMetricsContainer {
    /** The map from class names to the corresponding metrics */
    private HashMap<String, ClassMetrics> m = new HashMap<String, ClassMetrics>();

    /** Return a class's metrics */
    public ClassMetrics getMetrics(String name) {
        ClassMetrics cm = m.get(name);
        if (cm == null) {
            cm = new ClassMetrics();
            m.put(name, cm);
        }
        return cm;
    }

    /** Print the metrics of all the visited classes. */
    public void printMetrics(CkjmOutputHandler handler) {
        Set<Map.Entry<String, ClassMetrics>> entries = m.entrySet();
        Iterator<Map.Entry<String, ClassMetrics>> i;

        for (i = entries.iterator(); i.hasNext(); ) {
            Map.Entry<String, ClassMetrics> e = i.next();
            ClassMetrics cm = e.getValue();
            if (cm.isVisited() && (MetricsFilter.includeAll() || cm.isPublic()))
                handler.handleClass(e.getKey(), cm);
        }
    }

    public int[] calcTotal(){
        Set<Map.Entry<String, ClassMetrics>> entries = m.entrySet();
        Iterator<Map.Entry<String, ClassMetrics>> i;
        int wmc=0;int dit=0;int noc=0; int cbo=0;int rfc=0;int lcom=0;

        for (i = entries.iterator(); i.hasNext(); ) {
            Map.Entry<String, ClassMetrics> e = i.next();
            ClassMetrics cm = e.getValue();
            if (cm.isVisited() && (MetricsFilter.includeAll() || cm.isPublic())){
                wmc+=cm.getWmc();dit+=cm.getDit();noc+=cm.getNoc();cbo+=cm.getCbo();rfc+=cm.getRfc();lcom+=cm.getLcom();
            }
        }
        int[] ckjm=new int[6];
        ckjm[0]=wmc;
        ckjm[1]=dit;
        ckjm[2]=noc;
        ckjm[3]=cbo;
        ckjm[4]=rfc;
        ckjm[5]=lcom;
//        System.out.println(wmc+" "+dit+" "+noc+" "+cbo+" "+rfc+" "+lcom);
        return ckjm;
    }


}
