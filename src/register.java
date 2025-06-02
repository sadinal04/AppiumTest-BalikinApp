import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

public class register extends base {

    public static void main(String[] args) throws Exception {

        AndroidDriver<AndroidElement> driver = capablities();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Buka form register
        driver.findElementByXPath("//android.widget.TextView[@resource-id=\"com.example.mobilebalikin:id/registerTextView\"]").click();

        int maxTry = 5;
        int tryCount = 0;
        boolean isRegistered = false;

        while (!isRegistered && tryCount < maxTry) {
            tryCount++;

            // Generate nama dan email baru
            String name = "John Doe" + tryCount;
            String email = "johndoe" + tryCount + "@example.com";

            // Tunggu field Full Name muncul dan isi
            AndroidElement nameField = (AndroidElement) wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.widget.EditText[@resource-id=\"com.example.mobilebalikin:id/nameEditText\"]")
                )
            );
            nameField.clear();
            nameField.sendKeys(name);

            // Tunggu field Email muncul dan isi
            AndroidElement emailField = (AndroidElement) wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.widget.EditText[@resource-id=\"com.example.mobilebalikin:id/emailEditText\"]")
                )
            );
            emailField.clear();
            emailField.sendKeys(email);

            // Tunggu field Password muncul dan isi
            AndroidElement passwordField = (AndroidElement) wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.widget.EditText[@resource-id=\"com.example.mobilebalikin:id/passwordEditText\"]")
                )
            );
            passwordField.clear();
            passwordField.sendKeys("password123");

            // Klik tombol register
            AndroidElement registerBtn = (AndroidElement) wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.Button[@resource-id=\"com.example.mobilebalikin:id/registerButton\"]")
                )
            );
            registerBtn.click();

            // Tunggu beberapa detik proses
            Thread.sleep(3000);

            // Cek apakah muncul error "email sudah terdaftar"
            try {
                // Contoh deteksi error message, sesuaikan xpath & text error
                AndroidElement errorMsg = (AndroidElement) wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//android.widget.TextView[@resource-id='com.example.mobilebalikin:id/errorTextView']")
                    )
                );
                String errorText = errorMsg.getText();
                System.out.println("Error muncul: " + errorText);

                if (errorText.toLowerCase().contains("email sudah terdaftar")) {
                    System.out.println("Email sudah terdaftar, coba dengan email baru...");
                    // Kembali ke form register untuk coba input ulang
                    driver.navigate().back();
                    driver.findElementByXPath("//android.widget.TextView[@resource-id=\"com.example.mobilebalikin:id/registerTextView\"]").click();
                } else {
                    // Kalau error lain, stop loop atau tangani lain
                    System.out.println("Error lain muncul, stop mencoba.");
                    break;
                }

            } catch (Exception e) {
                // Kalau error message tidak muncul, berarti registrasi berhasil
                isRegistered = true;
                System.out.println("Registrasi berhasil dengan email: " + email);
            }
        }

        if (!isRegistered) {
            System.out.println("Gagal registrasi setelah " + maxTry + " percobaan.");
        }

        driver.quit();
    }
}
