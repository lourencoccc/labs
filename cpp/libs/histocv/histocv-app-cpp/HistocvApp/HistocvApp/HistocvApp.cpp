// HistocvApp.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "include\histocv.h"


int _tmain(int argc, _TCHAR* argv[])
{
	HistoCv histo;
	char pathIn[] = "C:\\Users\\joao_lourenco\\histocv_in.PNG";
	char pathOut[] = "C:\\Users\\joao_lourenco\\histocv_out.PNG";
	histo.writeHistogram(pathIn, pathOut);
	return 0;
}

