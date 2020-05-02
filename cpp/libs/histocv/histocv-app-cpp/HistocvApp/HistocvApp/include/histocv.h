#include "opencv2/highgui/highgui.hpp"
#include "opencv2/imgproc/imgproc.hpp"
#include <iostream>
#include <fstream>

using namespace std;
using namespace cv;

class HistoCv
{
private:
	//void calcHistogram(cv::Mat source);
public:
	HistoCv();
	~HistoCv();
	void writeHistogram(const char *inImagePath, const char *outImagePath);
  	//Mat getHistogram(cv::String inputImageFilePath, cv::String outputImageFilePath);
};
