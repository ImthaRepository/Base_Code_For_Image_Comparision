package imageFetch;

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




public class imagefetch {
public static void main(String[] args) throws IOException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("https://www.worldvision.in/AboutUs/who-we-are.aspx");
	
	BufferedImage expectimg=ImageIO.read(new File("C:\\Users\\Ram prathees\\Downloads\\storiespic1.png"));

	WebElement imageelement = driver.findElement(By.xpath("//div[@class='col-lg-4 col-xs-12 offsetpadn0 offsetb40']//img"));
    Screenshot contentimage= new AShot().takeScreenshot(driver, imageelement); 
	BufferedImage actualImage=contentimage.getImage();
	
	ImageDiffer imgdiff =new ImageDiffer();
	ImageDiff diff=imgdiff.makeDiff(actualImage, expectimg);
	
	if (diff.hasDiff()==false) {
		System.out.println("Image are not same");
	} else {
		System.out.println("Image are Same");
	}
		driver.close();
	
	
}
}
