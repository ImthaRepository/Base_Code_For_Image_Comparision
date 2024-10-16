package imageCompare;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class ImageCompare {
public static void main(String[] args) throws IOException, InterruptedException {
	WebDriver driver;
	//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("https://www.worldvision.in/AboutUs/who-we-are.aspx");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div//input[@onclick='declineCookieConsent();']")).click();
	Thread.sleep(2000);
	BufferedImage expectedimage = ImageIO.read(new File("C:\\Users\\Ram prathees\\eclipse-workspace\\ImageFetch\\ExpectedImages\\About.png"));
	WebElement imageelement = driver.findElement(By.xpath("//div[@class='col-lg-4 col-xs-12 offsetpadn0 offsetb40']//img"));
	
	Screenshot imageshot = new AShot().takeScreenshot(driver, imageelement);
	BufferedImage actualimage = imageshot.getImage();

	ImageDiffer imgdiff=new ImageDiffer();
	ImageDiff diff=imgdiff.makeDiff(expectedimage, actualimage);
	
	if (diff.hasDiff()==true) {
		System.out.println("Image are not Same");
		BufferedImage showdiff=diff.getMarkedImage();
		ImageIO.write(showdiff, "png", new File("C:\\Users\\Ram prathees\\eclipse-workspace\\ImageFetch\\markedimage\\markedimage1.png"));
	} else {
		System.out.println("Images are same");
	}
	driver.quit();
}
}
