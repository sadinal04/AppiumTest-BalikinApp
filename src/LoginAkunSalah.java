import java.util.Random;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LoginAkunSalah extends base {

    public static void main(String[] args) throws Exception {

        AndroidDriver<AndroidElement> driver = capablities();

        // Generate random email dan password
        String randomEmail = "random" + new Random().nextInt(1000) + "@mail.com";
        String randomPassword = "invalidPass" + new Random().nextInt(1000);

        // Isi Email
        driver.findElementByXPath("//android.widget.EditText[@resource-id=\"com.example.mobilebalikin:id/emailEditText\"]")
            .sendKeys(randomEmail);

        // Isi Password
        driver.findElementByXPath("//android.widget.EditText[@resource-id=\"com.example.mobilebalikin:id/passwordEditText\"]")
            .sendKeys(randomPassword);

        // Klik tombol Login
        driver.findElementByXPath("//android.widget.Button[@resource-id=\"com.example.mobilebalikin:id/loginButton\"]")
            .click();

        // Tambahkan delay untuk cek error message jika ada
        Thread.sleep(3000); // atau bisa pakai WebDriverWait untuk validasi

        // Tutup driver
        driver.quit();
    }
}