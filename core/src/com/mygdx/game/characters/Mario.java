package com.mygdx.game.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Mario {
    Rectangle bottom, left, right, top;
    Sprite sprite;
    Texture texture;
    int action;
    float velocity;
    public Mario(){
        bottom = new Rectangle(0F, 0F, 128F, 128F);

        texture = new Texture(Gdx.files.internal("sprite/Safeimagekit-resized-img.png"));
        sprite = new Sprite(texture, 0, 0, 128, 128);
        this.setPosition(0,0);
    }

    // Gérer les collisions
    public int hits(Rectangle r){
        if(bottom.overlaps(r)){
            return 1;
        }
        return -1;
    }

    // Comportements du personnage
    public void action(int type){

    }

    // Contrôler les déplacements
    public void update(float delta){

    }

    public void setPosition(float x, float y){
        bottom.x = x;
        bottom.y = y;
        sprite.setPosition(x,y);
    }

    public void moveLeft(float delta){

    }

    public void moveRight(float delta){

    }

    public void draw(SpriteBatch batch){
        sprite.draw(batch);
    }
}
