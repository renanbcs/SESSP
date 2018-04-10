package sessp.com.sessp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonFiltrar, buttonVerDados;
    private List<SESSP> listaSessp;
    private SESSP sessp;

    public void criaBase(){

        listaSessp = new ArrayList<>();

        //linha 2

        sessp = new SESSP("53221255001970","A.L.S.F. PROV. DEUS - MIRASSOL", "MIRASSOL","Associação","SÃO JOSÉ DO RIO PRETO",
                                "São José do Rio Preto","Evento Sta Casa","","Custeio",20000,20000,
                0,0,0,0,0,0,20000,20000,20000,0,
                        "01/07/2014","01/10/2014",20000,1);

        listaSessp.add(sessp);

        //linha 3

        sessp = new SESSP("53221255001970","A.L.S.F. PROV. DEUS - MIRASSOL", "MIRASSOL","Associação","SÃO JOSÉ DO RIO PRETO",
                "São José do Rio Preto","Subvenção","Construção Hospital Mun.","Investimento",0,1000000,
                0,0,0,0,0,0,1000000,1000000,1000000,0,
                "01/12/2013","01/01/2014",1000000,1);

        listaSessp.add(sessp);

        //linha 6

        sessp = new SESSP("53221255000221","A.L.S.F. PROV. DEUS - HOSP. N. SRA DA DIVINA PROV. DE JACI", "JACI","Associação","SÃO JOSÉ DO RIO PRETO",
                "São José do Rio Preto","Emendas","","Investimento",0,0,
                80000,0,0,80000,0,0,80000,80000,80000,0,
                "01/12/2015","01/03/2016",80000,1);

        listaSessp.add(sessp);

        //linha 12

        sessp = new SESSP("53221255001546","A.L.S.F. PROV. DEUS - HOSPITAL SÃO DOMINGOS", "NHANDEARA","Associação","SÃO JOSÉ DO RIO PRETO",
                "São José do Rio Preto","Continuidade","Neurologia","Custeio",60000,300000,
                54000,636000,54000,648000,54000,513000,1944000,54000,461700,
                1482300,
                "01/12/2016","01/10/2017",51300,36);

        listaSessp.add(sessp);

        //linha 17

        sessp = new SESSP("53221255003913","A.L.S.F. PROV. DEUS - LAR SÃO MIGUEL ARCANJO", "PIRAPOZINHO","Associação","PRESIDENTE PRUDENTE",
                "Presidente Prudente","Continuidade","Alcool e Drogas","Custeio",0,0,
                100000,400000,100000,1299995,100000,949997,3600000,100000,855000,
                2745000,
                "01/12/2016","01/10/2017",95000,36);

        listaSessp.add(sessp);

        //linha 62

        sessp = new SESSP("45193943000116","APAE - CAMPOS DO JORDÃO", "CAMPOS DO JORDÃO","APAE","TAUBATÉ",
                "São José dos Campos","Emendas","","Custeio",0,0,
                30000,0,0,30000,0,0,30000,30000,30000,0,
                "01/12/2015","01/04/2016",30000,1);

        listaSessp.add(sessp);

        //linha 74

        sessp = new SESSP("45316338000195","APAE - FRANCA", "FRANCA","APAE","FRANCA",
                "Franca","Emendas","","Investimento",0,150000,
                0,0,0,0,0,0,150000,150000,150000,0,
                "01/01/2014","01/02/2014",150000,1);

        listaSessp.add(sessp);

        //linha 358

        sessp = new SESSP("9161265000146","FAMAR - FUNDAÇÃO DE APOIO A FACULDADE DE MEDICINA DE MARILIA", "MARÍLIA","Fundação","MARÍLIA",
                "Marília","Rede Lucy Montoro","Marilia","Custeio",419740,3777662,
                377766,2014753,377766,3399894,377766,2871022,13599576,377766,
                2871022,10728554,
                "01/12/2016","01/09/2017",358878,36);

        listaSessp.add(sessp);

        //linha 391

        sessp = new SESSP("47969134000189","FUNDACAO CIVIL CASA DE MISERICORDIA DE FRANCA", "FRANCA","Santa Casa","FRANCA",
                "Franca","Sustentáveis","Estruturante","Custeio",2043360,18390237,
                1287317,15141298,2173915,19480075,2173915,18586973,443000,443000,
                420850,22150,
                "01/08/2017","01/09/2017",420850,36);

        listaSessp.add(sessp);

        //linha 419

        sessp = new SESSP("46746319000161","FUNDAÇÃO SANATÓRIO SÃO PAULO", "CAMPOS DO JORDÃO","Fundação","TAUBATÉ",
                "São José dos Campos","Pro Sta Casa","","Custeio",140000,980000,
                0,0,0,0,0,0,840000,140000,840000,0,
                "01/07/2014","01/12/2014",140000,12);

        listaSessp.add(sessp);

        //linha 446

        sessp = new SESSP("56577059000100","HC DA FMUSP HOSPITAL DAS CLINICAS DE SAO PAULO", "SÃO PAULO","Fundação","SÃO PAULO",
                "Grande São Paulo","Vigilância Epidemiológica NHE","","Custeio",0,0,
                77542,0,0,77542,0,0,77542,77542,77542,0,
                "01/12/2015","01/01/2016",77542,1);

        listaSessp.add(sessp);

        //linha 456

        sessp = new SESSP("56577059000100","HC DA FMUSP HOSPITAL DAS CLINICAS DE SAO PAULO", "SÃO PAULO","Fundação","SÃO PAULO",
                "Grande São Paulo","Subvenção","Fosfoetanolamina","Custeio",0,0,
                0,0,200000,600000,0,0,600000,200000,600000,0,
                "01/06/2016","01/10/2016",180000,3);

        listaSessp.add(sessp);

        //linha 481

        sessp = new SESSP("43138320000115","HOSPITAL AGUDOS", "AGUDOS","Hospital","BAURU",
                "Bauru","Evento Sta Casa","","Custeio",31605,31605,
                0,0,0,0,0,0,31605,31605,
                31605,0,
                "01/06/2014","01/07/2014",31605,1);

        listaSessp.add(sessp);

        //linha 484

        sessp = new SESSP("43138320000115","HOSPITAL AGUDOS", "AGUDOS","Hospital","BAURU",
                "Bauru","Emendas","Custeio PS","Custeio",0,0,
                0,0,100000,0,0,100000,100000,100000,
                100000,0,
                "01/12/2016","01/02/2017",100000,1);

        listaSessp.add(sessp);

        //linha 619

        sessp = new SESSP("62932942000165","IBCC", "SÃO PAULO","Hospital","SÃO PAULO",
                "Grande São Paulo","Subvenção","Oncologia-IBCC","Custeio",500000,
                2000000,
                0,1000000,0,0,0,0,3000000,500000,
                3000000,0,
                "01/07/2014","01/02/2015",500000,6);

        listaSessp.add(sessp);

        //linha 631

        sessp = new SESSP("60945854000172","INSTITUTO DO CANCER ARNALDO VIEIRA DE CARVALHO - ICAVC", "SÃO PAULO","Hospital","SÃO PAULO",
                "Grande São Paulo","Emendas","","Investimento",0,100000,
                0,0,0,0,0,0,100000,100000,
                100000,0,
                "01/01/2014","01/01/2014",100000,1);

        listaSessp.add(sessp);

        //linha 656

        sessp = new SESSP("67187070000171","INSTITUTO PAULISTA DE OFTALMOLOGIA", "SÃO PAULO","Outras Entidades","SÃO PAULO",
                "Grande São Paulo","Continuidade","Oftalmologia-multimodal","Custeio",
                267518,2773801,
                273203,3360691,284965,3247655,296540,2043956,
                3558479,296540,1953531,1604948,
                "01/01/2017","01/09/2017",66839,12);

        listaSessp.add(sessp);

        //linha 707

        sessp = new SESSP("43206424000110","PREFEITURA - ÁLVARES MACHADO", "ÁLVARES MACHADO","Prefeitura","PRESIDENTE PRUDENTE",
                "Presidente Prudente","Emendas","","Investimento",40000,40000,
                0,0,0,0,0,0,40000,40000,40000,0,
                "01/06/2014","01/07/2014",40000,1);

        listaSessp.add(sessp);

        //linha 856

        sessp = new SESSP("57264517000105","PREFEITURA - CANITAR", "CANITAR","Prefeitura","MARÍLIA",
                "Marília","Governador","Ambulância","Investimento",0,0,
                83900,0,0,0,0,83900,83900,83900,83900,0,
                "01/03/2016","01/01/2017",83900,1);

        listaSessp.add(sessp);

        //linha 941

        sessp = new SESSP("47826763000150","PREFEITURA - FERNANDO PRESTES", "FERNANDO PRESTES","Prefeitura","SÃO JOSÉ DO RIO PRETO",
                "Central","Emendas","","Investimento",100000,175000,
                0,0,0,0,0,0,60000,60000,60000,0,
                "01/06/2014","01/07/2014",60000,1);

        listaSessp.add(sessp);

        //linha 1002

        sessp = new SESSP("45355575000165","PREFEITURA - IBATE", "IBATE","Prefeitura","ARARAQUARA",
                "Central","Emendas","","Custeio",0,50000,
                0,0,0,0,0,0,50000,50000,50000,0,
                "01/11/2013","01/02/2014",50000,1);

        listaSessp.add(sessp);

        //linha 1189

        sessp = new SESSP("46578506000183","PREFEITURA - MONGAGUÁ", "MONGAGUÁ","Prefeitura","BAIXADA SANTISTA",
                "Santos","Subvenção","Reforma UBS Jussara","Investimento",210000,210000,
                0,0,0,0,0,0,210000,210000,210000,0,
                "01/07/2014","01/07/2014",210000,1);

        listaSessp.add(sessp);

        //linha 1223

        sessp = new SESSP("46754388000117","PREFEITURA - NUPORANGA", "NUPORANGA","Prefeitura","FRANCA",
                "Franca","Governador","","Investimento",0,200000,
                0,0,0,0,0,0,200000,200000,200000,0,
                "01/12/2013","01/02/2014",200000,1);

        listaSessp.add(sessp);

        //linha 1317

        sessp = new SESSP("48664296000171","PREFEITURA - PRADOPOLIS", "PRADOPOLIS","Prefeitura","RIBERÃO PRETO",
                "Ribeirão Preto","Emendas","Ambulância","Investimento",0,0,
                0,0,100000,0,0,100000,100000,100000,100000,0,
                "01/12/2016","01/08/2017",100000,1);

        listaSessp.add(sessp);

        //linha 1379

        sessp = new SESSP("46477618000148","PREFEITURA - SALMOURÃO", "SALMOURÃO","Prefeitura","MARÍLIA",
                "Presidente Prudente","Governador","Mobiliários e Equipamento","Investimento",0,0,
                0,0,80000,80000,0,0,80000,80000,80000,0,
                "01/02/2016","01/07/2016",80000,1);

        listaSessp.add(sessp);

        //linha 1484

        sessp = new SESSP("46634044000174","PREFEITURA - SOROCABA", "SOROCABA","Prefeitura","SOROCABA",
                "Sorocaba","Pro Sta Casa","","Custeio",0,0,
                113400,0,113400,1360800,0,0,1360800,113400,1360800,
                0,
                "01/01/2016","01/12/2016",113400,12);

        listaSessp.add(sessp);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        criaBase();

        buttonFiltrar = (Button) findViewById(R.id.buttonFiltrar);
        buttonVerDados = (Button) findViewById(R.id.buttonVerDados);


        buttonFiltrar.setOnClickListener(this);
        buttonVerDados.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.buttonFiltrar:

                Intent intent = new Intent(this,CnpjActivity.class);
                intent.putExtra("lista", (Serializable) listaSessp);
                startActivity(intent);

            break;

            case R.id.buttonVerDados:

                Intent i = new Intent(this,ResultadoActivity.class);
                i.putExtra("lista", (Serializable) listaSessp);
                startActivity(i);

                break;


        }



    }
}
