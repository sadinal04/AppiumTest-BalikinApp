import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LaporTemuan extends base {

    public static void main(String[] args) throws Exception {

        AndroidDriver<AndroidElement> driver = capablities();

        WebDriverWait wait = new WebDriverWait(driver, 20);

        // Login
        AndroidElement emailField = (AndroidElement) wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.EditText[@resource-id=\"com.example.mobilebalikin:id/emailEditText\"]")));
        emailField.sendKeys("johndoe@example.com");

        AndroidElement passwordField = (AndroidElement) wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.EditText[@resource-id=\"com.example.mobilebalikin:id/passwordEditText\"]")));
        passwordField.sendKeys("password123");

        AndroidElement loginButton = (AndroidElement) wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.Button[@resource-id=\"com.example.mobilebalikin:id/loginButton\"]")));
        loginButton.click();

        // Navigasi ke tab Laporan (index 1)
        List<WebElement> navItems = wait.until(
            ExpectedConditions.presenceOfAllElementsLocatedBy(
                MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.example.mobilebalikin:id/navigation_bar_item_icon_view\")")));
        navItems.get(1).click();

        // Tunggu foundButton bisa diklik dan klik
        AndroidElement foundButton = (AndroidElement) wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.CompoundButton[@resource-id='com.example.mobilebalikin:id/foundButton']")));
        foundButton.click();

        // Klik Add Image
        AndroidElement addImageButton = (AndroidElement) wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.Button[@resource-id='com.example.mobilebalikin:id/addImageButton']")));
        addImageButton.click();

        // Tunggu galeri muncul, klik pertama (RelativeLayout)
        AndroidElement relativeLayout = (AndroidElement) wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.RelativeLayout")));
        relativeLayout.click();

        // Klik folder "Download"
        AndroidElement downloadFolder = (AndroidElement) wait.until(
            ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Download\")")));
        downloadFolder.click();

        // Tunggu dan klik gambar di folder Download
        AndroidElement imageView = (AndroidElement) wait.until(
            ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().descriptionContains(\"Photo taken on Jun 2, 2025\")")));
        imageView.click();

        // Isi form laporan
        AndroidElement nameField = (AndroidElement) wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.EditText[@resource-id='com.example.mobilebalikin:id/nameEditText']")));
        nameField.sendKeys("Kunci");

        AndroidElement descField = (AndroidElement) wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.EditText[@resource-id='com.example.mobilebalikin:id/descriptionEditText']")));
        descField.sendKeys("Kunci rumah dan honda satu paket ni");

        AndroidElement locationField = (AndroidElement) wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.EditText[@resource-id='com.example.mobilebalikin:id/locationEditText']")));
        locationField.sendKeys("Ruang D.03.05");

        AndroidElement contactField = (AndroidElement) wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.EditText[@resource-id='com.example.mobilebalikin:id/contactEditText']")));
        contactField.sendKeys("0811263789467");

        // Klik tombol Submit / Simpan
        AndroidElement submitButton = (AndroidElement) wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.Button[@resource-id='com.example.mobilebalikin:id/submitButton']")));
        submitButton.click();

        // Tunggu kembali ke halaman utama (tunggu sampai tombol "Ditemukan" muncul)
        AndroidElement ditemukanTab = (AndroidElement) wait.until(
            ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().description(\"Ditemukan\")")));
        ditemukanTab.click();
        
        //Klik Detail Barang
        AndroidElement laporanItem = (AndroidElement) wait.until(
        	ExpectedConditions.elementToBeClickable(
        		MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.LinearLayout\").instance(8)")));
        laporanItem.click();
        
    }
}
