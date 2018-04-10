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

public class PalavraChaveActivity extends AppCompatActivity implements View.OnClickListener {

    private List<String> listaPalavraChave;
    private ListView listViewPalavraChave;
    private List<SESSP> listaSessp,listaEnviar;
    private AlertDialog.Builder alerta;
    private Button buttonProximoPalavraChave,buttonBuscarPalavraChave,buttonAplicarPalavraChave;
    private SESSP sessp;
    private EditText editTextPalavraChave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palavra_chave);

        //oculta o teclado ao abrir a tela
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //inicia objetos
        listViewPalavraChave = (ListView) findViewById(R.id.listViewPalavraChave);
        buttonProximoPalavraChave = (Button) findViewById(R.id.buttonProximoPalavraChave);
        buttonBuscarPalavraChave = (Button) findViewById(R.id.buttonBuscarPalavraChave);
        buttonAplicarPalavraChave = findViewById(R.id.buttonAplicarPalavraChave);
        editTextPalavraChave = (EditText) findViewById(R.id.editTextPalavraChave);

        //intent

        Intent intent = getIntent();

        //pega valores da outra activity
        listaSessp = (List<SESSP>) intent.getSerializableExtra("lista");
        sessp = (SESSP) intent.getSerializableExtra("sessp");

        montaLista(listaSessp);


        if(listaPalavraChave.size()<=0){

            Toast.makeText(this,"Não há resultados",Toast.LENGTH_SHORT).show();
        }

        //adapta lista para ser mostrada no listview
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaPalavraChave);

        listViewPalavraChave.setAdapter(adapter);

        //ação ao clicar na lista
        listViewPalavraChave.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                sessp.setPalavraChave(listViewPalavraChave.getItemAtPosition(i).toString());

            }
        });

        //ação aos botoes
        buttonProximoPalavraChave.setOnClickListener(this);
        buttonBuscarPalavraChave.setOnClickListener(this);
        buttonAplicarPalavraChave.setOnClickListener(this);


    }

    public void montaLista(List<SESSP> lista){

        listaPalavraChave = new ArrayList<>();

        Set<String> set = new HashSet<>();

        for (int a = 0; a<lista.size();a++){

            if(!lista.get(a).getPalavraChave().equals(""))
            listaPalavraChave.add(lista.get(a).getPalavraChave());

        }

        set.addAll(listaPalavraChave);

        listaPalavraChave = new ArrayList<>(set);

    }

    //busca na lista
    public List<String> buscarLista(String buscar){

        List<String> lista = new ArrayList<>();

        int a = 0;
        for (String palavraChave : listaPalavraChave){

            if (palavraChave.contains(buscar)) {
                lista.add(palavraChave);
            }
            a++;
        }
        return  lista;
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.buttonBuscarPalavraChave:

                sessp.setPalavraChave(null);

                List<String> resultado =  buscarLista(editTextPalavraChave.getText().toString());

                if(resultado.size()<=0){

                    Toast.makeText(this,this.getString(R.string.naoencontrado),Toast.LENGTH_SHORT).show();

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaPalavraChave);

                    listViewPalavraChave.setAdapter(adapter);

                }else {

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, resultado);

                    listViewPalavraChave.setAdapter(adapter);
                }

                break;


            case R.id.buttonProximoPalavraChave:

                //cria alerta para confirmar CNPJ
                alerta = new AlertDialog.Builder(this);

                //titulo
                alerta.setTitle(R.string.tituloalerta);

                //Messagem se selecionou algo ou nenhum e que cria lista  já filtrada para envia a outra ativity
                if(sessp.getPalavraChave()!=null) {

                    alerta.setMessage(this.getString(R.string.palavrachavemensagem) + sessp.getPalavraChave() + "\n" + this.getString(R.string.prosseguir));

                    listaEnviar = new ArrayList<>();

                    for (int a = 0; a<listaSessp.size();a++){

                        if(listaSessp.get(a).getPalavraChave().equals(sessp.getPalavraChave())){

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
                        Intent intent = new Intent(getApplicationContext(),NaturezaActivity.class);
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

            case R.id.buttonAplicarPalavraChave:

                //cria alerta para confirmar CNPJ
                alerta = new AlertDialog.Builder(this);

                //titulo
                alerta.setTitle(R.string.tituloalerta);

                //Messagem se selecionou algo ou nenhum e que cria lista  já filtrada para envia a outra ativity
                if(sessp.getPalavraChave()!=null) {

                    alerta.setMessage(this.getString(R.string.palavrachavemensagem) + sessp.getPalavraChave() + "\n" + this.getString(R.string.aplicarmensagem));

                    listaEnviar = new ArrayList<>();

                    for (int a = 0; a<listaSessp.size();a++){

                        if(listaSessp.get(a).getPalavraChave().equals(sessp.getPalavraChave())){

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
