package mx.itesm.acoustics.appuntademo;

import com.appunta.android.location.LocationFactory;
import com.appunta.android.point.Point;
import com.appunta.android.point.impl.SimplePoint;
import com.appunta.android.point.renderer.PointRenderer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sky on 21/04/2015.
 */
public class GeoReferenciasModel {
    static List<Point> getPoints(PointRenderer renderer) {
        List<Point> points = new ArrayList<Point>();
        //points.add(new SimplePoint(31, LocationFactory.createLocation(19.284633, -99.138553), renderer, "Costco"));

        points.add(new SimplePoint(1, LocationFactory.createLocation(19.420738, -99.181967), renderer, "Castillo de chapultepec"));
        points.add(new SimplePoint(2, LocationFactory.createLocation(19.432911, -99.133269), renderer, "Zocalo"));
        points.add(new SimplePoint(3, LocationFactory.createLocation(19.688993, -98.863265), renderer, "Teotihuacan"));
        points.add(new SimplePoint(4, LocationFactory.createLocation(19.343548,  -99.151264), renderer, "Coyoacan"));
        points.add(new SimplePoint(5, LocationFactory.createLocation(19.435488,  -99.141168), renderer, "Bellas Artes"));
        points.add(new SimplePoint(6, LocationFactory.createLocation(19.432693, -99.131193), renderer, "Palacio Nacional"));
        points.add(new SimplePoint(7, LocationFactory.createLocation(19.435579, -99.139576), renderer, "Palacio de Mineria"));
        points.add(new SimplePoint(8, LocationFactory.createLocation(19.427272, -99.167654), renderer, "Angel de la Indepencia"));
        points.add(new SimplePoint(9, LocationFactory.createLocation(19.419730, -99.188244), renderer, "Bosque de chapultepec"));
        points.add(new SimplePoint(10, LocationFactory.createLocation(19.436578, -99.154576), renderer, "Plaza de la Republica"));



        return points;
    }


}
