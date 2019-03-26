package com.bird.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class KenjiBird extends ApplicationAdapter {

	private SpriteBatch batch; // classe de animacao
    private Texture[] passaros;
    private Texture fundo;

    private int movimento = 0;
    //atributos de configuracoes
    private int larguraDoDispositivo;
    private int alturaDoDispositivo;
    private float variacao =0;

    private float velocidadeQuedaPassaro = 0;
    private float posicaoInicaoVertical=0;


	@Override
	public void create () { // inicializa o jogo
        batch = new SpriteBatch(); // manipular as texturas do jogo
        passaros = new Texture[3];
        passaros[0]= new Texture("passaro1.png");
        passaros[1]= new Texture("passaro2.png");
        passaros[2]= new Texture("passaro3.png");
        fundo = new Texture("fundo.png");
        larguraDoDispositivo = Gdx.graphics.getWidth();
        alturaDoDispositivo = Gdx.graphics.getHeight();
        posicaoInicaoVertical = alturaDoDispositivo/2;
	}

	@Override
	public void render () {
        variacao+= Gdx.graphics.getDeltaTime() *10;// fazer o passaro se movimentar
        Gdx.app.log("Variacao", "Variacao: " + Gdx.graphics.getDeltaTime());
        velocidadeQuedaPassaro++;

        if(variacao> 2)
            variacao = 0;

        if(Gdx.input.justTouched()){
            velocidadeQuedaPassaro = - 15;
        }

        if(posicaoInicaoVertical > 0 || velocidadeQuedaPassaro <0)
            posicaoInicaoVertical =posicaoInicaoVertical - velocidadeQuedaPassaro;



	    batch.begin();
        batch.draw(fundo,0,0,larguraDoDispositivo, alturaDoDispositivo); //gdx faz com que ele ocupe a tela toda
        batch.draw(passaros[(int)variacao], 30, posicaoInicaoVertical);// configuracao de onde o passaro vai ficar, vai ficar na x = 300 e y = 300

        batch.end();
	}

}
