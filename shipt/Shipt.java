import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.testng.Assert;




public class Shipt {
	static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Selenium\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Selenium\\chromedriver.exe");
		//System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "C:\\Users\\Selenium\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver", "C:\\Users\\Selenium\\IEDriverServer.exe");
		//System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY, "C:\\Users\\Selenium\\IEDriverServer.exe");
		//driver = new FirefoxDriver();
		//driver = new InternetExplorerDriver();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to("http://www.shipt.com/");
		driver.findElement(By.xpath("//*[@id='main']/div[1]/header/nav/a[6]")).click();
		driver.findElement(By.xpath("//*[@id='myid']/div/ion-content/div/div/div/div[2]/form/div/label[1]/input")).sendKeys("qatest@shipt.com");
		//type in password
		driver.findElement(By.xpath("//*[@id='myid']/div/ion-content/div/div/div/div[2]/form/div/label[2]/input")).sendKeys("Sh1pt123!");
		//click Login button to login
		driver.findElement(By.xpath("//*[@id='start_shopping_login_button']")).click();
		
		//type Orange in search
		//driver.findElement(By.xpath("html/body/ion-nav-view/ion-side-menus/ion-side-menu-content/ion-nav-bar/div[2]/ion-header-bar/div[2]/span/div/form/label/input")).sendKeys("Naval Orange");
		//driver.findElement(By.id("search")).sendKeys("Naval Orange");
		driver.findElement(By.id("search")).sendKeys("gala apple");
		Thread.sleep(4000);
		//click on Search button
		driver.findElement(By.xpath("//*[@id='homeIonContent']/div/div/shipt-web-header/div/div/div[2]/form/button")).click();
		//get the count of the search items listed on the page
		//List<WebElement> search_list= driver.findElements(By.xpath("html/body/ion-nav-view/ion-side-menus/ion-side-menu-content/ion-nav-view/ion-view[1]/ion-content/div/div/div/div[1]/div[2]/div"));
		//html/body/ion-nav-view/ion-side-menus/ion-side-menu-content/ion-nav-view/ion-view[1]/ion-content/div/div/div/div[1]/div[2]/div
		//List<WebElement> search_list= driver.findElements(By.xpath("html/body/ion-nav-view/ion-side-menus/ion-side-menu-content/ion-nav-view/ion-view[1]/ion-content/div/div/div/div[1]/div[2]/div"));
		//System.out.println("Total items found under search: "+search_list.size());
		//driver.findElement(By.xpath("//*[@class='img-products-list' and @src='https://d1y8xhkcoitdtz.cloudfront.net/images/products/thumb_8864-04170609.png']")).click();
		//click on the selected item box
		driver.findElement(By.xpath("html/body/ion-nav-view/ion-side-menus/ion-side-menu-content/ion-nav-view/ion-view[1]/ion-content/div/div/div/div[1]/div[2]/div/div[1]/ion-item")).click();
		//get the name of the item
		//String item1 = driver.findElement(By.xpath("html/body/div[10]/div[2]/div/shipt-web-modal/div/div[1]/div/div/div/div/ng-transclude/div/ion-list/div/div[2]/div[1]/h1")).getText();
		String item1 = driver.findElement(By.xpath("//div[@class='product-name']/h1")).getText();
		System.out.println("First item is: "+item1);		
		//get the price for the item
		String price_item1 = driver.findElement(By.xpath("//div[@class='prices']/h1")).getText();
		System.out.println("First item price: "+price_item1);
		Thread.sleep(2000);
		//click Add to Cart
		driver.findElement(By.xpath("//div[@class='cart-text-container']/h1")).click();
		//Go back to the shipt.com
		driver.get("https://shop.shipt.com/#/app/home");
		
