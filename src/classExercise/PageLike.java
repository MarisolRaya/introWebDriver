package classExercise;

/*
* - Definicion del objetivo del caso de prueba.
   - Corrida manual
   - preparar la prueba
        + HAcer el caso de prueba - pasos y verificaciones.
        + Definir que elementos voy a interactuar.  - id, path, name (localizadores)
        +
    -Implementacion del caso de prueba.
        + Crear la clase de prueba.
        + encontrar los elementos
        + manipular los elementos
        + verificar la existencia/estado de los elementos.*/

import org.openqa.selenium.WebDriver;

/**
 * This test case searches for a user's favorite page on facebook, and likes it.
 */
public class PageLike {
    public WebDriver driver;
    public static void main(String[] args) {
        //arrancar el browser
        //navegar a facebook
        //hacer login
        //buscar la pagina que necesito
        //buscar el boton de like correcto.
        //element xpath="//*[@data-testid='browse-result-content' and contains(.,'The best in technology, science, aerospace, DIY and auto news.')]//button[ contains(@class, 'PageLikeButton')]";
        //darle click al boton

        //verificar que cambio a 'te gusta'
        //element xpath="//*[@data-testid='browse-result-content' and contains(.,'The best in technology, science, aerospace, DIY and auto news.')]//button[ contains(@class, 'PageLikedButton')]";


    }
}