package com.easyapps.prisonerescape;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Ruslan on 17.10.2016.
 */
public class NewAnimationClass  {
    private Animation animation;
    private TextureRegion[] frames;
    private TextureAtlas atlas;
    private TextureRegion currentFrame;
    private String[] nameOfFrames;
    private float fps;
    private float stateTime;

    public NewAnimationClass(String pathOfPack,String nameOfActor,int numberOfFrames,float fps,boolean loop,boolean flip){
        if(flip){
            atlas = new TextureAtlas(Gdx.files.internal(pathOfPack),flip);
        }else{
            atlas = new TextureAtlas(Gdx.files.internal(pathOfPack));
        }

        frames = new TextureRegion[numberOfFrames];
        currentFrame = new TextureRegion();
        int i = 0;
        int i1 = i+1;
        stateTime = 0;
        this.fps = fps*0.001f;
        for(i=0 ; i < numberOfFrames ;i++,i1++ ){
            nameOfFrames[i] = nameOfActor+" "+"("+i1+")";
            frames[i] = atlas.findRegion(nameOfFrames[i]);
        }
        animation = new Animation(this.fps,frames);
        if(loop){
            animation.setPlayMode(Animation.PlayMode.LOOP);
        }else{
            animation.setPlayMode(Animation.PlayMode.NORMAL);
        }

    }
    public TextureRegion getCurrentFrame(){
        stateTime += Gdx.graphics.getDeltaTime();
        currentFrame = animation.getKeyFrame(stateTime,true);
        return currentFrame;
    }
}
