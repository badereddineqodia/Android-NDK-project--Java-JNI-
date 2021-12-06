LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)


#opencv
	OPENCVROOT:= /root/Desktop/OpenCV-android-sdk
	OPENCV_CAMERA_MODULES:=on
	OPENCV_INSTALL_MODULES:=on
	#OPENCV_LIB_TYPE:=STATIC
	OPENCV_LIB_TYPE:=SHARED
	include ${OPENCVROOT}/sdk/native/jni/OpenCV.mk

LOCAL_SRC_FILES := com_probadr98_ndktest_OpencvClass.cpp

#LOCAL_LDLIBS += -llog -ljnigraphics -lz -landroid

LOCAL_LDLIBS += -llog

LOCAL_MODULE := MyOpencvLibrarys

#LOCAL_SHARED_LIBRARIES := libavformat libavcodec libswscale libavutil

include $(BUILD_SHARED_LIBRARY)