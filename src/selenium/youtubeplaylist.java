package selenium;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class youtubeplaylist {
	
	public static WebDriver driver=null;
     static	Actions act;

     
	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.youtube.com/");
		act=new Actions(driver);
		
		String [] songs= new String[22];
		songs[0]="abcdefu";
		songs[1]="Denzel Curry, Gizzle, Bren Joy - Dynasties & Dystopia | Arcane League of Legends";
		songs[2]="KILLSHOT";
		songs[3]="everybody asap rocky";
		songs[4]="חנן בן ארי חולם כמו יוסף";
		songs[5]="תם ולא נשלם";
		songs[6]="aot sound track u see the big girl";
		songs[7]="Blackway & Black Caviar - \"What's Up Danger\"";
		songs[8]="NF - The Search";
		songs[9]=" Soulchef - Write This Down x Dead Wrong";
		songs[10]="Attack On Titan Season 4 Episode 6 OST \"Warhammer Titan VS Eren & Mikasa(XL-TT Epic Orchestral Cover";
		songs[11]="Coolio-Gangsta's Paradise";
		songs[12]="Bea Miller - Playground";
		songs[13]="maad city";
		songs[14]="XXXTENTACION - MOONLIGHT";
		songs[15]="XXXTENTACION - SAD!";
		songs[16]="Juice Wrld - Lucid Dreams (Lyrics)";
		songs[17]="Rage Against The Machine - Wake Up";
		songs[18]="Rage Against The Machine - Killing In the Name";
		songs[19]="עידן עמדי חלק מהזמן";
		songs[20]="תם ולא נשלם";
		songs[21]="Dennis Lloyd - Alien";
		
        WebElement serachbox= driver.findElement(By.xpath("//input[@placeholder=\"חיפוש\"]"));
		List<WebElement> searchbutton= driver.findElements(By.xpath("//yt-icon[@class='style-scope ytd-searchbox']"));
		
		String com2="מודעה 1 מתוך 2 ·";
		String com1="מודעה ·";
	
	
	    
		for (int i = 0; i < songs.length; i++) {
			
			serachbox.sendKeys(songs[i]);
			Thread.sleep(1500);
			searchbutton.get(1).click();
			Thread.sleep(2000);
			List<WebElement> img=driver.findElements(By.xpath("//yt-formatted-string[@class='style-scope ytd-video-renderer']"));
			img.get(0).click();
		    
			//skiping diffrent kind of ads 
		try {
			   driver.manage().timeouts().implicitlyWait(3 , TimeUnit.SECONDS);
				String TypeOfAd=driver.findElement(By.xpath("//div[@class='ytp-ad-text']")).getText();
		    	  if (TypeOfAd.equals(com1)) {
		    		 String addDurtion=driver.findElement(By.className("ytp-time-duration")).getText();
		    		 skipAd(addDurtion);
	  				}
		    	  else if (TypeOfAd.equals(com2)) {
		    		String addDurtion=driver.findElement(By.className("ytp-time-duration")).getText();
		    		skipAd(addDurtion);
			    	
			    	addDurtion=driver.findElement(By.className("ytp-time-duration")).getText();
			        skipAd(addDurtion);
				}
			} catch (Exception e) {
				
			}
		
		
		//time duration from string to duuble
		Thread.sleep(500);
		WebElement timedur=driver.findElement(By.className("ytp-time-duration"));
			String time1=timedur.getText();
			time1=time1.replace(':', '.');
		    double durtime=Double.parseDouble(time1);
		    
		    WhenToSkipToTheNextSong(durtime);

		}



	}
	
	private static void skipAd(String addDurtion) throws InterruptedException {
		
		addDurtion=addDurtion.replace(":", ".");
		double AdDurtion=Double.parseDouble(addDurtion);
		if (AdDurtion>0.15) {
			driver.manage().timeouts().implicitlyWait( 6, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//button[@class='ytp-ad-skip-button ytp-button']")).click();
		}
		else if (AdDurtion==0.8) {
			Thread.sleep(8300);
		}
		else if (AdDurtion==0.6) {
			Thread.sleep(6300);
		}
		else if (AdDurtion==0.15) {
			Thread.sleep(15300);
		}
	}
	
	private static void WhenToSkipToTheNextSong(double durtime) {
		while (durtime==durtime) {
			WebElement searchBox=driver.findElement(By.xpath("//button[@class='ytp-fullscreen-button ytp-button']"));
			WebElement barvideo=driver.findElement(By.xpath("//div[@class='ytp-left-controls']"));
			act.moveToElement(barvideo).perform();
			act.moveToElement(searchBox).perform();
			WebElement curtime=driver.findElement(By.xpath("//span[@class='ytp-time-current']"));
			String curtime1=curtime.getText();
			curtime1=curtime1.replace(':', '.');
			double curtime2=Double.parseDouble(curtime1);
			if (curtime2==durtime-0.04) {
				searchBox.clear();
				break;
			}
		}
	}

}
