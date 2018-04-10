package sessp.com.sessp1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class PlaceholderFragment extends Fragment {


    private static final String ARG_SECTION_NUMBER = "section_number";
    private List<SESSP> lista;

    public PlaceholderFragment() {


    }

    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View rootView = inflater.inflate(R.layout.fragment_resultado, container, false);

        Intent i = getActivity().getIntent();

        lista = (List<SESSP>) i.getSerializableExtra("lista");

        TextView textView = rootView.findViewById(R.id.textView1);
        TextView textView2 = rootView.findViewById(R.id.textView2);

        GridView gridView = rootView.findViewById(R.id.gridViewResultado);


        switch (getArguments().getInt(ARG_SECTION_NUMBER)){

            case 1:

                textView.setText("CNPJ");
                textView2.setText("Conveniado");

                String lista1 [] =new String[lista.size()*2];

                    int b = 0;
                    for(int a =0 ;a<lista1.length;a++){

                            lista1[a]= (b+1)+ "- " + lista.get(b).getCnpj();
                            a++;
                            lista1[a]= lista.get(b).getConveniado();
                            b++;
                        }

                        gridView.setAdapter(new Adaptador(getContext(),lista1));
                break;

                case 2:


                    textView.setText("Município");
                    textView2.setText("Tipo");


                    String lista2 [] =new String[lista.size()*2];

                    b = 0;
                    for(int a =0 ;a<lista2.length;a++){

                        lista2[a]= (b+1)+ "- " + lista.get(b).getMunicipio();
                        a++;
                        lista2[a]= lista.get(b).getTipo();
                        b++;
                    }

                    gridView.setAdapter(new Adaptador(getContext(),lista2));

                    break;

                case 3:

                    textView.setText("DRS");
                    textView2.setText("Região Administrativa");


                    String lista3 [] =new String[lista.size()*2];

                    b = 0;
                    for(int a =0 ;a<lista3.length;a++){

                        lista3[a]= (b+1)+ "- " + lista.get(b).getDrs();
                        a++;
                        lista3[a]= lista.get(b).getRegiaoAdm();
                        b++;
                    }

                    gridView.setAdapter(new Adaptador(getContext(),lista3));

                    break;

                case 4:

                    textView.setText("Programa");
                    textView2.setText("Palavra Chave");

                    String lista4 [] =new String[lista.size()*2];

                    b = 0;
                    for(int a =0 ;a<lista4.length;a++){

                        lista4[a]= (b+1)+ "- " + lista.get(b).getPrograma();
                        a++;
                        lista4[a]= lista.get(b).getPalavraChave();
                        b++;
                    }

                    gridView.setAdapter(new Adaptador(getContext(),lista4));

                    break;

                case 5:

                    textView.setText("Natureza");
                    textView2.setText("");

                    String lista5 [] =new String[lista.size()];

                    b = 0;
                    for(int a =0 ;a<lista5.length;a++){

                        lista5[a]= (b+1)+ "- " + lista.get(b).getNatureza();
                        b++;
                    }
                    gridView.setNumColumns(1);

                    gridView.setAdapter(new Adaptador(getContext(),lista5));

                    break;


                case 6:

                    textView.setText("Base 2014");
                    textView2.setText("Pago 2014");

                    String lista6 [] =new String[lista.size()*2];

                    b = 0;
                    for(int a =0 ;a<lista6.length;a++){

                        lista6[a]= (b+1)+ "- " + lista.get(b).getBase2014();
                        a++;
                        lista6[a]= ""+lista.get(b).getPago2014();
                        b++;
                    }

                    gridView.setAdapter(new Adaptador(getContext(),lista6));

                    break;

                case 7:

                    textView.setText("Base 2015");
                    textView2.setText("Pago 2015");


                    String lista7 [] =new String[lista.size()*2];

                    b = 0;
                    for(int a =0 ;a<lista7.length;a++){

                        lista7[a]= (b+1)+ "- " + lista.get(b).getBase2015();
                        a++;
                        lista7[a]=""+ lista.get(b).getPago2015();
                        b++;
                    }

                    gridView.setAdapter(new Adaptador(getContext(),lista7));

                    break;

                case 8:

                    textView.setText("Base 2016");
                    textView2.setText("Pago 2016");

                    String lista8 [] =new String[lista.size()*2];

                    b = 0;
                    for(int a =0 ;a<lista8.length;a++){

                        lista8[a]= (b+1)+ "- " + lista.get(b).getBase2016();
                        a++;
                        lista8[a]= ""+lista.get(b).getPago2016();
                        b++;
                    }

                    gridView.setAdapter(new Adaptador(getContext(),lista8));

                    break;

                case 9:

                    textView.setText("Base 2017");
                    textView2.setText("Pago 2017");

                    String lista9 [] = new String[lista.size()*2];

                    b = 0;
                    for(int a =0 ;a<lista9.length;a++){

                        lista9[a]= (b+1)+ "- " + lista.get(b).getBase2017();
                        a++;
                        lista9[a]="" + lista.get(b).getPago2017();
                        b++;
                    }

                    gridView.setAdapter(new Adaptador(getContext(),lista9));

                    break;

                case 10:

                    textView.setText("Valor último convênio em execução");
                    textView2.setText("Base mensal último convênio em execução");


                    String lista10 [] =new String[lista.size()*2];

                    b = 0;
                    for(int a =0 ;a<lista10.length;a++){

                        lista10[a]= (b+1)+ "- " + lista.get(b).getValorUltimoConvenio();
                        a++;
                        lista10[a]= ""+lista.get(b).getBaseMensal();
                        b++;
                    }

                    gridView.setAdapter(new Adaptador(getContext(),lista10));

                    break;

            case 11:

                textView.setText("Pago último convênio em execução");
                textView2.setText("Pagar último convênio em execução");

                String lista11 [] =new String[lista.size()*2];

                b = 0;
                for(int a =0 ;a<lista11.length;a++){

                    lista11[a]= (b+1)+ "- " + lista.get(b).getPagarUltimoConvenio();
                    a++;
                    lista11[a]= ""+lista.get(b).getPagarUltimoConvenio();
                    b++;
                }

                gridView.setAdapter(new Adaptador(getContext(),lista11));


                break;

            case 12:

                textView.setText("Mês/Ano publicação último convênio em execução");
                textView2.setText("Data último pagamento");

                String lista12 [] =new String[lista.size()*2];

                b = 0;
                for(int a =0 ;a<lista12.length;a++){

                    lista12[a]= (b+1)+ "- " + lista.get(b).getDataUltimoConvenio();
                    a++;
                    lista12[a]= ""+lista.get(b).getDataUltimoPagamento();
                    b++;
                }

                gridView.setAdapter(new Adaptador(getContext(),lista12));


                break;

            case 13:

                textView.setText("Valor último pagamento");
                textView2.setText("Parcelas último convênio em execução");

                String lista13 [] =new String[lista.size()*2];

                b = 0;
                for(int a =0 ;a<lista13.length;a++){

                    lista13[a]= (b+1)+ "- " + lista.get(b).getValorUltimoPagamento();
                    a++;
                    lista13[a]= ""+lista.get(b).getParcelasUltimoConvenio();
                    b++;
                }

                gridView.setAdapter(new Adaptador(getContext(),lista13));


                break;

        }

        return rootView;
    }
}
