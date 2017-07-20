package com.easyapps.prisonerescape;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Ruslan on 16.10.2016.
 */
public class AttackCircle extends Actor {
    private TextureAtlas atlas;
    private TextureRegion SitCircleEnable,SitCircleDisable;
    private String pathOfPack;
    public boolean enabled =false;
    public Rectangle SitCircleBounds;
    float posX,posY,Width,Height;
    private Hero hero;
    StartClass game;
    private int i,j;

    public AttackCircle(StartClass game,Hero hero){
        this.game = game;
        Width = (game.WIDTH*20)/100;
        Height = Width;
        posX = (game.WIDTH*95)/100-Width;
        posY = (game.HEIGHT*2.5f)/100;
        this.hero = hero;

        pathOfPack = "Sprites/Objects/SittingCircle/SittingCircle.pack";
        atlas = new TextureAtlas(Gdx.files.internal(pathOfPack));
        SitCircleEnable = new TextureRegion(atlas.findRegion("SittingCircleEnabled"));
        SitCircleDisable = new TextureRegion(atlas.findRegion("SittingCircleDisabled"));
        SitCircleBounds = new Rectangle(posX,posY,Width,Height);
    }
    @Override
    public void draw(Batch batch,float parentAlpha){
        batch.draw(SitCircleEnable,SitCircleBounds.x,SitCircleBounds.y,SitCircleBounds.width,SitCircleBounds.height);
    }
}
