package com.spring.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;
//生成验证码
public class CertificationGenerator {
	//字符集
	public final static char[] CHARSET="abcdefhigklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
	//验证码图片宽度，高度，字体高度
	private static int width=60;
	private static int height=30;
	private static int fontHeight=20 ;
	private static int num=4;
 

	//生成四个随机数
	public static String getCode() {
		StringBuffer s=new StringBuffer();
		Random random=new Random();
		for (int  i= 0; i <num;i++) {
			s.append(CHARSET[random.nextInt(CHARSET.length)]);
		}
		return s.toString();
	}
	public static BufferedImage getGraphics(String  s){
		//生成图像
		BufferedImage buffImg=new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
		Graphics g =buffImg.createGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		Font font = new Font("Fixedsys", Font.PLAIN, fontHeight);        
	     // 设置字体。        
	     g.setFont(font);        
	     // 画边框。        
	     g.setColor(Color.BLACK);        
	     g.drawRect(0, 0, width - 1, height - 1);
		for (int i = 0; i < s.length(); i++) {
			g.drawString(s.charAt(i)+"", (i+1)*width/(s.length()+1), height-4);
		}
	     return buffImg;
	}
	
}
