// File: HistoOpenCv.cpp
// Author: lourencoccc
#include "HistoOpenCv.h"
#include "histocv.h"



JNIEXPORT void JNICALL
Java_org_histocv_lib_HistoOpenCv_writeHistogram(
    JNIEnv *env, jobject obj, jstring inPath, jstring outPath)
{

    const char *strInPath = env->GetStringUTFChars(inPath, 0);
    char cap[128];
    strcpy(cap, strInPath);
    const char *strOutPath = env->GetStringUTFChars(outPath, 0);
    char cap1[128];
    strcpy(cap1, strOutPath);
    HistoCv histocv;
    histocv.writeHistogram(strInPath, strOutPath);
}
