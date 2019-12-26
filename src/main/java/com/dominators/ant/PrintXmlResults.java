package com.dominators.ant;

import com.dominators.CkjmOutputHandler;
import com.dominators.ClassMetrics;

import java.io.PrintStream;

public class PrintXmlResults implements CkjmOutputHandler {
    private PrintStream p;

    public PrintXmlResults(PrintStream p) {
        this.p = p;
    }

    public void printHeader() {
        p.println("<?xml version=\"1.0\"?>");
        p.println("<ckjm>");
    }

    public void handleClass(String name, ClassMetrics c) {
        p.print("<class>\n" +
                "<name>" + name + "</name>\n" +
                "<wmc>" + c.getWmc() + "</wmc>\n" +
                "<dit>" + c.getDit() + "</dit>\n" +
                "<noc>" + c.getNoc() + "</noc>\n" +
                "<cbo>" + c.getCbo() + "</cbo>\n" +
                "<rfc>" + c.getRfc() + "</rfc>\n" +
                "<lcom>" + c.getLcom() + "</lcom>\n" +
                "<ca>" + c.getCa() + "</ca>\n" +
                "<npm>" + c.getNpm() + "</npm>\n" +
                "</class>\n");
    }

    public void printFooter () {
        p.println("</ckjm>");
    }
}
