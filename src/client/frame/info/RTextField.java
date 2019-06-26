package client.frame.info;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.TextField;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JTextField;

import client.frame.Theme;


public class RTextField extends JTextField{
	public RTextField() {
		super();
		this.setBackground(Theme.COLOR4);
		this.setBorder(new TextBorderUtlis(new Color(192,192,192), 4, true));
	}
//	@Override
//	protected void paintComponent(Graphics g) {
//		int w=getWidth();
//		int h=getHeight();
//	    Graphics2D g2d = (Graphics2D) g.create();
//	    g2d.setPaint(getBackground());
//        RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(0, 0,
//                w , h , 40, 40);
//        Shape clip = g2d.getClip();
//        g2d.clip(r2d);
//        g2d.fillRect(0, 0, w, h);
//        g2d.setClip(clip);
//        
//
//	}
//	
	}

