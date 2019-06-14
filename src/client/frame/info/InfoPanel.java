package client.frame.info;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import client.event.EventIPC;
import client.event.EventRecv.EventRecvString;
import client.event.EventsBridge;
import client.frame.Theme;
import event.IEventBus;
import event.SubscribeEvent;
import user.User;

/** 界面左边的区域 用户区域 */
public class InfoPanel extends JPanel {
	private static final int PS = 10;
	private static final long serialVersionUID = 1L;
	private ListScrollPanel memberField;
	private SearchPanel searchField;
	private UserPanel userField;
	private int state;
	public InfoPanel() {
		this.setBackground(Theme.COLOR2);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		userField = new UserPanel();
		searchField = new SearchPanel();
		memberField = new ListScrollPanel();
		this.add(userField);
		this.add(searchField);
		this.add(memberField);
		state=EventIPC.FRIENDS;
		userField.setPreferredSize(new Dimension(0, 80));
		searchField.setPreferredSize(new Dimension(0, 50));
	}
	public void initEvent(IEventBus bus) {
		bus.register(this);
		memberField.initEvent(bus);
		searchField.initEvent(bus);
	}
//响应事件函数
	@SubscribeEvent
	public void onStateChange(client.event.EventIPC e) 
	{
		System.out.println("infoPanel的状态发生了变化，从状态"+state+"变为状态"+e.state);
		state=e.state;
	}
	@SubscribeEvent
	public void onULChange(client.event.EventULChange e) {
		memberField.deleteAllMember();
		for (User u : e.ul) {
			addMember(u.userName);
		}
	}

	/* 暂时作为测试 */
	public void addMembers(String[] members) {
		for (int i = 0; i < members.length; i++) {
			memberField.addNewMember(members[i]);
		}

	}

	public void addMember(String member) {
		memberField.addNewMember(member);
	}

	public void removeMember(String[] members) {
		for (String i : members)
			memberField.deductMember(i);
	}

	public void removeMember(String member) {
		memberField.deductMember(member);
	}

	public void setMemberTop(String member) {
		memberField.setTop(member);
	}

	public void setUserList(ArrayList<User> ul) {
		// TODO Auto-generated method stub
		// 需要修改
		for (int i = 0; i < ul.size(); i++) {
			this.addMember(ul.get(i).userName);
		}
	}
}
