package org.apache.cordova.glass;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;

import com.google.android.glass.touchpad.Gesture;

public class GlassOutput extends CordovaPlugin {

    private static final String TAG = "GlassOutput";
    private CallbackContext callbackContext;

    /**
     * Executes the request.
     *
     * This method is called from the WebView thread. To do a non-trivial amount of work, use:
     *     cordova.getThreadPool().execute(runnable);
     *
     * To run on the UI thread, use:
     *     cordova.getActivity().runOnUiThread(runnable);
     *
     * @param action          The action to execute.
     * @param args            The exec() arguments, wrapped with some Cordova helpers.
     * @param callbackContext The callback context used when calling back into JavaScript.
     * @return                Whether the action was valid.
     */
    public boolean execute(String action, CordovaArgs args, CallbackContext callbackContext) throws JSONException {
        this.callbackContext = callbackContext;
        if(action.equals("startTouchPad"))
        {
            startTouchPad();
        }
        if(action.equals("publishCard"))
        {
            pushCard(args);
        }
        if(action.equals("speechField"))
        {
            speechField(args);
        }
        else
        {
            return false;
        }
        PluginResult result = new PluginResult(PluginResult.Status.OK, "START");
        result.setKeepCallback(true);
        callbackContext.sendPluginResult(result);
        return true;
    }

    private void startTouchPad() {
        //NO-OP
        Log.d(TAG, "This does nothing!");
    }

    private void speechField(CordovaArgs args) {
        // TODO Auto-generated method stub
        
    }

    private void pushCard(CordovaArgs args) {
        // TODO Auto-generated method stub
        
    }
    
    //Just fire events
    public Object onMessage(String id, Object data)
    {
        Log.d(TAG, "Message Received");
        String out = "";
        if(id.equals("onGesture"))
        {
            Gesture input = (Gesture) data;
            if(Gesture.TAP == input)
            {
                out = "tap";
            }
            else if(Gesture.TWO_TAP == input)
            {
                out = "twotap";
            }
            else if(Gesture.THREE_TAP == input)
            {
                out = "threetap";
            }
            else if(Gesture.SWIPE_LEFT == input)
            {
                out = "swipeleft";
            }
            else if(Gesture.SWIPE_RIGHT == input)
            {
                out = "swiperight";
            }
            else if(Gesture.SWIPE_UP == input)
            {
                out = "swipeup";
            }
            else if(Gesture.TWO_SWIPE_LEFT == input)
            {
                out = "twoswipeleft";
            }
            else if(Gesture.TWO_SWIPE_RIGHT == input)
            {
                out = "twoswiperight";
            }
            else if(Gesture.TWO_SWIPE_UP == input)
            {
                out = "twoswipeup";
            }
            else if(Gesture.THREE_LONG_PRESS == input)
            {
                out = "threelongpress";
            }
            else if(Gesture.TWO_LONG_PRESS == input)
            {
                out = "twolongpress";
            }
            else if(Gesture.LONG_PRESS == input)
            {
                out = "longpress";
            }            
        }
        else if (id.equals("onFingerCountChange"))
        {
            out = "fingercountchanged";
        }
        
        String javaScriptStart = "javascript:try{cordova.fireDocumentEvent('";
        String javaScriptEnd = "');}catch(e){console.log('exception firing pause event from native');};";
        
        webView.loadUrl(javaScriptStart + out + javaScriptEnd);
        
        return data;
    }
    
}
