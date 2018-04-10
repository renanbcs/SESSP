package sessp.com.sessp1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class Adaptador extends BaseAdapter {

    private Context ctx;
    private String[] lista;

    public Adaptador(Context ctx,String[] lista) {

        this.lista=lista;
        this.ctx=ctx;
    }

    @Override
    public int getCount() {
        return lista.length;
    }

    @Override
    public Object getItem(int i) {
        return lista[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        TextView tv = new TextView(ctx);
        tv.setText(lista[i]);
        tv.setHeight(100);
        tv.setWidth(50);


        return tv;
    }
}
