package sessp.com.sessp1;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
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

public class CnpjActivity extends AppCompatActivity implements View.OnClickListener {

    private List<String> listaCnpj;
    private ListView listViewCnpj;
    private List<SESSP> listaSessp,listaEnviar;
    private AlertDialog.Builder alerta;
    private Button buttonProximoCnpj,buttonBuscarCnpj,buttonAplicarCnpj;
    private SESSP sessp;
    private EditText editTextCnpj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cnpj);

        //oculta o teclado ao abrir a tela
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        //inicia objetos
        listViewCnpj = (ListView) findViewById(R.id.listViewCnpj);
        buttonProximoCnpj = (Button) findViewById(R.id.buttonProximoCnpj);
        buttonBuscarCnpj = (Button) findViewById(R.id.buttonBuscarCnpj);
        buttonAplicarCnpj = findViewById(R.id.buttonAplicarCnpj);
        editTextCnpj = (EditText) findViewById(R.id.editTextCnpj);
        sessp = new SESSP();


        //intent

        Intent intent = getIntent();

        //pega valores da outra activity
        listaSessp = (List<SESSP>) intent.getSerializableExtra("lista");

        //montalista
        montaLista(listaSessp);

        //adapta lista para ser mostrada no listview
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaCnpj);

        listViewCnpj.setAdapter(adapter);


        //ação ao clicar na lista
        listViewCnpj.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                sessp.setCnpj(listViewCnpj.getItemAtPosition(i).toString());

            }
        });


        //ação aos botoes
        buttonProximoCnpj.setOnClickListener(this);
        buttonBuscarCnpj.setOnClickListener(this);
        buttonAplicarCnpj.setOnClickListener(this);


    }


    //metodo que monta a lista de cnpjs a serem exibidos
    public void montaLista(List<SESSP> lista){

        listaCnpj = new ArrayList<>();

        Set<String> set = new HashSet<>();

        for (int a = 0; a<lista.size();a++){

            listaCnpj.add(lista.get(a).getCnpj());

        }

        set.addAll(listaCnpj);

        listaCnpj = new ArrayList<>(set);
    }

    //busca na lista
    public List<String> buscarLista(String buscar){

        List<String> lista = new ArrayList<>();


        for (String cnpj : listaCnpj){

            if (cnpj.contains(buscar)) {
                lista.add(cnpj);
            }

        }
        return  lista;
    }


    //metodo de ação aos botoes
    @Override
    public void onClick(View view) {

        switch (view.getId()){

            //ação para o botao proximo
            case R.id.buttonProximoCnpj:

                //cria alerta para confirmar CNPJ
                alerta = new AlertDialog.Builder(this);

                //titulo
                alerta.setTitle(R.string.tituloalerta);

                //Messagem se selecionou algo ou nenhum e que cria lista  já filtrada para envia a outra ativity
                if(sessp.getCnpj()!=null) {

                    alerta.setMessage(this.getString(R.string.cnpjmensagem) + sessp.getCnpj() + "\n" + this.getString(R.string.prosseguir));

                    listaEnviar = new ArrayList<>();

                    for (int a = 0; a<listaSessp.size();a++){

                        if(listaSessp.get(a).getCnpj().equals(sessp.getCnpj())){

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
                        Intent intent = new Intent(getApplicationContext(),ConveniadoActivity.class);
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

            case R.id.buttonBuscarCnpj:



                sessp.setCnpj(null);

                List<String> resultado =  buscarLista(editTextCnpj.getText().toString());

                if(resultado.size()<=0){

                    Toast.makeText(this,this.getString(R.string.naoencontrado),Toast.LENGTH_SHORT).show();

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaCnpj);

                    listViewCnpj.setAdapter(adapter);

                }else {

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, resultado);

                    listViewCnpj.setAdapter(adapter);
                }

                break;

            case R.id.buttonAplicarCnpj:

                //Toast.makeText(getApplicationContext(),"oi",Toast.LENGTH_SHORT).show();

                //cria alerta para confirmar CNPJ
                alerta = new AlertDialog.Builder(this);

                //titulo
                alerta.setTitle(R.string.tituloalerta);

                //Messagem se selecionou algo ou nenhum e que cria lista  já filtrada para envia a outra ativity
                if(sessp.getCnpj()!=null) {

                    alerta.setMessage(this.getString(R.string.cnpjmensagem) + sessp.getCnpj() + "\n" + this.getString(R.string.aplicarmensagem));

                    listaEnviar = new ArrayList<>();

                    for (int a = 0; a<listaSessp.size();a++){

                        if(listaSessp.get(a).getCnpj().equals(sessp.getCnpj())){

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


        }//fim switch

    }//fim onClick
}//fim classe