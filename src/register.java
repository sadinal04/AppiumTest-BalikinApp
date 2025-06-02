import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

public class register extends base {

    public static void main(String[] args) throws Exception {

        AndroidDriver<AndroidElement> driver = capablities();

        // Klik tombol register untuk buka form register
        driver.findElementByXPath("//android.widget.TextView[@resource-id=\"com.example.mobilebalikin:id/registerTextView\"]").click();

        // Buat WebDriverWait, tunggu maksimal 10 detik
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Tunggu sampai field Full Name muncul dan siap diisi
        AndroidElement nameField = (AndroidElement) wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//android.widget.EditText[@resource-id=\"com.example.mobilebalikin:id/nameEditText\"]")
            )
        );
        nameField.sendKeys("John Doe");

        // Tunggu field Email siap dan isi
        AndroidElement emailField = (AndroidElement) wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//android.widget.EditText[@resource-id=\"com.example.mobilebalikin:id/emailEditText\"]")
            )
        );
        emailField.sendKeys("johndoe@example.com");

        // Tunggu field Password siap dan isi
        AndroidElement passwordField = (AndroidElement) wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//android.widget.EditText[@resource-id=\"com.example.mobilebalikin:id/passwordEditText\"]")
            )
        );
        passwordField.sendKeys("password123");

        // Tunggu tombol Register siap dan klik
        AndroidElement registerBtn = (AndroidElement) wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.Button[@resource-id=\"com.example.mobilebalikin:id/registerButton\"]")
            )
        );
        registerBtn.click();

        // Tunggu proses selesai (opsional)
        Thread.sleep(10000);

        driver.quit();
    }
}
