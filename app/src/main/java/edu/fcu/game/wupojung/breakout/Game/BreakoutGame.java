package edu.fcu.game.wupojung.breakout.Game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import edu.fcu.game.wupojung.breakout.Game.GameComponent.BallShapeDrawable;
import edu.fcu.game.wupojung.breakout.Game.GameComponent.BlockManager;
import edu.fcu.game.wupojung.breakout.Game.GameComponent.PaddleShapeDrawable;

public class BreakoutGame {

    //region  // Fields

    //狀態機
    private enum eGameStatus {
        INIT,
        READY,
        INGAME,
        OVER,
    }
    private eGameStatus gameStatus;

    private int points; //得分
    private int lives;  //生命

    //筆刷
    private Paint scorePaint;
    private Paint livesPaint;

    //元件
    private BallShapeDrawable ball;
    private PaddleShapeDrawable paddle;
    private BlockManager blockManager;

    //endregion

    //region  // Ctor
    public BreakoutGame() {
        Initialize();
    }

    //endregion

    //region  // Utilities
    private void Initialize() {
        gameStatus = eGameStatus.INIT;
        points = 0;
        lives = 3;

        initializeGameComponent();
        initializePaint();
    }

    private void initializeGameComponent() {
        ball = new BallShapeDrawable();
        paddle = new PaddleShapeDrawable();
        blockManager = new BlockManager();
    }

    private  void initializePaint(){
        scorePaint = new Paint();
        scorePaint.setColor(Color.WHITE);
        scorePaint.setTextSize(25);

        livesPaint = new Paint();
        livesPaint.setTextAlign(Paint.Align.RIGHT);
        livesPaint.setColor(Color.WHITE);
        livesPaint.setTextSize(25);
    }

    private void addToCanvas(Canvas canvas) {
        paddle.initCoords(canvas.getWidth(), canvas.getHeight());
        ball.initCoords(canvas.getWidth(), canvas.getHeight());
        blockManager.initCoords(canvas.getWidth(), canvas.getHeight());
    }

    private void RefreshUI(Canvas canvas) {
        canvas.drawText("得分:" + points, 0, 25, scorePaint); //scorePaint 筆刷
        canvas.drawText("生命:" + lives, canvas.getWidth(), 25, livesPaint);
    }

    private void RefreshGameComponent(Canvas canvas) {
        blockManager.drawToCanvas(canvas);
        paddle.drawToCanvas(canvas);
        ball.drawToCanvas(canvas);
    }
    //endregion

    //region  // Methods

    public void dispatchTouchOffset(float x, float y) {
        switch (gameStatus) {
            case READY: //有人touch 到 screen , 開始遊戲!
                gameStatus = eGameStatus.INGAME;
                break;
            case INGAME:
                paddle.move((int)x);
                break;
            case OVER:
                points = 0;
                lives = 3;
                blockManager.reset();
                gameStatus = eGameStatus.INGAME;
                break;
        }
    }
    public void Update(Canvas canvas) {
        switch (gameStatus){
            case INIT:
                addToCanvas(canvas);
                gameStatus = eGameStatus.READY; // 切換狀態
                break;
            case READY:
                RefreshUI(canvas);
                RefreshGameComponent(canvas);
                break;
            case INGAME:
                RefreshUI(canvas);
                RefreshGameComponent(canvas);
                break;
            case OVER:
                RefreshUI(canvas);
                RefreshGameComponent(canvas);
                break;
        }
    }
    //endregion

    //region  // Properties

    //endregion
}
