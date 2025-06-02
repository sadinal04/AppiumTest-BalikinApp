import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class EditProfile extends base {

    public static void main(String[] args) throws Exception {

        AndroidDriver<AndroidElement> driver = capablities();

        // Isi email
        driver.findElementByXPath("//android.widget.EditText[@resource-id=\"com.example.mobilebalikin:id/emailEditText\"]")
            .sendKeys("johndoe@example.com");

        // Isi Password
        driver.findElementByXPath("//android.widget.EditText[@resource-id=\"com.example.mobilebalikin:id/passwordEditText\"]")
            .sendKeys("password123");

        // Klik tombol Login
        driver.findElementByXPath("//android.widget.Button[@resource-id=\"com.example.mobilebalikin:id/loginButton\"]")
            .click();
        
        WebDriverWait wait = new WebDriverWait(driver, 10);
        
        // Tunggu hingga semua elemen dengan resourceId muncul
        List<WebElement> navItems = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
            MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.example.mobilebalikin:id/navigation_bar_item_icon_view\")")));

        // Langsung ambil elemen dengan index 2 (elemen ke-3)
        navItems.get(2).click();

        AndroidElement editProfileButton = (AndroidElement) wait.until(ExpectedConditions.elementToBeClickable(
            MobileBy.id("com.example.mobilebalikin:id/editProfileButton")));
        editProfileButton.click();

        // Isi Nama dan Nomor Telepon
        driver.findElementByXPath("//android.widget.EditText[@resource-id=\"com.example.mobilebalikin:id/nameEditText\"]").sendKeys("Sadinal Mufti");
        driver.findElementByXPath("//android.widget.EditText[@resource-id=\"com.example.mobilebalikin:id/phoneEditText\"]").sendKeys("085244559378");
        
        // Klik tombol Save
        driver.findElementByXPath("//android.widget.Button[@resource-id=\"com.example.mobilebalikin:id/saveButton\"]").click();
        
        // Tunggu elemen yang menandakan penyimpanan berhasil atau perubahan halaman
        AndroidElement successMessage = (AndroidElement) wait.until(ExpectedConditions.visibilityOfElementLocated(
            MobileBy.id("com.example.mobilebalikin:id/save_success_message")));  // Gantilah dengan ID yang sesuai untuk pesan sukses

        System.out.println("Profile successfully updated.");
        
        // Jika ada elemen sukses, lanjutkan, jika tidak, tunggu elemen lain atau timeout
        // driver.quit(); // Jangan quit dulu, tetap biarkan driver hidup untuk eksplorasi
    }
}
