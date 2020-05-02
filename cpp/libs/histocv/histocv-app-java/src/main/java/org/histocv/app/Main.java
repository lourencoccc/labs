package org.histocv.app;

import org.histocv.lib.HistoOpenCv;
import java.io.File;

public class Main{

    public static void main(String args[]){
        HistoOpenCv histocv = new HistoOpenCv();
        String homePath = System.getProperty("user.dir");
        String inImagePath =  homePath + File.separator +  "histocv_in.png";
        String outHistoPath =  homePath + File.separator + "histocv_out.png";
        histocv.writeHistogram(inImagePath, outHistoPath);
        System.out.println("Histogram genreted: "+outHistoPath);
    }

}
