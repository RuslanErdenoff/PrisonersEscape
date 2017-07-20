package com.easyapps.prisonerescape;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Ruslan on 10.10.2016.
 */
public class MovementCircle extends Actor {
    private TextureAtlas atlas;
    private TextureRegion MoveCircle,ArrowEnabledLeft,ArrowDisableLeft,ArrowEnabledUp,ArrowDisableUp,ArrowEnabledRight,ArrowDisableRight,ArrowEnabledDown,ArrowDisableDown;
    private String pathOfPack;
    public boolean enabled =false;
    public Rectangle MoveCircleRectangle,ArrowRightRectangle,ArrowLeftRectangle,ArrowUpRectangle,ArrowDownRectangle;
    float posX,posY,Width,Height;
    private Hero hero;
    StartClass game;


    public MovementCircle(StartClass game,Hero hero){
        this.game = game;
        posX = (game.WIDTH*5)/100;
        posY = (game.HEIGHT*2.5f)/100;
        Width = (game.WIDTH*20)/100;
        Height = Width;
        this.hero = hero;

        MoveCircleRectangle = new Rectangle();
        MoveCircleRectangle.setSize(Width, Height);
        MoveCircleRectangle.setPosition(posX, posY);
        pathOfPack = "Sprites/Objects/MovementCircle/MoveCircle.pack";
        ArrowRightRectangle = new Rectangle();
        ArrowLeftRectangle = new Rectangle();
        ArrowUpRectangle = new Rectangle();
        ArrowDownRectangle = new Rectangle();

        atlas = new TextureAtlas(Gdx.files.internal(pathOfPack));

        MoveCircle = new TextureRegion(atlas.findRegion("Circle"));
       //
        ArrowEnabledRight = new TextureRegion(atlas.findRegion("ArrowRightEnabled"));
        ArrowDisableRight = new TextureRegion(atlas.findRegion("ArrowRightDisabled"));

        ArrowRightRectangle.width = MoveCircleRectangle.width/3;
        ArrowRightRectangle.height = MoveCircleRectangle.height/4;
        ArrowRightRectangle.x =MoveCircleRectangle.x+MoveCircleRectangle.width-ArrowRightRectangle.width;
        ArrowRightRectangle.y = MoveCircleRectangle.y+MoveCircleRectangle.height/2-ArrowRightRectangle.height/2;
        //
        ArrowEnabledUp =  new TextureRegion(atlas.findRegion("ArrowUpEnabled"));
        ArrowDisableUp= new TextureRegion(atlas.findRegion("ArrowUpDisabled"));


        ArrowUpRectangle.width = MoveCircleRectangle.width/3;
        ArrowUpRectangle.height = MoveCircleRectangle.height/4;
        ArrowUpRectangle.x = MoveCircleRectangle.x+MoveCircleRectangle.width/2-ArrowUpRectangle.width/2;
        ArrowUpRectangle.y =  MoveCircleRectangle.y+MoveCircleRectangle.height-ArrowUpRectangle.height;
        //
        ArrowEnabledLeft =  new TextureRegion(atlas.findRegion("ArrowLeftEnabled"));
        ArrowDisableLeft =new TextureRegion(atlas.findRegion("ArrowLeftDisabled"));


        ArrowLeftRectangle.width = MoveCircleRectangle.width/3;
        ArrowLeftRectangle.height = MoveCircleRectangle.height/4;
        ArrowLeftRectangle.x =MoveCircleRectangle.x+MoveCircleRectangle.width-ArrowLeftRectangle.width*3;
        ArrowLeftRectangle.y = MoveCircleRectangle.y+MoveCircleRectangle.height/2-ArrowLeftRectangle.height/2;


        //

        ArrowEnabledDown =  new TextureRegion(atlas.findRegion("ArrowDownEnabled"));
        ArrowDisableDown = new TextureRegion(atlas.findRegion("ArrowDownDisabled"));

        ArrowDownRectangle.width = MoveCircleRectangle.width/3;
        ArrowDownRectangle.height = MoveCircleRectangle.height/4;
        ArrowDownRectangle.x =MoveCircleRectangle.x+MoveCircleRectangle.width/2-ArrowDownRectangle.width/2;;
        ArrowDownRectangle.y = MoveCircleRectangle.y+ArrowDownRectangle.height/2-ArrowDownRectangle.height/2;
       // ArrowDownRectangle.x =Width/2+ArrowDownRectangle.width/2;
       // ArrowDownRectangle.y = Height/2-(((Height/2)*65)/100);

    }
    @Override
    public void draw(Batch batch,float parentAlpha){
        batch.draw(MoveCircle,MoveCircleRectangle.x,MoveCircleRectangle.y,MoveCircleRectangle.width,MoveCircleRectangle.height);

        if(ArrowRightRectangle.contains(game.touchPos.x,game.touchPos.y)){
            hero.Right = true;
        }else  if(ArrowLeftRectangle.contains(game.touchPos.x,game.touchPos.y)){
            hero.Left = true;
        }else  if(ArrowUpRectangle.contains(game.touchPos.x,game.touchPos.y)) {
            hero.Up = true;
        }else  if(ArrowDownRectangle.contains(game.touchPos.x,game.touchPos.y)) {
            hero.Down = true;
        }
        else{
            hero.Left = false;
            hero.Right = false;
            hero.Up = false;
            hero.Down = false;
            hero.state=Hero.states.Idle;
        }

        if(hero.Left){
            batch.draw(ArrowEnabledLeft,ArrowLeftRectangle.x,ArrowLeftRectangle.y,ArrowLeftRectangle.width,ArrowLeftRectangle.height);
            batch.draw(ArrowDisableUp,ArrowUpRectangle.x,ArrowUpRectangle.y,ArrowUpRectangle.width,ArrowUpRectangle.height);
            batch.draw(ArrowDisableDown,ArrowDownRectangle.x,ArrowDownRectangle.y,ArrowDownRectangle.width,ArrowDownRectangle.height);
            batch.draw(ArrowDisableRight, ArrowRightRectangle.x, ArrowRightRectangle.y, ArrowRightRectangle.width,ArrowRightRectangle.height);
        }else if(hero.Right){
            batch.draw(ArrowEnabledRight,ArrowRightRectangle.x,ArrowRightRectangle.y,ArrowRightRectangle.width,ArrowRightRectangle.height);
            batch.draw(ArrowDisableLeft,ArrowLeftRectangle.x,ArrowLeftRectangle.y,ArrowLeftRectangle.width,ArrowLeftRectangle.height);
            batch.draw(ArrowDisableUp,ArrowUpRectangle.x,ArrowUpRectangle.y,ArrowUpRectangle.width,ArrowUpRectangle.height);
            batch.draw(ArrowDisableDown,ArrowDownRectangle.x,ArrowDownRectangle.y,ArrowDownRectangle.width,ArrowDownRectangle.height);
        }else if(hero.Up){
            batch.draw(ArrowEnabledUp,ArrowUpRectangle.x,ArrowUpRectangle.y,ArrowUpRectangle.width,ArrowUpRectangle.height);
            batch.draw(ArrowDisableRight, ArrowRightRectangle.x, ArrowRightRectangle.y, ArrowRightRectangle.width,ArrowRightRectangle.height);
            batch.draw(ArrowDisableLeft,ArrowLeftRectangle.x,ArrowLeftRectangle.y,ArrowLeftRectangle.width,ArrowLeftRectangle.height);
            batch.draw(ArrowDisableDown,ArrowDownRectangle.x,ArrowDownRectangle.y,ArrowDownRectangle.width,ArrowDownRectangle.height);
        }else if(hero.Down){
            batch.draw(ArrowEnabledDown,ArrowDownRectangle.x,ArrowDownRectangle.y,ArrowDownRectangle.width,ArrowDownRectangle.height);
            batch.draw(ArrowDisableRight, ArrowRightRectangle.x, ArrowRightRectangle.y, ArrowRightRectangle.width,ArrowRightRectangle.height);
            batch.draw(ArrowDisableLeft,ArrowLeftRectangle.x,ArrowLeftRectangle.y,ArrowLeftRectangle.width,ArrowLeftRectangle.height);
            batch.draw(ArrowDisableUp,ArrowUpRectangle.x,ArrowUpRectangle.y,ArrowUpRectangle.width,ArrowUpRectangle.height);
        }
        else {
            batch.draw(ArrowDisableRight, ArrowRightRectangle.x, ArrowRightRectangle.y, ArrowRightRectangle.width,ArrowRightRectangle.height);
            batch.draw(ArrowDisableLeft,ArrowLeftRectangle.x,ArrowLeftRectangle.y,ArrowLeftRectangle.width,ArrowLeftRectangle.height);
            batch.draw(ArrowDisableUp,ArrowUpRectangle.x,ArrowUpRectangle.y,ArrowUpRectangle.width,ArrowUpRectangle.height);
            batch.draw(ArrowDisableDown,ArrowDownRectangle.x,ArrowDownRectangle.y,ArrowDownRectangle.width,ArrowDownRectangle.height);
        }
    }
}
