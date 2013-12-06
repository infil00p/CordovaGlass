package org.apache.cordova.glass;

import org.apache.cordova.CordovaActivity;
import org.apache.cordova.CordovaWebView;

import android.content.Context;
import android.view.MotionEvent;

import com.google.android.glass.touchpad.Gesture;
import com.google.android.glass.touchpad.GestureDetector;

public class Twitchy extends GestureDetector {

    private CordovaActivity action;
    
    public Twitchy(CordovaActivity context) {
        super(context);
        action = context;
        setupWebViewEvents();
    }

    /*
     * Fun times had by all for gesture detectors!
     */
    
    private void setupWebViewEvents() {
        this.setBaseListener(new GestureDetector.BaseListener() {
            @Override
            public boolean onGesture(Gesture gesture) {
                action.postMessage("onGesture", gesture);
                return true;
            }
        });
        this.setFingerListener(new GestureDetector.FingerListener() {
            
            @Override
            public void onFingerCountChanged(int f1, int f2) {
                //Get the change in fingers 
                int df = f2 - f1;
                action.postMessage("onFingerCountChange", df);
            }
        });
        this.setScrollListener(new GestureDetector.ScrollListener() {
            
            @Override
            public boolean onScroll(float displacement, float delta, float velocity) {
                //Leave this for now, I have no idea how to use this!
                return false;
            }
        });
        
    }
    
    
}
