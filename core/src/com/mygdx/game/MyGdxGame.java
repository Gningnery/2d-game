package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture texture;
	private Sprite sprite;
	private OrthographicCamera camera;



	
	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false ,800 ,480);
		batch =new SpriteBatch();
		texture = new Texture(Gdx.files.internal("sprite/Safeimagekit-resized-img.png"));


		sprite = new Sprite(texture,0,0,128,128);
		sprite.setPosition(100,50);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		sprite.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {

		batch.dispose();
		texture.dispose();

	}
}
