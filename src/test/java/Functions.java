import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Functions {
    public WebElement objetoXpath (ChromeDriver driver, String xpathObjeto) {

        WebElement elemento;
        elemento  = driver.findElement(By.xpath(xpathObjeto));

        return elemento;
    }

    public WebElement objetoName (ChromeDriver driver, String nameObjeto) {

        WebElement elemento;

        elemento = driver.findElement(By.name(nameObjeto));

        return elemento;
    }

    public WebElement objetoId (ChromeDriver driver, String Id){
        WebElement elemento;
        elemento = driver.findElement(By.id(Id));
        return elemento;
    }

    public void abrirPagina(ChromeDriver driver, String pagina) {
        driver.get(pagina);
    }

    public void escribir(WebElement elemento, String texto) {
        elemento.sendKeys(texto);

    }

    public void darClic(WebElement elemento) {
        elemento.click();
    }

    public void maximizar(ChromeDriver driver) {
        driver.manage().window().maximize();

    }

    public void espera(int seg) {
        try {
            Thread.sleep(seg*1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void cerrar(ChromeDriver driver) {
        driver.quit();
    }
}
