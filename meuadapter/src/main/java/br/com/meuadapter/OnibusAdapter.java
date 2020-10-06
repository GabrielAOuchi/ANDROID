package br.com.meuadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class OnibusAdapter extends ArrayAdapter<Onibus> {


    int rId;

    public OnibusAdapter( Context context, int resource, List<Onibus> objects) {
        super(context, resource, objects);
        rId = resource;
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        View mView = convertView;
        if(mView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(rId,null);
        }

        Onibus onibus = getItem(position);// recupera o objeto na posiçao
        //recupera todos os atributos  do objeto
        TextView textMarca = mView.findViewById(R.id.textMarca);
        TextView textModelo = mView.findViewById(R.id.textModelo);
        TextView textOrigem = mView.findViewById(R.id.textOrigem);
        TextView textTipo = mView.findViewById(R.id.textTipo);
        TextView textQntdAcentos = mView.findViewById(R.id.textQntdacentos);
        TextView textQntdAcentosOcupados = mView.findViewById(R.id.textQntdacentosOcupados);

        textMarca.setText(onibus.getMarca());
        textModelo.setText(onibus.getModelo());
        textOrigem.setText(onibus.getOrigemDestino());
        textTipo.setText(onibus.getTipo());
        textQntdAcentos.setText(onibus.getQntdAcentos());
        textQntdAcentosOcupados.setText(onibus.getQntdAcentosOcupados());
        int ocupados = Integer.parseInt(onibus.getQntdAcentosOcupados());
        int total = Integer.parseInt(onibus.getQntdAcentos());
        if(ocupados == total  ){
            textQntdAcentos.setTextColor(getContext().getResources().getColor(R.color.acentos_ocupados));
        }else{
            textQntdAcentos.setTextColor(getContext().getResources().getColor(R.color.acentos_vagos));
        }

        return mView;
    }
}
