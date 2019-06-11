package cordova.plugin.freecharge;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.AlertDialog;
import android.content.DialogInterface;
/**
 * This class echoes a string called from JavaScript.
 */
public class freechargeplugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            String message = args.getString(0);
            this.coolMethod(message, callbackContext);
            return true;
        }
        return false;
		
		
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(cordova.getActivity());
builder.setMessage("Look at this dialog!")
       .setCancelable(false)
       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
           public void onClick(DialogInterface dialog, int id) {
                //do things
                 callbackContext.success(message);	
           }
       });
AlertDialog alert = builder.create();
alert.show();
           	
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
