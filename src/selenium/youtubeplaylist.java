package selenium;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.collections4.Get;
import org.apache.poi.xssf.usermodel.XSSFAnchor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class youtubeplaylist {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.edge.driver","C:\\Users\\yakov\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver drive = new EdgeDriver();
		
		drive.get("https://www.youtube.com/");
		Actions act=new Actions(drive);
		String [] songs= new String[22];
		songs[0]="snakes arcane";
		songs[1]="Denzel Curry, Gizzle, Bren Joy - Dynasties & Dystopia | Arcane League of Legends";
		songs[2]="KILLSHOT";
		songs[3]="Die For You ft. Grabbitz // Official Music Video // VALORANT";
		songs[4]="Godzilla (feat. Juice WRLD)";
		songs[5]="Eminem - Venom";
		songs[6]="aot sonud track u see big girl";
		songs[7]="Blackway & Black Caviar - \"What's Up Danger\"";
		songs[8]="NF - The Search";
		songs[9]="Soulchef - Write This Down x Dead Wrong";
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
        WebElement serachbox= drive.findElement(By.xpath("//input[@placeholder=\"חיפוש\"]"));
		List<WebElement> searchbutton= drive.findElements(By.xpath("//yt-icon[@class='style-scope ytd-searchbox']"));
		
		String com2="מודעה 1 מתוך 2 ·";
		String com3="מודעה 2 מתוך 2 ·";
		String com1="מודעה ·";
	
	
	    
		for (int i = 19; i < songs.length; i++) {
			serachbox.sendKeys(songs[i]);
			Thread.sleep(1500);
			searchbutton.get(1).click();
			Thread.sleep(2000);
			List<WebElement> img=drive.findElements(By.xpath("//yt-formatted-string[@class='style-scope ytd-video-renderer']"));
			img.get(0).click();
		    Thread.sleep(3500);
		    
			  try {
	    			WebElement st1=drive.findElement(By.xpath("//div[@class='ytp-ad-text']"));
			    String ad=st1.getText();
			    	 
			    	  if (ad.equals(com1)) {
			    		 String addDurtion=drive.findElement(By.className("ytp-time-duration")).getText();
			    		 if (addDurtion.equals("0:15")) {
			    			 Thread.sleep(15000);
						}
			    		 else if (addDurtion.equals("0:08")) {
							Thread.sleep(8000);
						}
			    		 else if (addDurtion.equals("0:06")) {
								Thread.sleep(6000);
							}
		  				}
			  } catch (Exception e) {
				  
		    	  }
			    	  	
				  			try {
				  		WebElement st1=drive.findElement(By.xpath("//div[@class='ytp-ad-text']"));
							String ad=st1.getText();
				  			if (ad.equals(com2)) {
				  			Thread.sleep(6000);
				  			drive.findElement(By.xpath("//div[@class='ytp-ad-text ytp-ad-skip-button-text']")).click();
				  		    	}
				  			} catch (Exception e) {
				  			   }
				  			try {
						  		WebElement st1=drive.findElement(By.xpath("//div[@class='ytp-ad-text']"));
									String ad=st1.getText();
						  			if (ad.equals(com3)) {
						  			Thread.sleep(6000);
						  			drive.findElement(By.xpath("//div[@class='ytp-ad-text ytp-ad-skip-button-text']")).click();
						  		    	}
						  			} catch (Exception e) {
						  				
						  			}
			    	 
			    	  
		
			WebElement timedur=drive.findElement(By.className("ytp-time-duration"));
			String time1=timedur.getText();
			time1=time1.replace(':', '.');
		    double durtime=Double.parseDouble(time1);
		    System.out.println(durtime);
			while (durtime==durtime) {
				Thread.sleep(500);
				WebElement screen=drive.findElement(By.xpath("//video[@tabindex='-1']"));
				WebElement barvideo=drive.findElement(By.xpath("//div[@class='ytp-left-controls']"));
				act.moveToElement(screen).perform();
				act.moveToElement(barvideo).perform();
				WebElement curtime=drive.findElement(By.xpath("//span[@class='ytp-time-current']"));
				String curtime1=curtime.getText();
				curtime1=curtime1.replace(':', '.');
				double curtime2=Double.parseDouble(curtime1);
				if (curtime2==durtime-0.04) {
					serachbox.clear();
					break;
				}
			}
		}



	}

}
