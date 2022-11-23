package Base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class BaseStep {

    public WebDriver driver;

    //Locators
    By productNameLocator = By.className("product-item__brand");
    By searchBoxLocator = By.id("txtSearchBox");
    By addToCartButtonLocator = By.id("addToCartBtn");
    By showCart = By.id("btnShowCart");
    By productNameLocatorCart = By.className("cx-link");

    public BaseStep() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void geturl() {
        driver.get("https://www.e-bebek.com/");
    }

    public WebElement find(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }

    public void enter(By locator){
        find(locator).sendKeys(Keys.ENTER);
    }

    public void click(By locator){
        find(locator).click();
    }

    public void type(By locator, String text){
        find(locator).sendKeys(text);
    }

    public void search(String text) {
        type(searchBoxLocator, text);
        enter(searchBoxLocator);
    }

    private List<WebElement> getAllProducts(){
        return findAll(productNameLocator);
    }

    public void selectProduct(int i) {
        getAllProducts().get(i).click();
    }

    public void addToCart() {
        click(addToCartButtonLocator);
    }

    public void goToCart() {
        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(showCart));
        click(showCart);
    }

    public boolean checkIfProductAddedtoCart() {
        return getProducts().size() > 0;
    }

    private List<WebElement> getProducts(){
        WebDriverWait wait = new WebDriverWait(driver,2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(productNameLocatorCart));
        return findAll(productNameLocatorCart);
    }

    public void driverQuit() {
        driver.quit(); }
}
