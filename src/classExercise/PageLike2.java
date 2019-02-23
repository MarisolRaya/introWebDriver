package classExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageLike2 extends FacebookAddFriend{

    public static void main(String[] args) {
        //arrancar el browser
        //navegar a facebook
        configurarNavegador ();

        //hacer login
        logearFacebook("facebook.selenium.marisol@gmail.com", "Test1234$");
        //buscar la pagina que necesito
        buscarAmigo("Popular Mechanics");
        //buscar el boton de like correcto.
        //element xpath="//*[@data-testid='browse-result-content' and contains(.,'The best in technology, science, aerospace, DIY and auto news.')]//button[ contains(@class, 'PageLikeButton')]";
        WebElement botonLike = driver.findElement(By.xpath("//*[@data-testid='browse-result-content' and contains(.,'The best in technology, science, aerospace, DIY and auto news.')]//button[ contains(@class, 'PageLikeButton')]"));
        botonLike.click();
        //darle click al boton

        //verificar que cambio a 'te gusta'
        //element xpath="quot;//*[@data-testid='browse-result-content' and contains(.,'The best in technology, science, aerospace, DIY and auto news.')]//button[ contains(@class, 'PageLikedButton')]";
        WebElement butonTeGusta = driver.findElement(By.xpath("//*[@data-testid='browse-result-content' and contains(.,'The best in technology, science, aerospace, DIY and auto news.')]//button[ contains(@class, 'PageLikedButton')]"));
        System.out.println(butonTeGusta.getText());
        if(butonTeGusta.getText().contains("Liked")) {
            System.out.println("Test Passed");
        }
        else
        System.out.println("Test Failed.");

        driver.close ();
    }

}