		//Shopping by Category
		//click on the Shop By Category tab
		driver.findElement(By.xpath("//*[@id='homeIonContent']/div/div/shipt-web-subheader/div/div/button[1]")).click();
		//click on Dairy and Eggs - 7th option
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='list']/ion-item[7]")).click();
		//driver.findElement(By.xpath("html/body/div[10]/div/div/ion-popover-view/ion-content/div/div[2]/ion-list/div/ion-item[7]")).click();
		//click and select an item box 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='row responsive-md']/div[4]/ion-item")).click();
		//get the name of the 2nd item
		String item2 = driver.findElement(By.xpath("//div[@class='product-name']/h1")).getText();
		System.out.println("Second item is: "+item2);
		//get the price for the item
		String price_item2 = driver.findElement(By.xpath("//div[@class='prices']/h1")).getText();
		System.out.println("Second item price: "+price_item2);
		Thread.sleep(2000);
		//click Add to Cart
		driver.findElement(By.xpath("//div[@class='cart-text-container']/h1")).click();
		//Go back to the shipt.com
		driver.get("https://shop.shipt.com/#/app/home");
		//click on the shopping cart
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='inner-web-header padding-left-right']/web-cart-button/button")).click();
		//driver.findElement(By.tagName("web-cart-button")).click();
		
		//get the number of of items in cart
		String cart_items=driver.findElement(By.xpath("//div[@class='cart-items-area']//div/div[1]/span[2]")).getText();
		System.out.println("Number of items in Cart: "+cart_items);
		//extracting the first character(number) from the cart_items string
		String str_num = cart_items.substring(0,1);
		System.out.println("the number is: "+str_num);
		int num = Integer.parseInt(str_num);
		
		if (num <2){
			System.out.println("Added items do Not show up in cart - serious application error, closing application");
			driver.close();
		}else{
		//Get the name of the item last added in Cart
		String last_in_cart_item_name = driver.findElement(By.xpath("//div[@class='cart-items-area']/div/div["+(num+1)+"]/div[3]/div/p")).getText();
		//System.out.println("Last item name: "+last_in_cart_item_name);	

		//Verify if the last item in cart is the same item last added 		
		try{
			Assert.assertEquals(last_in_cart_item_name, item2);
			System.out.println("The last item in cart is the same item that was last added - item name matches correctly");
			//Assert.assertTrue("error message", 3>1);
		}catch(Throwable t){
			// code to report error
			//errCol.addError(t);
			System.out.println("Last item added to cart is NOT the same item as in the Cart - incorrect"); 
			System.out.println(t.getMessage());
			//code to report the error in testng
			//ErrorUtil.addVerificationFailure(t);
			//fail = true;
			return;
		}
		
		//Get the price of the item that was last added in Cart
		String last_in_cart_item_price = driver.findElement(By.xpath("//div[@class='cart-items-area']/div/div["+(num+1)+"]/div[1]/p/span")).getText();
		//String last_in_cart_item_price = driver.findElement(By.xpath("//div[@class='price text-center']/p/span")).getText();
		System.out.println("Last item price: "+last_in_cart_item_price);
		//Verify if the last item in cart is the same item last added 		
		try{
			Assert.assertEquals(last_in_cart_item_price, price_item2);
			System.out.println("The last item added has the same price as in the cart - item price matches correctly");
			//Assert.assertTrue("error message", 3>1);
		}catch(Throwable t){
			// code to report error
			//errCol.addError(t);
			System.out.println("Price does Not match for the last item added to the card - incorrect"); 
			System.out.println(t.getMessage());
			//code to report the error in testng
			//ErrorUtil.addVerificationFailure(t);
			//fail = true;
			return;
		}
		
		//Get the name of the first item added in Cart
		String secondtoLast_cart_item_name = driver.findElement(By.xpath("//div[@class='cart-items-area']/div/div["+num+"]/div[3]/div/p")).getText();
		//System.out.println("First item name: "+secondtoLast_cart_item_name);
		
		//Verify if the first item in cart is the same item that was first added 
		try{
			Assert.assertEquals(secondtoLast_cart_item_name, item1);
			System.out.println("First item in cart is the same item that was first added - the item name matches correctly");
			//Assert.assertTrue("error message", 3>1);
		}catch(Throwable t){
			// code to report error
			//errCol.addError(t);
			System.out.println("First item added is NOT the same item as in the Cart - incorrect"); 
			System.out.println(t.getMessage());
			//code to report the error in testng
			//ErrorUtil.addVerificationFailure(t);
			//fail = true;
			return;
		}
		
		
		//Get the price of the item that was first added in Cart
		String secondtolast_in_cart_item_price = driver.findElement(By.xpath("//div[@class='cart-items-area']/div/div["+num+"]/div[1]/p/span")).getText();
		System.out.println("First item price: "+secondtolast_in_cart_item_price);
		//Verify if the last item in cart is the same item last added 		
		try{
			Assert.assertEquals(secondtolast_in_cart_item_price, price_item1);
			System.out.println("The first item added has the same price as in the cart - item price matches correctly");
			//Assert.assertTrue("error message", 3>1);
		}catch(Throwable t){
			// code to report error
			//errCol.addError(t);
			System.out.println("Price does Not match for the first item added to the card - incorrect"); 
			System.out.println(t.getMessage());
			//code to report the error in testng
			//ErrorUtil.addVerificationFailure(t);
			//fail = true;
			return;
		}
		
		driver.close();
		
		}

	}

	
}
