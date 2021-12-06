#include<com_probadr98_ndktest_OpencvNativeClass.h>

JNIEXPORT jint JNICALL Java_com_probadr98_ndktest_OpencvNativeClass_ConvertGray
  (JNIEnv *, jclass, jlong addrRgha, jlong addrGray){
  Mat& mRgha=*(Mat*)addrRgha;
  Mat& mGray=*(Mat*)addrGray;

  int convert;
  jint retVal;
  convert=toGray(mRgha,mGray);
  retVal=(jint)convert;
  return retVal;
  }

 int toGray(Mat img,Mat& gray){
 cvtColor(img,gray,CV_RGBA2GRAY);
 if(img.rows==gray.rows && img.cols==gray.cols)
 return 1;
 return 0;
 }