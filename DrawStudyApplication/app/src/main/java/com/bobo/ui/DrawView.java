package com.bobo.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 洪波 on 2016/4/15.
 */
public class DrawView extends View{

    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //把整张画布绘制成白色
        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();

        //去锯齿
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);

        //绘制圆形
        canvas.drawCircle(40, 40, 30, paint);
        //绘制正方形
        canvas.drawRect(10,80,70,140,paint);
        //绘制矩形
        canvas.drawRect(10,150,70,190,paint);
        RectF re1 = new RectF(10,200,70,230);
        //绘制圆角矩形
        canvas.drawOval(re1,paint);
        //定义一个path，封闭成三角形
        Path  path1 = new Path();
        path1.moveTo(10,340);
        path1.lineTo(70, 340);
        path1.lineTo(40, 290);
        path1.close();
        //根据path进行绘制，绘制成三角形
        canvas.drawPath(path1,paint);
        //根据path进行绘制，封闭成一个五角星
        Path path2 = new Path();
        path2.moveTo(26, 360);
        path2.lineTo(54, 360);
        path2.lineTo(70, 397);
        path2.lineTo(40, 420);
        path2.lineTo(10, 392);
        path2.close();
        canvas.drawPath(path2, paint);

        //------设置填充风格后绘制--------
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        canvas.drawCircle(120, 40, 30, paint);
        //绘制正方形
        canvas.drawRect(90f,80f,150f,140f,paint);
        //绘制矩形
        canvas.drawRect(90, 150, 150, 190, paint);
        RectF re2 = new RectF(90,200,150,230);
        //绘制圆角矩形
        canvas.drawRect(re2, paint);
        RectF re21 = new RectF(90,240,150,270);
        //绘制椭圆
        canvas.drawOval(re21, paint);

        Path path3 = new Path();
        path3.moveTo(90, 340);
        path3.lineTo(150, 340);
        path3.lineTo(120, 290);
        path3.close();
        //绘制三角形
        canvas.drawPath(path3,paint);

        Path path4 = new Path();
        path4.moveTo(106,360);
        path4.lineTo(134, 360);
        path4.lineTo(150, 392);
        path4.lineTo(120, 420);
        path4.lineTo(90, 392);
        path4.close();
        //绘制五角星
        canvas.drawPath(path4,paint);

        //-----设置渐变后绘制
        Shader mShader = new LinearGradient(0,0,40,60,new int[]{
                Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW
        },null,Shader.TileMode.REPEAT) ;

        //为paint设置渐变器
        paint.setShader(mShader);
        //设置阴影
        paint.setShadowLayer(45, 10, 10, Color.GRAY);
        //绘制圆形
        canvas.drawCircle(200, 40, 30, paint);
        //绘制正方形
        canvas.drawRect(170,80,230,140,paint);
        //绘制矩形
        canvas.drawRect(170,150,230,190,paint);
        RectF re3 = new RectF(170,200,230,230);
        //绘制圆角矩形
        canvas.drawRect(re3,paint);
        RectF re31 = new RectF(170,240,230,270);
        //绘制椭圆
        canvas.drawOval(re31,paint);
        Path path5 = new Path();
        path5.moveTo(170,340);
        path5.lineTo(230,340);
        path5.lineTo(200,290);
        path5.close();
        //绘制三角形
        canvas.drawPath(path5,paint);
        Path path6 = new Path();
        path6.moveTo(186,360);
        path6.lineTo(214,360);
        path6.lineTo(230,392);
        path6.lineTo(200,420);
        path6.lineTo(170,392);
        path6.close();
        //绘制五角星
        canvas.drawPath(path6,paint);
    }
}
