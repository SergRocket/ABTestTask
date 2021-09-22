package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

public class MainPage extends BasePage {
    @FindBy(css = "select[class='product_sort_container']")
    private WebElement filterBody;
    @FindBy(css = "option[value='lohi']")
    private WebElement filterFromCheap;
    @FindBy(css = "option[value='hilo']")
    private WebElement filterFromHight;
    @FindBy(css = "div.pricebar > div")
    private WebElement prices;
    @FindBy(css = ".inventory_container > div")
    private WebElement goodsList;
    @FindBy(css = "button[id*='add-to-cart']")
    private WebElement addButton;
    @FindBy(css = ".shopping_cart_badge")
    private WebElement cartQnt;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddButton(){
        try {
            waitForElementToBeVisible(addButton, 5);
        } catch (NoSuchElementException n){
            System.out.print("The add button is not shown");}
        List<WebElement> addButton = driver.findElements(By.cssSelector("button[id*='add-to-cart']"));
        elementClick(addButton.get(0));
        }

        public boolean cartQntUpdated(){
        String cartText = driver.findElement(By.cssSelector(".shopping_cart_badge")).getText();
        int cartQnt = Integer.parseInt(cartText);
        return cartQnt > 0;
        }

    public boolean isGoodsListDysplayed() {
        try {
            waitForElementToBeVisible(goodsList, 5);
            if (goodsList.isDisplayed()) {
                return true;
            }
        } catch (NoSuchElementException n) {
            System.out.print("The element is not visible");
        }
        return goodsList.isDisplayed();
    }

    public void selectFromHigh(){
        elementClick(filterBody);
        elementClick(filterFromHight);
    }

    public void selectFromLow(){
        elementClick(filterBody);
        elementClick(filterFromCheap);
    }

    public boolean checkFromLowPrices(){
        List<WebElement> fromLowPrices = driver.findElements(By.cssSelector("div.pricebar > div"));
        double firstPrice = Double.parseDouble(fromLowPrices.get(0).getText().replace("$", ""));
        double lastPrice = Double.parseDouble(fromLowPrices.get(fromLowPrices.size()-1).getText().replace("$", ""));
        return firstPrice < lastPrice;
    }

    public boolean checkFromHighPrices(){
        List<WebElement> fromLowPrices = driver.findElements(By.cssSelector("div.pricebar > div"));
        double firstPrice = Double.parseDouble(fromLowPrices.get(0).getText().replace("$", ""));
        double lastPrice = Double.parseDouble(fromLowPrices.get(fromLowPrices.size()-1).getText().replace("$", ""));
        return firstPrice > lastPrice;
    }

}
