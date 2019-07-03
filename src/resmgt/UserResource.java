package resmgt;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

import log.Logger;

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
		STANDARD(30, "small"), LARGE(40, "large");

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
		STANDARD(80, "small");

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
	
	static public int MEMECOUNT = 0;

	static public void init() {
		Logger.log.impart("开始处理用户资源!");
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

		// icon-document
		info = ResourceManagement.instance.getPackResource("img/icons/icon-document.jpg");
		info = ResourceManagement.instance.loadTmpResource(info, "icon-document");
		info.setData(
				info.getImage().getScaledInstance(IconSize.LARGE.size, IconSize.LARGE.size, IconSize.STANDARD.size));

		// MEME-1
		File file = new File("./src/resources/img/memes/");
		int count = 0;
		if (file.exists()) {
			File[] files = file.listFiles();
			if (files.length == 0) {
				System.out.println("文件夹是空的!");
				return;
			} else {
				for (File file2 : files) {
					if (!file2.isDirectory()) {
						if (file2.getPath().indexOf(".DS_Store")>=0) {
							continue;
						}
						int index = file2.getPath().indexOf("img");
						String srcImg = file2.getPath().substring(index, file2.getPath().length());
						info = ResourceManagement.instance.getPackResource(srcImg);
						String path = "meme-" + srcImg.substring(10, srcImg.indexOf(".jpg"));
						info = ResourceManagement.instance.loadTmpResource(info, path);
						info.setData(info.getImage().getScaledInstance(MemeSize.STANDARD.size, MemeSize.STANDARD.size,
								MemeSize.STANDARD.size));
						count++;
						System.out.println("文件:" + file2.getPath());
					}
				}
			}
		} else {
			System.out.println("文件不存在!");
		}
		MEMECOUNT = count;
	}

	public void traverseFolder(String path) {

		File file = new File(path);
		if (file.exists()) {
			File[] files = file.listFiles();
			if (files.length == 0) {
				System.out.println("文件夹是空的!");
				return;
			} else {
				for (File file2 : files) {
					if (file2.isDirectory()) {
					} else {
						System.out.println("文件:" + file2.getPath());
					}
				}
			}
		} else {
			System.out.println("文件不存在!");
		}
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
