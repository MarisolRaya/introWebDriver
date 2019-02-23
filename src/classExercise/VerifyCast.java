package classExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class VerifyCast {

    public static WebDriver driver;

    public static void main(String[] args) {
        //Caso de prueba
        driver = new ChromeDriver();
        //Paso # 1 Navegar a imdb.com
        //no interaction with any alements.  only driver.get
        driver.get("https://imdb.com");
        //Paso # 2 Buscar la pelicula 'Batman'
        //elements:  search box  id="navbar-query";
        WebElement searchBox = driver.findElement(By.id("navbar-query"));
        searchBox.sendKeys("Batman");

        //elements: search button id="navbar-submit-button";
        WebElement searchbutton =driver.findElement(By.id("navbar-submit-button"));
        searchbutton.click();


        //Paso # 3 Verificar la existencia de la pelicula con el mismo nombre distintos anio
        //elementos con xpath="//tr[ contains(@class, 'findResult')  ]//a[text() = 'Batman']";
        List<WebElement> listaPeliculas = driver.findElements(By.xpath("//tr[ contains(@class, 'findResult') ]//a[text() = 'Batman']"));
        System.out.println(listaPeliculas.size());
        int tamanoListaPeliculas = listaPeliculas.size();
        if(tamanoListaPeliculas >=2 ) {
            System.out.println("Test Step 3 Passed.");
        } else {
            System.out.println("Test Step 3 Failed.  There is " + tamanoListaPeliculas + " movie.");
        }


        //Paso # 4 Seleccionar la pelicula requerida (1989)
        //elemento con xpath = "//td[contains(., '1989')]/a[text() = 'Batman']";
        WebElement peliculaCorrecta = driver.findElement(By.xpath("//td[contains(., '1989')]/a[text() = 'Batman']"));
        peliculaCorrecta.click();

        //Paso # 5 Verificar que existe la sección "Cast";
        //elemento con id="titleCast";
        WebElement castSection = driver.findElement(By.id("titleCast"));
        if(castSection.isDisplayed() ) {
            System.out.println("Test Step 5 Passed.");
        } else {
            System.out.println("Test Step 5 Failed.");
        }

        //Paso # 6 Verificar el elenco
//elementos linkText=<nombre del actor>
        WebElement actor1= driver.findElement(By.linkText("Michael Keaton"));
        if(actor1.isDisplayed() ) {
            System.out.println("Test Step 6 Passed.");
        } else {
            System.out.println("Test Step 6 Failed.");
        }
        //actor 1 Michael Keaton
        //actor 2 Jack Nicholson
        //actriz 3 Kim Basinger
    }
}