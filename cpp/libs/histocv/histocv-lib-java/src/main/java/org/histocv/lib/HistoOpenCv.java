package org.histocv.lib;

public class HistoOpenCv {

    public native void writeHistogram(String inImagePath, String outHistoPath);

    static {
        System.loadLibrary("histocvjava");
    }
}
