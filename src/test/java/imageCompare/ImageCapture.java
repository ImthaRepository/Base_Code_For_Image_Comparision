package imageCompare;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class ImageCapture {
public static void main(String[] args) throws IOException, InterruptedException {
	WebDriver driver;
	//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
	driver=new ChromeDriver();
	
 driver.manage().window().maximize();
 driver.manage().deleteAllCookies();
 driver.get("https://www.worldvision.in/AboutUs/who-we-are.aspx");
 Thread.sleep(2000);
 driver.findElement(By.xpath("//div//input[@onclick='declineCookieConsent();']")).click();
	Thread.sleep(2000);
 
 WebElement imageelement = driver.findElement(By.xpath("//div[@class='col-lg-4 col-xs-12 offsetpadn0 offsetb40']//img"));

 Screenshot imageshot = new AShot().takeScreenshot(driver, imageelement);
// ImageIO.write(imageshot.getImage(), "png",new File("C://Users//RRR//Desktop//storiespic2.png"));
 ImageIO.write(imageshot.getImage(), "png",new File("C:\\Users\\Ram prathees\\eclipse-workspace\\ImageFetch\\ExpectedImages\\About.png"));
 File f=new File("C:\\Users\\Ram prathees\\eclipse-workspace\\ImageFetch\\ExpectedImages\\About.png");
 
 if (f.exists()) {
	System.out.println("image file captured");
} else {
	System.out.println("image file not exixts");
}
 driver.close();
}

}
