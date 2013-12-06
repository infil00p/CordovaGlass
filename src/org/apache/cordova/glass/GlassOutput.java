package org.apache.cordova.glass;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

import com.google.android.glass.touchpad.Gesture;

public class GlassOutput extends CordovaPlugin {

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
        PluginResult result = new PluginResult(PluginResult.Status.NO_RESULT, "");
        result.setKeepCallback(true);
        callbackContext.sendPluginResult(result);
        return true;
    }

    private void startTouchPad() {
        //NO-OP
    }

    private void speechField(CordovaArgs args) {
        // TODO Auto-generated method stub
        
    }

    private void pushCard(CordovaArgs args) {
        // TODO Auto-generated method stub
        
    }
    
    public Object onMessage(String id, Object data)
    {
        String out = "";
        if(id.equals("onGesture"))
        {
            Gesture input = (Gesture) data;
            if(Gesture.TAP == input)
            {
                out = "TAP";
            }
            else if(Gesture.TWO_TAP == input)
            {
                out = "TWO_TAP";
            }
            else if(Gesture.THREE_TAP == input)
            {
                out = "THREE_TAP";
            }
            else if(Gesture.SWIPE_LEFT == input)
            {
                out = "SWIPE_LEFT";
            }
            else if(Gesture.SWIPE_RIGHT == input)
            {
                out = "SWIPE_RIGHT";
            }
            else if(Gesture.SWIPE_UP == input)
            {
                out = "SWIPE_UP";
            }
            else if(Gesture.TWO_SWIPE_LEFT == input)
            {
                out = "TWO_SWIPE_LEFT";
            }
            else if(Gesture.TWO_SWIPE_RIGHT == input)
            {
                out = "TWO_SWIPE_RIGHT";
            }
            else if(Gesture.TWO_SWIPE_UP == input)
            {
                out = "TWO_SWIPE_UP";
            }
            else if(Gesture.THREE_LONG_PRESS == input)
            {
                out = "THREE_LONG_PRESS";
            }
            else if(Gesture.TWO_LONG_PRESS == input)
            {
                out = "TWO_LONG_PRESS";
            }
            else if(Gesture.LONG_PRESS == input)
            {
                out = "LONG_PRESS";
            }            
        }
        else if (id.equals("onFingerCountChange"))
        {
            out = "FINGER_COUNT_CHANGED";
        }
        PluginResult result = new PluginResult(PluginResult.Status.OK, out);
        result.setKeepCallback(true);
        callbackContext.sendPluginResult(result);
        
        return data;
    }
    
}
