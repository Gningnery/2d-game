package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.objects.Mario;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture texture;
	private Sprite sprite;
	private OrthographicCamera camera;
	private Mario player;



	
	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false ,800 ,480);
		batch =new SpriteBatch();

		player = new Mario();
		player.setPosition(200,100);

//		texture = new Texture(Gdx.files.internal("sprite/Safeimagekit-resized-img.png"));
//		sprite = new Sprite(texture,0,0,128,128);
//		sprite.setPosition(100,50);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		player.draw(batch);
		batch.end();

		//updates
		player.update(Gdx.graphics.getDeltaTime());
		Rectangle temp = new Rectangle(0,0,800,10);
		if (player.hits(temp)!= -1){
			player.action(1,0,10);
		}

		//controls
		if (Gdx.input.isKeyPressed((Input.Keys.SPACE))){
			player.jump();
		}
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			player.moveLeft(Gdx.graphics.getDeltaTime());
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			player.moveRight(Gdx.graphics.getDeltaTime());
		}
	}
	
	@Override
	public void dispose () {

		batch.dispose();
//		texture.dispose();

	}
}
