package com.easyapps.prisonerescape;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Ruslan on 10.10.2016.
 */
public class Weapons extends Actor {
    Texture knife;
    public Rectangle knifeRectangle;
    public float posX , posY,  Width, Height;
    public Weapons(float posX , float posY, float Width,float Height,float OriginX, float OriginY, float Rotation) {
        knife = new Texture(Gdx.files.internal("Sprites/Objects/Weapons/Knife/Knife.png"));
        this.posX = posX;
        this.posY = posY;
        this.Width = Width;
        this.Height = Height;
        knifeRectangle = new Rectangle();
        knifeRectangle.setSize(this.Width, this.Height);
        knifeRectangle.setPosition(this.posX, this.posY);

        setPosition(posX, posY);
        setSize(Width, Height);
        setOriginY(OriginY);
        setRotation(Rotation);
    }

    @Override
    public void draw(Batch batch,float parentAlpha){
        batch.draw(knife,  knifeRectangle.getX(), knifeRectangle.getY(),  knifeRectangle.getWidth(), knifeRectangle.getHeight());
    }
}
