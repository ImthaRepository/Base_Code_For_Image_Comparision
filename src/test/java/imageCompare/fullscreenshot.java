package imageCompare;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class fullscreenshot {
public static void main(String[] args) throws IOException {
	WebDriver driver;
	Screenshot scrshot;
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("https://www.worldvision.in/AboutUs/who-we-are.aspx");

	scrshot =new AShot().shootingStrategy(ShootingStrategies.viewportPasting(0)).takeScreenshot(driver);
	ImageIO.write(scrshot.getImage(), "png", new File("C:\\Users\\RRR\\Documents\\Eclipse\\ImageComparision\\screenshot\\worldvision3.png"));
	driver.close();
}
}
