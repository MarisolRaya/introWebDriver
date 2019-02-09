package classExercise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FacebookAddFriend {

	static WebDriver driver; 

	public static void main(String[] args) { 

		//configurarNavegador 

		configurarNavegador(); 

		//login 

		logearFacebook("facebook.selenium.marisol@gmail.com", "Test1234$");

		//buscar 

		buscarAmigo("Pedro Morales");

		//agregar 

		agregarAmigo("nombreAmigo"); 
		
		//destruirConfiguracion();

	} 


	private static void destruirConfiguracion() {
		driver.close();
		
	}


	private static void configurarNavegador() {
		ChromeOptions opts = new ChromeOptions();
		opts.addArguments("--disable-notifications");
		opts.addArguments("--start-maximized");

		//System.setProperty("webdriver.chrome.driver", "C:\\test_automation\\drivers\\chromedriver.exe"); 
		driver = new ChromeDriver(opts);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		driver.get("http://www.facebook.com"); 

	} 

	private static void logearFacebook(String usuario, String password) { 
		WebElement campoUsuario; //id=email
		WebElement campoPassword; //id="pass"
		WebElement botonLogin; //data-testid="royal_login_button"
		
		campoUsuario = driver.findElement(By.id("email"));
		campoPassword = driver.findElement(By.id("pass"));
		botonLogin = driver.findElement(By.xpath("//input[@data-testid='royal_login_button']"));
		
		campoUsuario.clear();
		campoUsuario.sendKeys(usuario);
		campoPassword.clear();
		campoPassword.sendKeys(password);
		botonLogin.click();
	} 

	private static void agregarAmigo(String string) {
		//Buscar el botón "Añadir a mis amigos"
		WebElement searchButton =driver.findElement(By.xpath("//div[@id='u_v_4']//button[@class='_42ft _4jy0 FriendRequestAdd addButton _4jy3 _517h _51sy']"));

		//Clic en el botón
		searchButton.click();
		//Etiqueta de botón
		//Xpath: //button[@id='js_hf'][contains(text(), 'Solicitud de amistad enviada')]
		WebElement friendlink  = driver.findElement(By.xpath("//button[@class='_42ft _4jy0 FriendRequestOutgoing enableFriendListFlyout outgoingButton _4jy3 _517h _51sy'][@id='js_1oo']"));
		if (friendlink.isDisplayed())
			System.out.println("Se envío correctamente la solicitud");
		else{
			System.out.println("La solicitud no fue enviada");
		}

	}

	private static void buscarAmigo(String nombreAmigo) {
	//buscar el campo de texto para buscar

		WebElement searchTextfield = driver.findElement(By.name("q"));
		searchTextfield.sendKeys(nombreAmigo);
		// dar click en el botón "lupa"
		//xpath: //button[@data-testid='facebar_search_button']
		WebElement searchButton = driver.findElement(By.xpath("//i[@class='_585_']"));
		searchButton.click();

		//buscar nombre Pedro Morales
		WebElement friendlink =driver.findElement(By.linkText(nombreAmigo));
		if(friendlink.isDisplayed())
			System.out.println("Mi amigo " + nombreAmigo+ "esta en los resultados");
		else{
			System.out.println("Mi amigo " + nombreAmigo+ "no esta en los resultados");
			System.exit( -1);
		}

	}


}
