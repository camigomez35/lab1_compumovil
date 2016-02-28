package co.edu.udea.compumovil.gr12.lab1ui;

import android.os.Bundle;
import android.support.annotation.StringDef;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText nombre, apellido, pais, telefono, direccion, email;
    RadioGroup sexo;
    Spinner hobbies;
    CheckBox favorito;
    TextView texto;
    Button boton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nombre = (EditText) findViewById(R.id.Nombre);
        apellido = (EditText) findViewById(R.id.Apellido);

        sexo = (RadioGroup) findViewById(R.id.Sexo);

        pais = (EditText) findViewById(R.id.pais);
        telefono = (EditText) findViewById(R.id.telefono);
        direccion = (EditText) findViewById(R.id.direccion);
        email = (EditText) findViewById(R.id.email);

        hobbies = (Spinner) findViewById(R.id.hobbies);
        favorito = (CheckBox) findViewById(R.id.favorito);

        texto = (TextView) findViewById(R.id.datos);
        boton = (Button) findViewById(R.id.mostrar);

        boton.setOnClickListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hobbies.setAdapter(adapter);
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
            String date = "Nombre: " + nombre.getText().toString() + "\n";
            date = date +"Apellido: "+ apellido.getText().toString() + "\n";

            date = date +"Pais: "+ pais.getText().toString() + "\n";
            date = date +"Telefono: "+ telefono.getText().toString() + "\n";
            date = date +"Dirección: "+ direccion.getText().toString() + "\n";
            date = date +"E-mail: "+ email.getText().toString() + "\n";
            if(favorito.isChecked()){
                date = date + "Contacto marcado como favorito";
            }else{
                date = date + "Contacto No marcado como favorito";
            }
            texto.setText(date);
        }
    }
}
