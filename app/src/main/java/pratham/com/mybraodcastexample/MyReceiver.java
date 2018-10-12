package pratham.com.mybraodcastexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {  // for whole life of an app

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getBooleanExtra("state",false)){
            Toast.makeText(context, "sand " +intent.getAction(), Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(context, "sand "+intent.getAction(), Toast.LENGTH_SHORT).show();
        }


    }
}
