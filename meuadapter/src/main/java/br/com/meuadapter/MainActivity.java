package br.com.meuadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listViewOnibus;
    List<Onibus> onibusList;
    EditText editmarca,editmodelo,editorigem,edittipo,editqntdacentos,editqntdacentosocupados;
    ArrayAdapter<String> adapter;
    OnibusAdapter adapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewOnibus = findViewById(R.id.listViewOnibus);
        editmarca = findViewById(R.id.textMarca);
        editmodelo = findViewById(R.id.textModelo);
        editorigem = findViewById(R.id.textOrigemDestino);
        edittipo = findViewById(R.id.textTipo);
        editqntdacentos = findViewById(R.id.textQntdAcentos);
        editqntdacentosocupados = findViewById(R.id.textQntdacentosOcupados);
        onibusList =new ArrayList<>();


        listViewOnibus.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Onibus onibus  = (Onibus)adapterView.getItemAtPosition(i);
                String info = "Onibus modelo: " + onibus.getModelo() + " ";
                info += "tem :"+onibus.getQntdAcentosOcupados() +" acentos ocupados";

                int total = Integer.parseInt(onibus.getQntdAcentos());
                int ocupado = Integer.parseInt(onibus.getQntdAcentosOcupados());

                if(ocupado < total){
                    ocupado +=1;
                    onibus.setQntdAcentosOcupados(String.valueOf(ocupado));
                    adapter2.notifyDataSetChanged();

                }else{
                    Toast.makeText(MainActivity.this, "este veiculo nao possui acentos disponiveis", Toast.LENGTH_SHORT).show();

                }

                    //Toast.makeText(MainActivity.this, info, Toast.LENGTH_SHORT).show();
            }
        });


    }
    public void novoOnibus(View view) {
        String marca = editmarca.getText().toString();
        String modelo = editmodelo.getText().toString();
        String origem = editorigem.getText().toString();
        String tipo = edittipo.getText().toString();
        String qntdacentos = editqntdacentos.getText().toString();
        String ocupados = editqntdacentosocupados.getText().toString();
        if (Integer.parseInt(qntdacentos) < Integer.parseInt(ocupados)){

            String info = "erro ao salva quantidade de acentos ocupados excede o total de acentos do veiculo";
            Toast.makeText(MainActivity.this, info, Toast.LENGTH_SHORT).show();

        }else {
            editmarca.setText("");
            editmodelo.setText("");
            editorigem.setText("");
            edittipo.setText("");
            editqntdacentos.setText("");
            editqntdacentosocupados.setText("");
            Onibus onibus = new Onibus(marca, modelo, origem, tipo, qntdacentos, ocupados);
            onibusList.add(onibus);
            adapter2.notifyDataSetChanged();
        }

    }
    @Override
    protected void onStart(){
        super.onStart();
        onibusList.add(new Onibus("volvo","VOLARE W9 ON","curitiba/bahia","leito","30","29"));
        onibusList.add(new Onibus("volvo","VOLARE W8","curitiba/bahia","leito","30","30"));
        onibusList.add(new Onibus("volvo","NEOBUS THUNDER","bahia/curitiba","comum","30","15"));
        preencherOnibusList();
    }

    private void preencherOnibusList() {
        int layoutId = R.layout.onibus_list_item;
         adapter2 = new OnibusAdapter(this,layoutId,onibusList);

        listViewOnibus.setAdapter(adapter2);
    }


}
