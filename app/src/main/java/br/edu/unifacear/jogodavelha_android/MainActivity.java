package br.edu.unifacear.jogodavelha_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;

import br.edu.unifacear.jogodavelha_android.dao.Conexao;
import br.edu.unifacear.jogodavelha_android.dao.JogadaDao;
import br.edu.unifacear.jogodavelha_android.entity.Jogada;

public class MainActivity extends AppCompatActivity {

    boolean penes = true;//começa com círculo

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Conexao(getApplicationContext(),
                "jogodavelha.db",
                null,
                1);

        ImageButton p1 = findViewById(R.id.p1);
        ImageButton p2 = findViewById(R.id.p2);
        ImageButton p3 = findViewById(R.id.p3);

        p1.setTag(R.drawable.vazio);
        p2.setTag(R.drawable.vazio);
        p3.setTag(R.drawable.vazio);
    }

    public void clique(View view) {

        Jogada jogada = new Jogada();
        jogada.setJogada(penes);

        if (view.getId() == R.id.p1) {
            jogada.setPosicao(1);
        }
        if (view.getId() == R.id.p2) {
            jogada.setPosicao(2);
        }

        new JogadaDao().inserir(jogada);
        List<Jogada> jogadas = new JogadaDao().listar();
        for (Jogada j : jogadas) {
            Toast.makeText(getApplicationContext(),
                    "Id: " + jogada.getId() +
                            "\n Posicao: " + jogada.getPosicao() +
                            "\n Jogada: " + jogada.getJogada(),
                    Toast.LENGTH_LONG).show();
        }


        ImageButton imageButton = (ImageButton) view;
        if (penes) {
            imageButton.setImageResource(R.drawable.circulo);
            imageButton.setTag(R.drawable.circulo);
            penes = true;
        } else {
            imageButton.setImageResource(R.drawable.x);
            imageButton.setTag(R.drawable.x);
            penes = false;
        }

        ImageButton p1 = findViewById(R.id.p1);
        ImageButton p2 = findViewById(R.id.p2);
        ImageButton p3 = findViewById(R.id.p3);

        //24 IFS

        //FOR 3 IFS

        if (p1.getTag().equals(R.drawable.circulo)
                && p2.getTag().equals(R.drawable.circulo)
                && p3.getTag().equals(R.drawable.circulo)) {
            Toast.makeText(getApplicationContext(),
                    "Cícrulo ganhou!",
                    Toast.LENGTH_LONG).show();
        }

    }
}
