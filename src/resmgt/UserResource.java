package resmgt;

import java.awt.Image;

import javax.swing.ImageIcon;

public class UserResource {

	public static enum HeadIconSize {
		BIG(80, "big"), SMALL(40, "small");

		final public int size;
		final public String str;

		HeadIconSize(int size, String s) {
			this.size = size;
			this.str = s;
		}

		@Override
		public String toString() {
			return this.str;
		}
	}

	public static enum IconSize {
		STANDARD(30, "small");

		final public int size;
		final public String str;

		IconSize(int size, String s) {
			this.size = size;
			this.str = s;
		}

		@Override
		public String toString() {
			return this.str;
		}
	}
	
	public static enum MemeSize {
		STANDARD(30, "small");

		final public int size;
		final public String str;

		MemeSize(int size, String s) {
			this.size = size;
			this.str = s;
		}

		@Override
		public String toString() {
			return this.str;
		}
	}

	static {
		// headicon
		ResourceInfo info = ResourceManagement.instance.getPackResource("img/debug_headicon.png");
		info = ResourceManagement.instance.loadTmpResource(info, "headicon/debug_big");
		info.setData(
				info.getImage().getScaledInstance(HeadIconSize.BIG.size, HeadIconSize.BIG.size, Image.SCALE_DEFAULT));
		info = ResourceManagement.instance.loadTmpResource(info, "headicon/debug_small");
		info.setData(info.getImage().getScaledInstance(HeadIconSize.SMALL.size, HeadIconSize.SMALL.size,
				Image.SCALE_DEFAULT));
		// icon-reply
		info = ResourceManagement.instance.getPackResource("img/icons/icon-reply.png");
		info = ResourceManagement.instance.loadTmpResource(info, "icon-reply");
		info.setData(info.getImage().getScaledInstance(IconSize.STANDARD.size + 5, IconSize.STANDARD.size + 5,
				IconSize.STANDARD.size + 5));
		// icon-tool
		info = ResourceManagement.instance.getPackResource("img/icons/icon-tool.png");
		info = ResourceManagement.instance.loadTmpResource(info, "icon-tool");
		info.setData(info.getImage().getScaledInstance(IconSize.STANDARD.size, IconSize.STANDARD.size,
				IconSize.STANDARD.size));
		// icon-emoji
		info = ResourceManagement.instance.getPackResource("img/icons/icon-emoji.png");
		info = ResourceManagement.instance.loadTmpResource(info, "icon-emoji");
		info.setData(info.getImage().getScaledInstance(IconSize.STANDARD.size - 5, IconSize.STANDARD.size - 5,
				IconSize.STANDARD.size - 5));
		// icon-user
		info = ResourceManagement.instance.getPackResource("img/icons/icon-user.png");
		info = ResourceManagement.instance.loadTmpResource(info, "icon-user");
		info.setData(info.getImage().getScaledInstance(IconSize.STANDARD.size, IconSize.STANDARD.size,
				IconSize.STANDARD.size));

		// MEME-1
		info = ResourceManagement.instance.getPackResource("img/memes/1.jpg");
		info = ResourceManagement.instance.loadTmpResource(info, "meme-1");
		info.setData(info.getImage().getScaledInstance(MemeSize.STANDARD.size, MemeSize.STANDARD.size,
				MemeSize.STANDARD.size));
	}

	/** 获取用户头像 */
	static public ImageIcon getHeadIcon(String username, HeadIconSize size) {
		return new ImageIcon(ResourceManagement.instance.getTmpResource("headicon/debug_" + size).getImage());
	}

	/** 获取系统图标 */
	static public ImageIcon getSysIcon(String iconPath) {
		return new ImageIcon(ResourceManagement.instance.getTmpResource(iconPath).getImage());
	}
	
	/** 获取表情包 */
	static public ImageIcon getMeme(String iconPath) {
		return new ImageIcon(ResourceManagement.instance.getTmpResource(iconPath).getImage());
	}
}
