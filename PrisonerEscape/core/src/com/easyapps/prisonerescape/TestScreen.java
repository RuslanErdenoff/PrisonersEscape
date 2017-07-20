package com.easyapps.prisonerescape;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Ruslan on 19.10.2016.
 */
public class TestScreen implements Screen{

    StartClass game;
    Texture texture;
    TextureAtlas atlas;
    Array<Sprite> sprites;
    Sprite[] sprite;
    Animation animation;
    float stateTime;
    String nameOfActor;
    String size;
    public TestScreen(StartClass game){
        this.game = game;
        nameOfActor = "Running";
        atlas = new TextureAtlas(Gdx.files.internal("Sprites/Hero/Animations/Running/"+nameOfActor+".pack"),Gdx.files.internal("Sprites/Hero/Animations/"+nameOfActor));
        //sprites = atlas.createSprites();
        sprite = new Sprite[25];
        sprites = new Array<Sprite>();
        size = ""+GL20.GL_MAX_TEXTURE_SIZE;
        int i1 = 1;
        for(int i =0 ; i < 25; i++,i1++){
            sprite[i] = atlas.createSprite(nameOfActor + " " + "(" + i1 + ")");
            sprites.add(sprite[i]);
        }
        animation = new Animation(0.025f,sprites);
        stateTime = 0f;
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        stateTime += Gdx.graphics.getDeltaTime();
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        game.batch.begin();
        game.font.draw(game.batch,size,100,100);
        game.batch.draw(animation.getKeyFrame(stateTime,true),100,100,100,100);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
