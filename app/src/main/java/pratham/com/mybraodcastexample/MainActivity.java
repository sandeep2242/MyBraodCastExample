package pratham.com.mybraodcastexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver receiver = new BroadcastReceiver() {  // for in app braodcast
        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent.getBooleanExtra("state",false)){
                changeImage(R.drawable.ic_airplanemode_inactive_black_24dp);

            }else {
                changeImage(R.drawable.ic_airplanemode_active_black_24dp);
            }

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button)findViewById(R.id.btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBroadcast(new Intent("com.sandeep"));  // for custom braodcast
            }
        });

    }

    private void initFlightModeReceived(){
        IntentFilter filter = new IntentFilter();
        // filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        filter.addAction(Intent.ACTION_ANSWER);
        registerReceiver(receiver,filter);
    }

    public void changeImage(int image){

        ((ImageView)findViewById(R.id.imgs)).setImageResource(image);
    }
}
