/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
#include<stdio.h>
#include<opencv2/opencv.hpp>
/* Header for class com_probadr98_ndktest_OpencvClass */
using namespace cv;
using namespace std;

#ifndef _Included_com_probadr98_ndktest_OpencvClass
#define _Included_com_probadr98_ndktest_OpencvClass
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_probadr98_ndktest_OpencvClass
 * Method:    faceDetection
 * Signature: (J)V
 */
 void detect(Mat& frame);
JNIEXPORT void JNICALL Java_com_probadr98_ndktest_OpencvClass_faceDetection
  (JNIEnv *, jclass, jlong);

#ifdef __cplusplus
}
#endif
#endif
