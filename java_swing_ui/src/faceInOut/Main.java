package faceInOut;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Main {

	public static void main(String[] args) {
		//stackoverflow.com/questions/20346661/java-fade-in-and-out-of-images
		// https://stackoverflow.com/questions/9417356/bufferedimage-resize
//		Thread t = new Thread(){
//			@Override
//			public void run() {
//				String name = weddings.get(index).name;
//
//				File[] files = new File(String.format("./datafile/¿þµùÈ¦/%s/", name)).listFiles();
//				
//				while(isActive) {
//					for (int i = 0; i < files.length; i++) {
//						if (name.equals(weddings.get(index).name) == false) {
//							name = weddings.get(index).name;
//							files = new File(String.format("./datafile/¿þµùÈ¦/%s/", name)).listFiles();
//							break;
//						}
//
//						try {
//							BufferedImage bim = ImageIO.read(new File(String.format("./datafile/¿þµùÈ¦/%s/%s", name, files[i].getName())));
//							Image temp = bim.getScaledInstance(lbImg.getWidth(), lbImg.getHeight(), Image.SCALE_SMOOTH);
//							BufferedImage nbim = new BufferedImage(lbImg.getWidth(), lbImg.getHeight(), BufferedImage.TYPE_INT_ARGB);
//							Graphics2D g2d = nbim.createGraphics();
//
//							for (int amp = 0; amp <=200; amp++) {
//								sleep(5);
//								g2d.drawImage(temp, 0, 0, null);
//								RescaleOp r = new RescaleOp(new float[]{1f, 1f, 1f, (float) amp / 200}, new float[]{0, 0, 0, 0}, null);
//								BufferedImage filter = r.filter(nbim, null);
//								lbImg.setIcon(new ImageIcon(filter));
//							}
//							for (int amp = 200; amp >=0; amp--) {
//								sleep(5);
//								g2d.drawImage(temp, 0, 0, null);
//								RescaleOp r = new RescaleOp(new float[]{1f, 1f, 1f, (float) amp / 200}, new float[]{0, 0, 0, 0}, null);
//								BufferedImage filter = r.filter(nbim, null);
//								lbImg.setIcon(new ImageIcon(filter));
//							}
//						} catch (Exception ex) {
//							System.err.println(ex);
//						}
//					}
//
//					System.out.println(name);
//				}
//			}
//		};
//		t.start();
	}
}
