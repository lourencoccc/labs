// File: histo.cv
// Author: lourencoccc
#include "opencv2/highgui/highgui.hpp"
#include "opencv2/imgproc/imgproc.hpp"
#include <iostream>
#include <fstream>

using namespace std;
using namespace cv;

//
class HistoCv
{
private:
	//no private members
public:
	HistoCv();
	~HistoCv();
	//wite histrogram from image inImagePath in outImagePath
	void writeHistogram(const char *inImagePath, const char *outImagePath);
};
