package software.snowball.hbmtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.samsung.android.sdk.SsdkInterface;
import com.samsung.android.sdk.sensorextension.Ssensor;
import com.samsung.android.sdk.sensorextension.SsensorEvent;
import com.samsung.android.sdk.sensorextension.SsensorEventListener;
import com.samsung.android.sdk.sensorextension.SsensorExtension;
import com.samsung.android.sdk.sensorextension.SsensorManager;

public class MainActivity extends AppCompatActivity {

    Ssensor red;
    Ssensor ir;

    SSListenerIR mSSListenerIR = null;
    SSListenerRED mSSListenerRED = null;

    SsensorManager mSSensorManager = null;
    SsensorExtension mSsensorExtension = null;

    TextView tIR;
    TextView tRED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tIR = (TextView) findViewById(R.id.tvIR);
        tRED = (TextView) findViewById(R.id.tvRED);
    }

    private class SSListenerIR implements SsensorEventListener {

        @Override
        public void OnAccuracyChanged(Ssensor arg0, int arg1) {
            // TODO Auto-generated method stub
        }
        @Override
        public void OnSensorChanged(SsensorEvent event) {
            // TODO Auto-generated method stub
            Ssensor sIr = event.sensor;
            StringBuffer sb = new StringBuffer();
            sb.append("==== Sensor Information ====\n")
                    .append("Name : " + sIr.getName() + "\n")
                    .append("Vendor : " + sIr.getVendor() + "\n")
                    .append("Type : " + sIr.getType() + "\n")
                    .append("SDK Version : "
                            + mSsensorExtension.getVersionName() + "\n")
                    .append("MaxRange : " + sIr.getMaxRange() + "\n")
                    .append("Resolution : " + sIr.getResolution() + "\n")
                    .append("FifoMaxEventCount : " + sIr.getFifoMaxEventCount()
                            + "\n").append("Power : " + sIr.getPower() + "\n")
                    .append("----------------------------\n")
                    .append("IR RAW DATA(HRM) : " + event.values[0] + "\n");
            tIR.setText(sb.toString());
        }
    }

    private class SSListenerRED implements SsensorEventListener {
        @Override
        public void OnAccuracyChanged(Ssensor arg0, int arg1) {
        }
        @Override
        public void OnSensorChanged(SsensorEvent event) {
            // TODO Auto-generated method stub
            // Handling SsensorEvent with SSensorEventListener.
            Ssensor sIr = event.sensor;
            StringBuffer sb = new StringBuffer();
            sb.append("==== Sensor Information ====\n")
                    .append("Name : " + sIr.getName() + "\n")
                    .append("Vendor : " + sIr.getVendor() + "\n")
                    .append("Type : " + sIr.getType() + "\n")
                    .append("SDK Version : "
                            + mSsensorExtension.getVersionName() + "\n")
                    .append("MaxRange : " + sIr.getMaxRange() + "\n")
                    .append("Resolution : " + sIr.getResolution() + "\n")
                    .append("FifoMaxEventCount : " + sIr.getFifoMaxEventCount()
                            + "\n")
                    .append("Power : " + sIr.getPower() + "\n")
                    .append("----------------------------\n")
                    .append("RED LED RAW DATA(HRM) : " + event.values[0] + "\n");
            tRED.setText(sb.toString());
        }
    }
}
