package com.easyapps.prisonerescape;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Ruslan on 15.10.2016.
 */
public class SitCircle extends Actor {

    private TextureAtlas atlas;
    private TextureRegion SitCircleEnable,SitCircleDisable;
    private String pathOfPack;
    public boolean enabled =false;
    public Rectangle SitCircleBounds;
    float posX,posY,Width,Height,Width2;
    private Hero hero;
    StartClass game;
    private int i,j;

    public SitCircle(StartClass game,Hero hero){
        this.game = game;
        Width = (game.WIDTH*15)/100;
        Width2 = (game.WIDTH*20)/100;
        Height = Width;
        posX = (game.WIDTH*95)/100-Width;
        posY = (game.HEIGHT*2.5f)/100+Width2;
        this.hero = hero;

        pathOfPack = "Sprites/Objects/SittingCircle/SittingCircle.pack";
        atlas = new TextureAtlas(Gdx.files.internal(pathOfPack));
        SitCircleEnable = new TextureRegion(atlas.findRegion("SittingCircleEnabled"));
        SitCircleDisable = new TextureRegion(atlas.findRegion("SittingCircleDisabled"));
        SitCircleBounds = new Rectangle(posX,posY,Width,Height);

    }

    @Override
    public void draw(Batch batch,float parentAlpha){

        switch(i){
            case 0:
                hero.Running = true;
                hero.Sitting = false;
                break;
            case 1:
                hero.Running = false;
                hero.Sitting = true;
                break;
            case 2:
                break;
        }
        if(SitCircleBounds.contains(game.touchPos.x,game.touchPos.y)) {
            if(j==0) {
                i=1;
                j=1;
            }else if(j==2){
                i=0;
                j=3;
                return;
            }
        }else{
            if(j==1){
                j=2;
            }else if(j==3){
                j=0;
            }
        }

        if(hero.Sitting){
            batch.draw(SitCircleEnable,SitCircleBounds.x,SitCircleBounds.y,SitCircleBounds.width,SitCircleBounds.height);
        }else{
            batch.draw(SitCircleDisable,SitCircleBounds.x,SitCircleBounds.y,SitCircleBounds.width,SitCircleBounds.height);
        }
    }
}

