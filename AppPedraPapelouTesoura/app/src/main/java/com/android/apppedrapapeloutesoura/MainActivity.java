package com.android.apppedrapapeloutesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
    }

    public void pedra(View view) {
        escolhaSelecionada("pedra");

    }

    public void papel(View view) {
        escolhaSelecionada("papel");

    }

    public void tesoura(View view) {
        escolhaSelecionada("tesoura");
    }

    public void escolhaSelecionada(String escolhaUsuario) {
        ImageView mostrarResultadoImagem = findViewById(R.id.app_imagem_resultado);
        TextView mostrarResultadoTexto = findViewById(R.id.app_texto_resultado);
        Random gerador = new Random();
        int nomesAleatorios = gerador.nextInt(3);
        String[] nomes = {
                "pedra", "papel", "tesoura"

        };
        String escolhaApp = nomes[nomesAleatorios];

        switch (escolhaApp) {
            case "pedra":
                mostrarResultadoImagem.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                mostrarResultadoImagem.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                mostrarResultadoImagem.setImageResource(R.drawable.tesoura);
                break;
        }
        if (escolhaApp == "pedra" && escolhaUsuario == "tesoura" ||
            escolhaApp == "tesoura" && escolhaUsuario == "papel" ||
            escolhaApp == "papel" && escolhaUsuario == "pedra")     {

            mostrarResultadoTexto.setText("Você Perdeu!");
            mostrarResultadoTexto.setTextColor(getResources().getColor(R.color.vermelho));

        }
       else if (escolhaApp == "pedra" && escolhaUsuario == "papel"||
                escolhaApp == "papel" && escolhaUsuario == "tesoura"||
                escolhaApp == "tesoura" && escolhaUsuario == "pedra") {

            mostrarResultadoTexto.setText("Você Ganhou!");
            mostrarResultadoTexto.setTextColor(getResources().getColor(R.color.verde));
        } else {
            mostrarResultadoTexto.setText("Empate!");
            mostrarResultadoTexto.setTextColor(getResources().getColor(R.color.amarelo));
        }


    }
}