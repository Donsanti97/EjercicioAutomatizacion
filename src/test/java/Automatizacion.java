
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;


public class Automatizacion {

    private WebDriver driver;
    private ReadExcelFiles leerArchive;


    Functions f = new Functions();



    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/java/ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();

        leerArchive = new ReadExcelFiles();

        f.maximizar((ChromeDriver) driver);

        driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");

    }
    @After
    public void tearDown(){
        f.espera(5);
        driver.quit();

    }
    @Test
    public void test() throws IOException {
        String filePath = "src/test/java/Files/DataFile.xlsx";

        //Login
        String buscarTexto1 = leerArchive.getCelValue(filePath, "Hoja1", 1,0);
        f.escribir(f.objetoXpath((ChromeDriver) driver, "//input[@name = 'txtUsername']"), buscarTexto1);
        String buscarTexto2 = leerArchive.getCelValue(filePath, "Hoja1", 1,1);
        f.escribir(f.objetoXpath((ChromeDriver) driver, "//input[@name = 'txtPassword']"), buscarTexto2);
        f.darClic(f.objetoXpath((ChromeDriver) driver, "//input[@id='btnLogin']"));

        String resultText = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/h1")).getText();
        System.out.println("Texto: " + resultText);

        //Registro nuevo usuario
        f.darClic(f.objetoXpath((ChromeDriver) driver, "//a[@id='menu_admin_viewAdminModule']"));
        f.darClic(f.objetoXpath((ChromeDriver) driver,"//input[@id='btnAdd']"));
        f.darClic(f.objetoXpath((ChromeDriver) driver,"//select[@id='systemUser_userType']"));
        f.darClic(driver.findElement(By.cssSelector("#systemUser_userType > option:nth-child(2)")));
        String ocupacion = leerArchive.getCelValue(filePath, "Hoja1", 3,2);
        f.escribir(f.objetoXpath((ChromeDriver) driver, "//input[@id ='systemUser_employeeName_empName']"), ocupacion);
        String user = leerArchive.getCelValue(filePath, "Hoja1", 3,0);
        f.escribir(f.objetoXpath((ChromeDriver) driver, "//input[@id = 'systemUser_userName']"), user);
        f.darClic(f.objetoXpath((ChromeDriver) driver,"//select[@id='systemUser_status']"));
        f.darClic(driver.findElement(By.cssSelector("#systemUser_status > option:nth-child(1)")));
        //Assert.assertEquals(DDPage.selectOptions(), "Enabled");
        String pass = leerArchive.getCelValue(filePath, "Hoja1", 3,1);
        f.escribir(f.objetoXpath((ChromeDriver) driver, "//input[@id ='systemUser_password']"), pass);
        String passConfirm = leerArchive.getCelValue(filePath, "Hoja1", 3,1);
        f.escribir(f.objetoXpath((ChromeDriver) driver, "//input[@id ='systemUser_confirmPassword']"), passConfirm);
        f.darClic(f.objetoXpath((ChromeDriver) driver, "//input[@id ='btnSave']"));

    }
}
