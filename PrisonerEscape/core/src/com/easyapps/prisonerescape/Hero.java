package com.easyapps.prisonerescape;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.easyapps.prisonerescape.AnimationClass;

/**
 * Created by Ruslan on 03.10.2016.
 */
public class Hero extends Actor {

    public float  originX,originY,rotation;
    public boolean move;
    private TextureRegion frame,idle,idleFlip;
    public enum states{Left,Right,Up,Down,Idle}
    public enum moveStates{Running,Sitting};
    public states state;
    public moveStates moveState;
    private states lastState;
    private float speed,normalSpeed,slowSpeed;
    private float lastPosX,lastPosY;
    private AnimationClass[] animations;
    private String filePathRunning,filePathSitting,filePathAttack,filePathIdle;

    boolean Left,Right,Up,Down,Sitting= false;
    boolean Running = true;
    public Rectangle bounds;
    private GameScreen screen;
    private boolean sit;
    public int i;
    private OrthographicCamera camera;

    public Hero(float posX,float posY, float sizeX, float sizeY, float originX, float originY,float rotation,float speed,float fps,boolean flip,OrthographicCamera camera) {

        bounds = new Rectangle();
        sit = false;
        i = 1;
        bounds.setSize(sizeX, sizeY);
        bounds.setPosition(posX, posY);
        this.originX = originY;
        this.rotation = rotation;
        this.speed=speed;

        filePathRunning = "Sprites/Hero/Animations/Running/";
        filePathSitting = "Sprites/Hero/Animations/Sitting/";
        filePathAttack = "Sprites/Hero/Animations/Attack/";
        filePathIdle = "Sprites/Hero/Animations/Idle/";
        animations = new AnimationClass[3];
        animations[1] = new AnimationClass(filePathSitting+"Sitting.pack","Sitting",21,fps+4,false,flip);
        animations[2] = new AnimationClass(filePathRunning+"Running.pack","Running",25,fps,false,flip);
        animations[0] = new AnimationClass(filePathIdle+"Idle.pack","Idle",13,fps+13,false,flip);
//


        //frame = animations[0].getCurrentFrame();
        state = states.Idle;
        moveState = moveStates.Running;
        normalSpeed = speed;
        slowSpeed = speed/2;
        this.camera = camera;
        lastState = states.Right;
    }



    @Override
    public void draw(Batch batch , float parentAlpha){


        if(Sitting){
            speed = slowSpeed;
            moveState = moveStates.Sitting;
        }else if(Running){
            speed = normalSpeed;
            moveState = moveStates.Running;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)||Left){
            bounds.x -= speed*Gdx.graphics.getDeltaTime();
            camera.translate(-speed*Gdx.graphics.getDeltaTime(), 0);
            state = states.Left;
            //move = true;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)||Right){
            bounds.x += speed*Gdx.graphics.getDeltaTime();
            camera.translate(speed*Gdx.graphics.getDeltaTime(), 0);
            state = states.Right;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.W)||Up){
            bounds.y += speed*Gdx.graphics.getDeltaTime();
            camera.translate(0,speed*Gdx.graphics.getDeltaTime());
            state = states.Up;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)||Down){
            bounds.y -= speed*Gdx.graphics.getDeltaTime();
            camera.translate(0,-speed*Gdx.graphics.getDeltaTime());
            state = states.Down;
        }

        if(bounds.x-lastPosX != 0||bounds.x-lastPosY!= 0){
            move = true;
            lastPosX = bounds.x;
            lastPosY = bounds.y;
        }else{
            move = false;
        }




        if(!move){
            state = states.Idle;
            lastPosX = bounds.x;
            lastPosY = bounds.y;
        }

        switch (state){
            case Left:
                frame = animations[i].getCurrentFrame();
                lastState = states.Left;
                break;
            case Right:
                frame = animations[i].getCurrentFrameFlip();
                lastState = states.Right;
                break;
            case Up:
                if(lastState == states.Left){
                    frame = animations[i].getCurrentFrame();
                }else if(lastState == states.Right){
                    frame = animations[i].getCurrentFrameFlip();
                }
                break;
            case Down:
                if(lastState == states.Left){
                    frame = animations[i].getCurrentFrame();
                }else if(lastState == states.Right){
                    frame = animations[i].getCurrentFrameFlip();
                }
                break;
            case Idle:
                if(lastState == states.Left)frame = animations[0].getCurrentFrame();
                else if(lastState == states.Right)frame =animations[0].getCurrentFrameFlip();
                break;
        }
        switch (moveState){
            case Sitting:
                i=1;
                break;
            case Running:
                i=2;
                break;
        }
        batch.draw(frame,bounds.x,bounds.y,originX,originY,bounds.width,bounds.height,getScaleX(),getScaleY(),rotation);
        react();
    }
    private void react(){

    }
}
