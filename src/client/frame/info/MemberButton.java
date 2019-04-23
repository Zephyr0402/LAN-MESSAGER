package client.frame.info;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import client.frame.Theme;
public class MemberButton extends  JButton{
	public  final static  int MEMBERBUTTON_HEIGHT=70;
	private String memberName="小明";

public MemberButton(String name) {
	memberName=name;
	JLabel member= new JLabel(name);
	this.setLayout(null);
	this.add(member);
	member.setSize(150,30);
	member.setLocation(0,20);
	member.setFont(new Font("微软雅黑",Font.PLAIN,30));
	Dimension size=new Dimension(275, MEMBERBUTTON_HEIGHT);
	this.setPreferredSize(size);
	this.setMinimumSize(size);
	this.setMaximumSize(size);
	this.setContentAreaFilled(false);
	
}
public String getMemberName() {
	return memberName;
}
public void setMemberName(String memberName) {
	this.memberName = memberName;
}
@Override
public void paint(Graphics g) {
	g.setColor(Theme.COLOR2);
	int width=super.getWidth();
	int height=super.getHeight();
	g.fillRect(0, 0, width, height);
	super.paint(g);
} 
}