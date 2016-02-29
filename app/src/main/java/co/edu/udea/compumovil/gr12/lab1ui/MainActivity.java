package co.edu.udea.compumovil.gr12.lab1ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText nombre, apellido, pais, telefono, direccion, email;
    AutoCompleteTextView ac_paises;
    RadioGroup sexo;
    Spinner hobbies;
    CheckBox favorito;
    TextView texto;
    Button boton;
    DatePicker dp_fecha;
    Date fecha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nombre = (EditText) findViewById(R.id.Nombre);
        apellido = (EditText) findViewById(R.id.Apellido);

        sexo = (RadioGroup) findViewById(R.id.Sexo);

        dp_fecha = (DatePicker) findViewById(R.id.fecha);
        pais = (EditText) findViewById(R.id.pais);
        telefono = (EditText) findViewById(R.id.telefono);
        direccion = (EditText) findViewById(R.id.direccion);
        email = (EditText) findViewById(R.id.email);

        hobbies = (Spinner) findViewById(R.id.hobbies);
        favorito = (CheckBox) findViewById(R.id.favorito);
        ac_paises = (AutoCompleteTextView) findViewById(R.id.pais);

        texto = (TextView) findViewById(R.id.datos);
        boton = (Button) findViewById(R.id.mostrar);

        String[] paises  = getResources().getStringArray(R.array.paises);

        boton.setOnClickListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.hobbies, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hobbies.setAdapter(adapter);

        ArrayAdapter<String> adapterPaises = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, paises);
        ac_paises.setAdapter(adapterPaises);
        ac_paises.setThreshold(1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_mail, menu);
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
    public void onClick(View v) {
        if(v.getId()==R.id.mostrar){
            String genero = null;
            int sex = sexo.getCheckedRadioButtonId();
            switch (sex) {
                case R.id.Masculino:
                    genero = getString(R.string.masculino);
                    break;
                case R.id.Femenino:
                    genero = getString(R.string.femenino);
                    break;

            }

            String hobbie;
            int hobby = hobbies.getSelectedItemPosition();
            hobbie = hobbies.getItemAtPosition(hobby).toString();
            String mostrarTodo="";

            if(nombre.getText().toString().isEmpty()){
                mostrarTodo=getString(R.string.faltan_nombre);
                texto.setText(mostrarTodo);
                return;
            }
            if(apellido.getText().toString().isEmpty()){
                mostrarTodo=getString(R.string.faltan_apellido);
                texto.setText(mostrarTodo);
                return;
            }
            if(pais.getText().toString().isEmpty()){
                mostrarTodo=getString(R.string.faltan_pais);
                texto.setText(mostrarTodo);
                return;
            }
            if(telefono.getText().toString().isEmpty()){
                mostrarTodo=getString(R.string.faltan_telefono);
                texto.setText(mostrarTodo);
                return;
            }
            if(direccion.getText().toString().isEmpty()){
                mostrarTodo=getString(R.string.faltan_direccion);
                texto.setText(mostrarTodo);
                return;
            }
            if(email.getText().toString().isEmpty()){
                mostrarTodo=getString(R.string.faltan_email);
                texto.setText(mostrarTodo);
                return;
            }

            mostrarTodo = mostrarTodo +getString(R.string.nombre)+" "+ nombre.getText().toString() + "\n";
            mostrarTodo = mostrarTodo +getString(R.string.apellido)+" "+ apellido.getText().toString() + "\n";
            mostrarTodo = mostrarTodo +getString(R.string.sexo)+" "+ genero + "\n";
            mostrarTodo = mostrarTodo +getString(R.string.pais)+" "+ pais.getText().toString() + "\n";

            String day= Integer.toString(dp_fecha.getDayOfMonth());
            String month=Integer.toString(dp_fecha.getMonth()+1);
            String year=Integer.toString(dp_fecha.getYear());
            mostrarTodo = mostrarTodo +getString(R.string.fecha)+" "+ day +"/"+month+"/"+year + "\n";
            mostrarTodo = mostrarTodo +getString(R.string.telefono)+" "+ telefono.getText().toString() + "\n";
            mostrarTodo = mostrarTodo +getString(R.string.direccion)+" "+ direccion.getText().toString() + "\n";
            mostrarTodo = mostrarTodo +getString(R.string.email)+" "+ email.getText().toString() + "\n";
            mostrarTodo = mostrarTodo +getString(R.string.hobby)+" "+ hobbie + "\n";
            if(favorito.isChecked()){
                mostrarTodo = mostrarTodo + getString(R.string.si_favorito);
            }else{
                mostrarTodo = mostrarTodo + getString(R.string.no_favorito);
            }
            texto.setText(mostrarTodo);
        }
    }
}
