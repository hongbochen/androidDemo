package com.bobo.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Random;

/**
 * Created by 洪波 on 2016/4/19.
 */
public class MSurfaceView  extends SurfaceView implements SurfaceHolder.Callback,Runnable{

    private SurfaceHolder sfh;
    private Paint paint;
    private Thread th;
    private boolean flag;
    private Canvas canvas;
    public static int screenW,screenH;

    // 贝塞尔曲线成员变量（起始点，控制点，终止点，3点坐标）
    private int startX,startY,controlX,controlY,endX,endY;
    // Path
    private Path path;
    // 为了不影响主画笔，这里为贝塞尔曲线单独使用一个画笔
    private Paint paintQ;
    // 随机库（让贝塞尔曲线更明显）
    private Random random;

    //初始化函数
    public MSurfaceView(Context context) {
        super(context);

        sfh = this.getHolder();
        sfh.addCallback(this);
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
        setFocusable(true);

        //贝塞尔曲线初始化
        path = new Path();
        paintQ = new Paint();
        paintQ.setAntiAlias(true);
        paintQ.setStyle(Paint.Style.STROKE);
        paintQ.setStrokeWidth(5);
        paintQ.setColor(Color.WHITE);

        random = new Random();
    }

    public MSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);

        sfh = this.getHolder();
        sfh.addCallback(this);
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
        setFocusable(true);

        //贝塞尔曲线初始化
        path = new Path();
        paintQ = new Paint();
        paintQ.setAntiAlias(true);
        paintQ.setStyle(Paint.Style.STROKE);
        paintQ.setStrokeWidth(5);
        paintQ.setColor(Color.WHITE);

        random = new Random();
    }

    public MSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        sfh = this.getHolder();
        sfh.addCallback(this);
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
        setFocusable(true);

        //贝塞尔曲线初始化
        path = new Path();
        paintQ = new Paint();
        paintQ.setAntiAlias(true);
        paintQ.setStyle(Paint.Style.STROKE);
        paintQ.setStrokeWidth(5);
        paintQ.setColor(Color.WHITE);

        random = new Random();
    }

    @Override
    public void run() {
        while(flag){
            long start = System.currentTimeMillis();
            myDraw();
            logic();
            long end = System.currentTimeMillis();
            try{
                if(end - start < 50){
                    Thread.sleep(50 - (end - start));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        flag = false;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        screenW = this.getWidth();
        screenH = this.getHeight();
        flag = true;
        //实例线程
        th = new Thread(this);
        //启动线程
        th.start();
    }

    //绘图
    public void myDraw(){
        try{
            canvas = sfh.lockCanvas();
            if(canvas != null){
                canvas.drawColor(Color.BLACK);
                drawQPath(canvas);
            }
        }catch(Exception e){

        }finally{
            if(canvas != null){
                sfh.unlockCanvasAndPost(canvas);
            }
        }
    }

    //绘制贝塞尔曲线
    public void drawQPath(Canvas canvas){
        path.reset();//重置
        //贝塞尔曲线的起始点
        path.moveTo(startX, startY);
        //设置贝塞尔曲线的操作点以及终止点
        path.quadTo(controlX,controlY,endX,endY);
        //绘制贝塞尔曲线
        canvas.drawPath(path,paintQ);
    }

    //触屏监听


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        endX = (int)event.getX();
        endY = (int)event.getY();

        return true;
    }

    //逻辑
    private void  logic(){
        if(endX != 0 && endY != 0){
            //设置操作点为线段x/y的一半
            controlX = random.nextInt((endX - startX) / 2);
            controlY = random.nextInt((endY - startY) / 2);
        }
    }

    //按键监听

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }
}



































