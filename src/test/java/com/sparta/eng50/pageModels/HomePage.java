package com.sparta.eng50.pageModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {

    By notificationBox = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2");
    By addToCartButton = By.xpath("//*[@id=\"homefeatured\"]/li[6]/div/div[2]/div[2]/a[1]");
    By proceedToCheckoutButton = By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a");

    /*
    By addToCartButton = By.linkText("Add to cart");
    By proceedToCheckoutButton = By.linkText("Proceed to checkout");
    */

    By firstItem = By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[1]/img");
    By womensButton = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a");

    By tshirtButtonInDropdown = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a");
    By specialsButton =By.id("footer");

//choose one 

    //By tshirtButtonInDropdown = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a");


    WebDriverWait wait = new WebDriverWait(webDriver, 120);



    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage navigateToHomePage() {
        webDriver.get("http://automationpractice.com/index.php");
        return this;
    }

	//note: choose one!
    public void addItemToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
        webDriver.findElement(addToCartButton).click();
    }

	/*
    public ShoppingCartSummaryPage proceedToCheckout() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckoutButton));
	*/
    public void proceedToCheckout() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckoutButton));
        webDriver.findElement(proceedToCheckoutButton).click();
    }

    public SignInPage navigateToSignInPage() {
        navigateToHomePage();
        webDriver.findElement(signInButton).click();
        return new SignInPage(webDriver);
    }


/*
    public CartPage addItemToCart() {
        webDriver.findElement(addToCartButton).click();
        return new CartPage(webDriver);
    }*/


    public String getCartNotification(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(notificationBox));
        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return webDriver.findElement(notificationBox).getText();
    }

    public CartPage clickProceedToCheckout() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckoutButton));
        webDriver.findElement(proceedToCheckoutButton).click();
        return new CartPage(webDriver);
    }

    public ItemPage navigateToFirstItem(){
        webDriver.findElement(firstItem).click();
        return (new ItemPage(webDriver));
    }

    public HomePage hoverOverWomensButton() {
        Actions actions = new Actions(webDriver);
        WebElement target = webDriver.findElement(womensButton);
        actions.moveToElement(target).perform();
        return this;
    }


    public TShirtsPage navigateToTShirtsPage() throws InterruptedException {
        Thread.sleep(2000);
        webDriver.findElement(tshirtButtonInDropdown).click();
        return (new TShirtsPage(webDriver));
    }
}
