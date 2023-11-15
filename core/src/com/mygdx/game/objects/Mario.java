package com.mygdx.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Mario extends GameObject {
    Rectangle bottom, left, right, top, full;
    Sprite sprite;
    Texture texture;
    int action;
    float velocityY;
    public Mario(){
        full = new Rectangle(0F, 0F, 128F, 128F);
        bottom = new Rectangle(0,0,128,16);
        top = new Rectangle(0,112,128,16);
        right = new Rectangle(64,16,64,96);
        left = new Rectangle(0,16,64,96);

        texture = new Texture(Gdx.files.internal("sprite/Safeimagekit-resized-img.png"));
        sprite = new Sprite(texture, 0, 0, 128, 128);
        this.setPosition(0,0);
        velocityY =0;
    }

    // Gérer les collisions
    public int hits(Rectangle r){
        if (bottom.overlaps(r)){
            return 1;
        }
        if (left.overlaps(r)){
            return 2;
        }
        if (right.overlaps(r)){
            return 3;
        }

        if (top.overlaps(r)){
            return 4;
        }
        return -1;
    }

    // Comportements du personnage
    public void action(int type, float x , float y ) {
        if (type == 1 || type == 4) {
            velocityY = 0;
            setPosition(bottom.x, y);
        }
        if (type == 2 || type == 3) {
            velocityY = 0;
            setPosition(x, bottom.y);
        }
    }

    // Contrôler les déplacements
    public void update(float delta){
        velocityY -= 30 * delta;
        bottom.y += velocityY;
        sprite.setPosition(bottom.x, bottom.y);
    }

    public void setPosition(float x, float y){
        full.x = x;
        full.y = y;

        bottom.x = x;
        bottom.y = y;

        left.x = x;
        left.y = y + 16;

        right.x = x + 64;
        right.y = y + 16;

        top.x = x;
        top.y = y + 112;

        sprite.setPosition(x,y);
    }

    public void moveLeft(float delta){
        bottom.x -= (400 * delta);
        sprite.setPosition(bottom.x, bottom.y);
    }

    public void moveRight(float delta){
        bottom.x += (400 * delta);
        sprite.setPosition(bottom.x, bottom.y);
    }

    public void draw(SpriteBatch batch){
        sprite.draw(batch);
    }


    public  void jump(){
        velocityY = 20;
    }

    @Override
    public Rectangle getHitBox() {
        return full;
    }
}
