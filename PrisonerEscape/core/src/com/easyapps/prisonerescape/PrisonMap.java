package com.easyapps.prisonerescape;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Ruslan on 16.10.2016.
 */
public class PrisonMap extends Actor {
    TextureRegion map;
    StartClass game;
    public PrisonMap(StartClass game){
        this.game = game;
        map = new TextureRegion(new Texture(Gdx.files.internal("Sprites/Map/Map.png")));
    }

    @Override
    public void draw(Batch batch ,float parentAlpha){
        batch.draw(map,0,0,game.WIDTH*10,game.HEIGHT*10);
    }
}
