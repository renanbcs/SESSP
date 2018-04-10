package sessp.com.sessp1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProgramaActivity extends AppCompatActivity implements View.OnClickListener {

    private List<String> listaPrograma;
    private ListView listViewPrograma;
    private List<SESSP> listaSessp,listaEnviar;
    private AlertDialog.Builder alerta;
    private Button buttonProximoPrograma,buttonBuscarPrograma,buttonAplicarPrograma;
    private SESSP sessp;
    private EditText editTextPrograma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programa);

        //oculta o teclado ao abrir a tela
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //inicia objetos
        listViewPrograma = (ListView) findViewById(R.id.listViewPrograma);
        buttonProximoPrograma = (Button) findViewById(R.id.buttonProximoPrograma);
        buttonBuscarPrograma = (Button) findViewById(R.id.buttonBuscarPrograma);
        buttonAplicarPrograma = findViewById(R.id.buttonAplicarPrograma);
        editTextPrograma = (EditText) findViewById(R.id.editTextPrograma);

        //intent

        Intent intent = getIntent();

        //pega valores da outra activity
        listaSessp = (List<SESSP>) intent.getSerializableExtra("lista");
        sessp = (SESSP) intent.getSerializableExtra("sessp");

        montaLista(listaSessp);


        //adapta lista para ser mostrada no listview
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaPrograma);

        listViewPrograma.setAdapter(adapter);

        //ação ao clicar na lista
        listViewPrograma.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                sessp.setPrograma(listViewPrograma.getItemAtPosition(i).toString());

            }
        });

        //ação aos botoes
        buttonProximoPrograma.setOnClickListener(this);
        buttonBuscarPrograma.setOnClickListener(this);
        buttonAplicarPrograma.setOnClickListener(this);
    }

    public void montaLista(List<SESSP> lista){

        listaPrograma = new ArrayList<>();

        Set<String> set = new HashSet<>();

        for (int a = 0; a<lista.size();a++){

            listaPrograma.add(lista.get(a).getPrograma());

        }

        set.addAll(listaPrograma);

        listaPrograma = new ArrayList<>(set);

    }

    //busca na lista
    public List<String> buscarLista(String buscar){

        List<String> lista = new ArrayList<>();

        int a = 0;
        for (String programa : listaPrograma){

            if (programa.contains(buscar)) {
                lista.add(programa);
            }
            a++;
        }
        return  lista;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.buttonBuscarPrograma:

                sessp.setPrograma(null);

                List<String> resultado =  buscarLista(editTextPrograma.getText().toString());

                if(resultado.size()<=0){

                    Toast.makeText(this,this.getString(R.string.naoencontrado),Toast.LENGTH_SHORT).show();

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaPrograma);

                    listViewPrograma.setAdapter(adapter);

                }else {

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, resultado);

                    listViewPrograma.setAdapter(adapter);
                }

                break;


            case R.id.buttonProximoPrograma:

                //cria alerta para confirmar CNPJ
                alerta = new AlertDialog.Builder(this);

                //titulo
                alerta.setTitle(R.string.tituloalerta);

                //Messagem se selecionou algo ou nenhum e que cria lista  já filtrada para envia a outra ativity
                if(sessp.getPrograma()!=null) {

                    alerta.setMessage(this.getString(R.string.programamensagem) + sessp.getPrograma() + "\n" + this.getString(R.string.prosseguir));

                    listaEnviar = new ArrayList<>();

                    for (int a = 0; a<listaSessp.size();a++){

                        if(listaSessp.get(a).getPrograma().equals(sessp.getPrograma())){

                            listaEnviar.add(listaSessp.get(a));

                        }

                    }

                }else {

                    alerta.setMessage(this.getString(R.string.nenhumSelecionado) + "\n" + this.getString(R.string.prosseguir));
                    listaEnviar = listaSessp;

                }


                //ação do botão negativo
                /*alerta.setNegativeButton(R.string.nao, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {



                    }
                });*/

                //ação botão posiitivo
                alerta.setPositiveButton(R.string.sim, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        //envia para outra activity
                        Intent intent = new Intent(getApplicationContext(),PalavraChaveActivity.class);
                        intent.putExtra("sessp",sessp);
                        intent.putExtra("lista", (Serializable) listaEnviar);
                        startActivity(intent);

                    }
                });

                //Fazer dela modal ou nao alerta.setCancelable(true);

                //cria alerta e mostra
                alerta.create();
                alerta.show();

                break;

            case R.id.buttonAplicarPrograma:

                //cria alerta para confirmar CNPJ
                alerta = new AlertDialog.Builder(this);

                //titulo
                alerta.setTitle(R.string.tituloalerta);

                //Messagem se selecionou algo ou nenhum e que cria lista  já filtrada para envia a outra ativity
                if(sessp.getPrograma()!=null) {

                    alerta.setMessage(this.getString(R.string.programamensagem) + sessp.getPrograma() + "\n" + this.getString(R.string.aplicarmensagem));

                    listaEnviar = new ArrayList<>();

                    for (int a = 0; a<listaSessp.size();a++){

                        if(listaSessp.get(a).getPrograma().equals(sessp.getPrograma())){

                            listaEnviar.add(listaSessp.get(a));

                        }

                    }

                }else {

                    alerta.setMessage(this.getString(R.string.nenhumSelecionado) + "\n" + this.getString(R.string.prosseguir));
                    listaEnviar = listaSessp;

                }


                //ação do botão negativo
                /*alerta.setNegativeButton(R.string.nao, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {



                    }
                });*/

                //ação botão posiitivo
                alerta.setPositiveButton(R.string.sim, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        //envia para outra activity
                        Intent intent = new Intent(getApplicationContext(),ResultadoActivity.class);
                        intent.putExtra("sessp",sessp);
                        intent.putExtra("lista", (Serializable) listaEnviar);
                        startActivity(intent);

                    }
                });

                //Fazer dela modal ou nao alerta.setCancelable(true);

                //cria alerta e mostra
                alerta.create();
                alerta.show();

                break;
        }


    }


}
