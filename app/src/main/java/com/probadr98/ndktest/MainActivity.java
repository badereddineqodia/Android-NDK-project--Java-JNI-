package com.probadr98.ndktest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.JavaCameraView;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class MainActivity extends AppCompatActivity implements CameraBridgeViewBase.CvCameraViewListener2 {

    static {
        System.loadLibrary("MyOpencvLibrarys");

    }

    JavaCameraView javaCameraView;
    Mat mRgha,mGray;
    BaseLoaderCallback mBaseLoaderCallback=new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch (status){
                case BaseLoaderCallback.SUCCESS:
                    javaCameraView.enableView();
                    break;

                default:
                    super.onManagerConnected(status);
                    break;

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        javaCameraView=findViewById(R.id.javaCamView);
        javaCameraView.setVisibility(View.VISIBLE);
        javaCameraView.setCvCameraViewListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(javaCameraView!=null)
            javaCameraView.disableView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(OpenCVLoader.initDebug()){
            mBaseLoaderCallback.onManagerConnected(BaseLoaderCallback.SUCCESS);
        }else{

            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_2_4_9,this,mBaseLoaderCallback);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(javaCameraView!=null)
            javaCameraView.disableView();
    }

    @Override
    public void onCameraViewStarted(int width, int height) {
        mRgha=new Mat(height,width, CvType.CV_8UC4);
        mGray=new Mat(height,width, CvType.CV_8UC1);

    }

    @Override
    public void onCameraViewStopped() {
        mRgha.release();
    }

    @Override
    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
        mRgha=inputFrame.rgba();
        OpencvClass.faceDetection(mRgha.getNativeObjAddr());
        return mRgha;
    }
}
