package com.wixsite.arielkiell.blockchain.test;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import javax.imageio.ImageIO;
public class General {
	public static void takeScreenShot() throws AWTException {
		try {
			LocalDateTime now = LocalDateTime.now();
			Robot robot = new Robot();
			String format = "jpg";
			String fileName = "FullScreenshot" + now.getSecond() + "."+ format;

			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
			ImageIO.write(screenFullImage, format, new File(fileName));

			System.out.println("A full screenshot saved!");
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}

}
