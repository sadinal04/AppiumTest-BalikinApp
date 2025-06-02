import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

public class login extends base {

    public static void main(String[] args) throws Exception {

        AndroidDriver<AndroidElement> driver = capablities();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Isi email
        AndroidElement emailField = (AndroidElement) wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//android.widget.EditText[@resource-id=\"com.example.mobilebalikin:id/emailEditText\"]")
            )
        );
        emailField.clear();
        emailField.sendKeys("johndoe@example.com");

        // Isi password
        AndroidElement passwordField = (AndroidElement) wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//android.widget.EditText[@resource-id=\"com.example.mobilebalikin:id/passwordEditText\"]")
            )
        );
        passwordField.clear();
        passwordField.sendKeys("password123");

        // Klik tombol Login
        AndroidElement loginBtn = (AndroidElement) wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.Button[@resource-id=\"com.example.mobilebalikin:id/loginButton\"]")
            )
        );
        loginBtn.click();

        // Tunggu proses login selesai (misal 5 detik)
        Thread.sleep(5000);

        // Klik tombol Profile di halaman utama
        AndroidElement profileBtn = (AndroidElement) wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("com.example.mobilebalikin:id/navigation_profile")
            )
        );
        profileBtn.click();
        System.out.println("Berhasil klik tombol Profile.");

        // Tunggu halaman profil muncul, ganti id ini dengan id elemen unik di halaman profil kamu
        AndroidElement profileHeader = (AndroidElement) wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("com.example.mobilebalikin:id/profile_header")
            )
        );
        System.out.println("Halaman profil sudah muncul, siap lanjut.");

        // Jangan tutup driver supaya kamu bisa eksplorasi lanjut
        // driver.quit();
    }
}
