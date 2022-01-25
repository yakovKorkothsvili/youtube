package selenium;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class youtubeBOT {

	public static void main(String[] args) throws InterruptedException {
		Scanner scan= new Scanner(System.in);
		for (int i = 0; i < 20; i++) {	
		for (int j = 0; j < 20; j++) {		
		System.out.println("put the name of a song");
		String a= scan.nextLine();
		a.trim();
		WebDriverManager.chromedriver().setup();
		WebDriver drive= new ChromeDriver();
		drive.get("https://www.youtube.com/");
		Actions act=new Actions(drive);
		drive.findElement(By.xpath("//input[@placeholder=\"חיפוש\"]")).sendKeys(a);
		Thread.sleep(2000);
		List<WebElement> searchbut= drive.findElements(By.xpath("//yt-icon[@class='style-scope ytd-searchbox']"));
		searchbut.get(1).click();
		Thread.sleep(3000);
		List<WebElement> img=drive.findElements(By.xpath("//yt-formatted-string[@class='style-scope ytd-video-renderer']"));
		img.get(0).click();
		Thread.sleep(3000);
	
		System.out.println("if u want to stop the song or to continue the song type: 's/p'");
		System.out.println("if u want to skip the song type: 'next'");
		System.out.println("but if u want to close the song type: 'close'");
		String b=scan.nextLine();
		b.trim();
		
		
             while (b.equals("next")) {
	 
	           WebElement next=drive.findElement(By.xpath("//a[@class='ytp-next-button ytp-button']"));
	              next.click();
	                b=scan.nextLine();
	                 b.trim();
               }
		

		
		WebElement sp= drive.findElement(By.xpath("//button[@title='השהיה (k)' or @title='הפעלה (k)']"));
		while (b.equals("s/p")) {
			
            act.moveToElement(sp).click().perform();
			b=scan.nextLine();
			b.trim();
			   if (b.equals("next")) {
    	        	WebElement next=drive.findElement(By.xpath("//a[@class='ytp-next-button ytp-button']"));
    	        	next.click();
				}
			if (b.equals("close")) {
				break;
			} 
		}
		if (b.equals("next")) {break;}
			while (!"close".equals(b)&&!"s/p".equals(b)&&!"next".equals(b)) {
				  System.out.println("if u want to stop the song or to continue the song type: 's/p'");
				   System.out.println("but if u want to close the song type: 'close'");
				   System.out.println(" if u want to skip the song type: 'next'");
			          b=scan.nextLine();
				       b.trim();
				         if (b.equals("s/p")) {
					        break;
				            }
			     	         if (b.equals("close")) {
				    	          break;
				                    }
			     	         if (b.equals("next")) {
			     	        	WebElement next=drive.findElement(By.xpath("//a[@class='ytp-next-button ytp-button']"));
			     	        	next.click();
							}
				                 }
				if (b.equals("close")) {
					drive.quit();
					break;
				 }
		     while (!"close".equals(b)) {
			     System.err.println("plz write: 'close'");
		        	b=scan.nextLine();
		        	if (b.equals("close")) {
		    			drive.quit();
		    			break;
		    		}
	             }
		          }
	        	}
		
		
		
	 }		
	}


