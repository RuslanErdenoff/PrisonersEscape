package com.easyapps.prisonerescape;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.easyapps.prisonerescape.AnimationClass;

/**
 * Created by Ruslan on 03.10.2016.
 */
public class Intro extends Actor {
    AnimationClass animation;
    StartClass game;
    public Intro(StartClass game){
        animation = new AnimationClass("Sprites/Intro/Animation/Intro.pack","LOGO",72,30f,false,false);
        this.game = game;
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.draw(animation.getCurrentFrame(),0,0,game.WIDTH,game.HEIGHT);
        batch.draw(animation.getCurrentFrame(),0,game.HEIGHT,game.WIDTH,game.HEIGHT);
    }
}
