package mx.itesm.acoustics.appuntademo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.HashMap;


public class Lugares extends ActionBarActivity {
    private HashMap<String,String> resenas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugares);

        resenas=new HashMap<String , String>();
        resenas.put("Castillo de chapultepec", "Es el único Castillo Real en América, fue construido en la época del Virreinato como casa de verano para el virrey, se le dio diversos usos, desde almacén de pólvora hasta academia militar en 1841, también fue la residencia oficial del emperador Maximiliano I de México");
        resenas.put("Zocalo", "El Zócalo, la plaza construida sobre la que fuera alguna vez el epicentro de Tenochtitlan (capital de la cultura azteca) es hoy el motor de los latidos de México.");
        resenas.put("Teotihuacan", "Tehotihuacan es el nombre que se da a la que fue una de las mayores ciudades prehispánicas de Mesoamérica. El topónimo es de origen náhuatl y fue empleado por los mexicas, pero se desconoce el nombre que le daban sus habitantes.");
        resenas.put("Coyoacan", "En la época precolombina, una parte del territorio coyoacanense se encontraba bajo el lago de Texcoco y Xochimilco. Durante el Preclásico Medio se desarrollaron en la zona algunas aldeas agrícolas, entre las que destaca Copilco por los testimonios de las costumbres funerarias de la época.");
        resenas.put("Bellas Artes", "El Palacio de Bellas Artes, ubicado en el Centro Histórico de la Ciudad de México, es la casa máxima de la expresión de la cultura, el teatro lírico más relevante y el centro más importante del país dedicado a todas las manifestaciones de las bellas artes.");
        resenas.put("Palacio Nacional", "El Palacio Nacional, ubicado en la Ciudad de México, es la sede del Poder Ejecutivo Federal de México. Su construcción se inició en 1522 como segunda residencia privada de Hernán Cortés sobre parte del palacio del huey tlatoani Moctezuma Xocoyotzin.");
        resenas.put("Palacio de Mineria", "El Palacio de Minería de la Ciudad de México es una de las obras maestras de la arquitectura neoclásica en América. Fue diseñado y construido entre 1797 y 1813 por el escultor y arquitecto español valenciano Manuel Tolsá, como sede del Real Seminario de Minería y Real Tribunal de Minería y a petición de su director, el conocido minerólogo Fausto Delhuyar.");
        resenas.put("Angel de la Indepencia", " Inaugurado en 1910 para conmemorar el Centenario de la independencia de México por el entonces presidente de México, Porfirio Díaz, es uno de los monumentos más emblemáticos de la urbe y usado actualmente como un icono cultural de la Ciudad de México y lugar de festejos y manifestaciones nacionales.");
        resenas.put("Bosque de chapultepec", "El Bosque de Chapultepec es un parque urbano localizado en la delegación Miguel Hidalgo, en el Distrito Federal (México). Es uno de los mayores en su tipo en el hemisferio occidental, con una superficie de 678 ha.");
        resenas.put("Plaza de la Republica", "Esta plaza es uno de los grandes espacios abiertos de la Ciudad de México en donde se llevan a cabo grandes eventos culturales, artísticos, políticos y civiles.");

        TextView t1 = (TextView)findViewById(R.id.titulo);
        TextView t2 = (TextView)findViewById(R.id.res);
        String name = getIntent().getStringExtra("name");
        t1.setText(name);
        t2.setText(resenas.get(name));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lugares, menu);
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
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
