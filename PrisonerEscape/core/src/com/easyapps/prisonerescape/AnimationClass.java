package com.easyapps.prisonerescape;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Ruslan on 03.10.2016.
 */
public class AnimationClass {

    private TextureAtlas atlas;
    private TextureAtlas atlasFlip;
    private TextureRegion currentFrame;
    private TextureRegion[] frames;
    private TextureRegion[] framesFlip;
    private String[] nameOfFramesFlip;
    private String[] nameOfFrames;
    private Animation animation;
    private Animation animationFlip;
    private float stateTime;
    private float fps;
    private int numberOfFrames;


    public AnimationClass(String pathOfPack,String nameOfActor,int numberOfFrames,float fps,boolean loop,boolean flip){
        this.fps = fps*0.001f;
        atlas = new TextureAtlas(Gdx.files.internal(pathOfPack));
        atlasFlip = new TextureAtlas(Gdx.files.internal(pathOfPack));
        nameOfFrames = new String[numberOfFrames];
        nameOfFramesFlip = new String[numberOfFrames];
        frames = new TextureRegion[numberOfFrames];
        framesFlip = new TextureRegion[numberOfFrames];
        currentFrame = new TextureRegion();


        int i = 0;
        int i1 = i+1;

            for(i=0 ; i < numberOfFrames ;i++,i1++ ){
                nameOfFrames[i] = nameOfActor+" "+"("+i1+")";
                frames[i] = atlas.findRegion(nameOfFrames[i]);
            }
        animation = new Animation(this.fps,frames);

        i1=1;
        if(flip){
            for(i=0 ; i < numberOfFrames ;i++,i1++ ){
                nameOfFramesFlip[i] = nameOfActor+" "+"("+i1+")";
                framesFlip[i] = atlasFlip.findRegion(nameOfFramesFlip[i]);
                framesFlip[i].flip(true,false);
            }
            animationFlip = new Animation(this.fps,framesFlip);
        }
        if(loop){
            animation.setPlayMode(Animation.PlayMode.LOOP);
            if(flip){
                animationFlip.setPlayMode(Animation.PlayMode.LOOP);
            }
        }else{
            animation.setPlayMode(Animation.PlayMode.NORMAL);
            if(flip){
                animationFlip.setPlayMode(Animation.PlayMode.NORMAL);
            }
        }
        stateTime = 0f;
        this.numberOfFrames = numberOfFrames;
    }
    public TextureRegion getCurrentFrame(){
        stateTime += Gdx.graphics.getDeltaTime();
        currentFrame = animation.getKeyFrame(stateTime,true);
        return currentFrame;
    }
    public TextureRegion getCurrentFrameFlip(){
        stateTime += Gdx.graphics.getDeltaTime();
        currentFrame = animationFlip.getKeyFrame(stateTime, true);
        return currentFrame;
    }
    public boolean getIsAnimationFinished(){
        return animation.isAnimationFinished(stateTime);
    }

    public void dispose(){
        atlas.dispose();
    }
}
