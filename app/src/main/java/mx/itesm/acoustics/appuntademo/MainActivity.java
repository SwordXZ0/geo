package mx.itesm.acoustics.appuntademo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.appunta.android.location.LocationFactory;
import com.appunta.android.orientation.Orientation;
import com.appunta.android.orientation.OrientationManager;
import com.appunta.android.point.Point;
import com.appunta.android.point.renderer.PointRenderer;
import com.appunta.android.point.renderer.impl.EyeViewRenderer;
import com.appunta.android.point.renderer.impl.SimplePointRenderer;
import com.appunta.android.ui.AppuntaView;
import com.appunta.android.ui.CameraView;
import com.appunta.android.ui.EyeView;
import com.appunta.android.ui.RadarView;

import java.util.List;


public class MainActivity extends ActionBarActivity implements OrientationManager.OnOrientationChangedListener, AppuntaView.OnPointPressedListener {
    private static final int MAX_DISTANCE = 10000;
    private EyeView vistaCamara;
    private RadarView radarComponente;
    private CameraView camera;
    private FrameLayout cameraFrame;
    private OrientationManager brujula;

    private List<Point> puntosDeLaCamara;
    private List<Point> puntosDelRadar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        brujula= new OrientationManager(this);
        brujula.setAxisMode(OrientationManager.MODE_AR);
        brujula.setOnOrientationChangeListener(this);
        brujula.startSensor(this);

        vistaCamara= (EyeView) findViewById(R.id.augmentedView1);
        radarComponente = (RadarView)findViewById(R.id.radarView1);

        vistaCamara.setMaxDistance(MAX_DISTANCE);
        radarComponente.setMaxDistance(MAX_DISTANCE);

        vistaCamara.setOnPointPressedListener(this);
        radarComponente.setOnPointPressedListener(this);

        /*
                 * Como se muestran los datos
                 */
        PointRenderer arRenderer = new EyeViewRenderer(getResources(), R.drawable.circle_selected,R.drawable.circle_unselected);

                /*
                 * Carga de puntos para la camara y para el RADAR
                 */
        puntosDeLaCamara = GeoReferenciasModel.getPoints(arRenderer);
        puntosDelRadar = GeoReferenciasModel.getPoints(new SimplePointRenderer());
        vistaCamara.setPoints(puntosDeLaCamara);
        radarComponente.setPoints(puntosDelRadar);

                /*
                 * Definir Localizacion Base
                 */
        vistaCamara.setPosition(LocationFactory.createLocation(19.283386, -99.135121, 12));//
        vistaCamara.setOnPointPressedListener(this);


                /*
                 * Definir Localizacion Base
                 */
        radarComponente.setPosition(LocationFactory.createLocation(19.283386, -99.135121));//
        radarComponente.setRotableBackground(R.drawable.arrow);

                /*
                 * Asignar cama a la vista
                 */
        cameraFrame = (FrameLayout) findViewById(R.id.cameraFrame);
        camera = new CameraView(this);
        cameraFrame.addView(camera);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onOrientationChanged(Orientation orientation) {
        vistaCamara.setOrientation(orientation);
        vistaCamara.setPhoneRotation(OrientationManager.getPhoneRotation(this));
        radarComponente.setOrientation(orientation);
    }

    @Override
    public void onPointPressed(Point point) {
        Toast.makeText(this, point.getName(), Toast.LENGTH_SHORT).show();
        unselectAllPoints();
        point.setSelected(true);
        Intent intent= new Intent(this,Lugares.class).putExtra("name",point.getName());
        startActivity(intent);
    }

    private void unselectAllPoints(){
        for(Point point: puntosDeLaCamara){
            point.setSelected(false);
        }

    }

    @Override
    public void onPause(){
        super.onPause();
        brujula.stopSensor();
    }

    @Override
    public void onResume(){
        super.onResume();
        brujula.startSensor(this);
    }

}
