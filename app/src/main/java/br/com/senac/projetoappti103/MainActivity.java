package br.com.senac.projetoappti103;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Declarar as variaveis globais referenciando os componentes
    ListView lstFilmes;
    //criando os dados para a lista
    String titulo[] = {"jokerrr","contractor","after","alerquina","ghostuster","john","jumanji",
            "legally","moonfall","spider"};

    String ano[] = {"2019","2022","2021","2019","2020","2020","2014","2020","2001","2022","2019"};

    String classificacao[] = {"18 anos ou mais","18 anos ou mais","16 anos ou mais",
            "18 anos ou mais", "13 anos ou mais","18 anos ou mais","13 anos ou mais",
            "13 anos ou mais","13 anos ou mais","13 anos ou mais"};

    int imgFilmes[] = {R.drawable.jokerrr,R.drawable.contractor,R.drawable.after,
            R.drawable.alerquina,R.drawable.ghostuster,R.drawable.john,R.drawable.jumanji,
            R.drawable.legally,R.drawable.moonfall,R.drawable.spider};

    String notas[] = {"18.833","12","202","7.942","845","10.916","9.237","930","420","43"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstFilmes = findViewById(R.id.listaFilmes);

        //instanciar o adaptador
        MyAdapter adapter = new MyAdapter();

        lstFilmes.setAdapter(adapter);

        lstFilmes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //abrindo outra janela e passando os valores
                Intent intent = new Intent(getApplicationContext(),MostrarFilmesActivity.class);

                intent.putExtra("titulo",titulo[position]);
                intent.putExtra("ano",ano[position]);
                intent.putExtra("classificacao",classificacao[position]);
                intent.putExtra("notas",notas[position]);
                intent.putExtra("imagemFilmes",imgFilmes[position]);

                startActivity(intent);
            }
        });

    }
    //criando uma classe interna inner class
    public class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return imgFilmes.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageFilmes;
            TextView txtTitulo, txtAno, txtClassificacao, txtNotas;

            //Instanciando e carregando o modelo ao adaptador
            View view1 = getLayoutInflater().inflate(R.layout.modelo_filmes,null);

            //declarando o xml para o java

            txtTitulo = view1.findViewById(R.id.txtModeloTitulo);
            txtAno = view1.findViewById(R.id.txtModeloAno);
            txtClassificacao = view1.findViewById(R.id.txtModeloClassificacao);
            txtNotas = view1.findViewById(R.id.txtModeloNotas);
            imageFilmes = view1.findViewById(R.id.imgModeloFilme);

            //passando os valores para os componentes do modelo
            txtTitulo.setText(titulo[position]);
            txtAno.setText(ano[position]);
            txtClassificacao.setText(classificacao[position]);
            txtNotas.setText(notas[position]);

            imageFilmes.setImageResource(imgFilmes[position]);


            return view1;
        }
    }

}