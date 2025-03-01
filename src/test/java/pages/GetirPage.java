package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class GetirPage {

    public GetirPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    //CookiesAcceptButton
    @FindBy(xpath = "(//button[@data-testid='button'])[1]")
    public WebElement cookiesAcceptButton;

    @FindBy(xpath = "//")
    public WebElement fitAndFormButton;
}
