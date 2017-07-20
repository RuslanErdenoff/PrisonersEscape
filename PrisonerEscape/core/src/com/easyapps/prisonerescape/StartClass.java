package com.easyapps.prisonerescape;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class StartClass extends Game{

	public SpriteBatch batch;
	BitmapFont font;
	Rectangle testRect;
	Rectangle mouseRect;
	Vector3 touchPos;
	float WIDTH;
	float HEIGHT;
	OrthographicCamera camera;

	@Override
	public void create() {
		batch = new SpriteBatch();
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();
		super.setScreen(new IntroScreen(this));

		font = new BitmapFont();

		mouseRect = new Rectangle();
		mouseRect.width=10;
		mouseRect.height=10;

		touchPos = new Vector3();
		touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, WIDTH, HEIGHT);
		camera.position.set(WIDTH/2,HEIGHT/2,0);
	}

	@Override
	public void render(){
		super.render();
	}
	@Override
	public void dispose(){
		super.dispose();
	}
}
