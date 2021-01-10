package easy.app.game;

import android.graphics.Canvas;
import android.view.Surface;
import android.view.SurfaceHolder;

import java.util.Observer;

public class GameLoop extends Thread{
    private boolean isRunning;
    private SurfaceHolder surfaceHolder;
    private Game game;

    public GameLoop(Game game, SurfaceHolder surfaceHolder) {
        this.game = game;
        this.surfaceHolder = surfaceHolder;
    }

    public double getAverageUPS() {
        return 0;
    }

    public double getAverageFPS() {
        return 0;
    }

    public void startLoop() {
        isRunning = true;
        start();
    }

    @Override
    public void run() {
        super.run();
        int updateCount = 0;
        int frameCount = 0;

        long startTime;
        long ellapsedTime;
        long sleepTime;


        Canvas canvas;
        startTime = System.currentTimeMillis();
        while (isRunning){
            //Try to update and render game

            try {
                canvas = surfaceHolder.lockCanvas();
                game.update();
                game.draw(canvas);
                surfaceHolder.unlockCanvasAndPost(canvas);
            }catch (IllegalArgumentException e){
                e.printStackTrace();
            }
            updateCount++;
            frameCount++;

            //Pause game loop to not exceed target UPS

            //Skip frames to keep up with target UPS

            //Calculate average UPS and FPS

            ellapsedTime = System.currentTimeMillis() - startTime;
            if(ellapsedTime >= 1000){

            }
        }
    }
}
