import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TambahLaporan extends base {

    public static void main(String[] args) throws Exception {

        AndroidDriver<AndroidElement> driver = capablities();
        
        driver.findElementByXPath("//android.widget.EditText[@resource-id=\"com.example.mobilebalikin:id/emailEditText\"]")
        .sendKeys("johndoe@example.com");

        // Isi Password
        driver.findElementByXPath("//android.widget.EditText[@resource-id=\"com.example.mobilebalikin:id/passwordEditText\"]")
        .sendKeys("password123");

        // Klik tombol Login
		driver.findElementByXPath("//android.widget.Button[@resource-id=\"com.example.mobilebalikin:id/loginButton\"]")
        .click();
		
        WebDriverWait wait = new WebDriverWait(driver, 20);

     // Tunggu hingga semua elemen dengan resourceId muncul
        List<WebElement> navItems = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
            MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.example.mobilebalikin:id/navigation_bar_item_icon_view\")")));

        // Langsung ambil elemen dengan index 2 (elemen ke-3)
        navItems.get(1).click();
        
        // Klik lostButton (lapor barang hilang)
        driver.findElementByXPath("//android.widget.CompoundButton[@resource-id='com.example.mobilebalikin:id/lostButton']").click();

        // Klik tombol add image, buka galeri
        driver.findElementByXPath("//android.widget.Button[@resource-id='com.example.mobilebalikin:id/addImageButton']").click();

  
	     // Tunggu elemen RelativeLayout muncul dan klik
	     AndroidElement relativeLayout = (AndroidElement) wait.until(ExpectedConditions.elementToBeClickable(
	         By.xpath("//android.widget.RelativeLayout")));
	     relativeLayout.click();
	
	     // Tunggu image dengan content-desc spesifik muncul dan klik
	     AndroidElement imageView = (AndroidElement) wait.until(ExpectedConditions.elementToBeClickable(
	         By.xpath("//android.widget.ImageView[@content-desc=\"Photo taken on Jun 2, 2025 6:03:36 PM\"]")));
	     imageView.click();
	     
	  // Setelah memilih gambar, kembali ke app dan isi form
	     driver.findElementByXPath("//android.widget.EditText[@resource-id='com.example.mobilebalikin:id/nameEditText']")
	         .sendKeys("Laptop");

	     driver.findElementByXPath("//android.widget.EditText[@resource-id='com.example.mobilebalikin:id/descriptionEditText']")
	         .sendKeys("Laptop merk XYZ warna hitam");

	     driver.findElementByXPath("//android.widget.EditText[@resource-id='com.example.mobilebalikin:id/locationEditText']")
	         .sendKeys("Kantin Gedung A");

	     driver.findElementByXPath("//android.widget.EditText[@resource-id='com.example.mobilebalikin:id/contactEditText']")
	         .sendKeys("0895416534517");
      
        driver.quit();
    }
}