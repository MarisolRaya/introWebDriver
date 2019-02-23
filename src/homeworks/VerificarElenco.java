package homeworks;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class VerificarElenco {

    static WebDriver driver;

    public static void main(String[] args){

        //configurarNavegador
        configurarNavegador();

        //buscar película

        buscarPelicula("Avengers");



    }

    private static void buscarPelicula(String nombrePelicula) {
        //input[@name="q"]

        WebElement searchTextfield = driver.findElement(By.name("q"));
        searchTextfield.sendKeys(nombrePelicula);

        //button[@id='navbar-submit-button']
        WebElement searchButton = driver.findElement(By.xpath("//button[@id='navbar-submit-button']"));
        searchButton.click();


    }

    private static void configurarNavegador() {
        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("--disable-notifications");
        opts.addArguments("--start-maximized");

        //System.setProperty("webdriver.chrome.driver", "C:\\test_automation\\drivers\\chromedriver.exe");
        driver = new ChromeDriver(opts);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.imdb.com/");



    }

}
