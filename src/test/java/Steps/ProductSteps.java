package Steps;

import Base.BaseStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProductSteps extends BaseStep {


    @Given("^go to eBebek$")
    public void goToEBebek() {
        geturl();
    }

    @And("^search for biberon$")
    public void searchForBiberon() throws InterruptedException {
        search("biberon");
        Thread.sleep(3000);
    }

    @And("^click the first product$")
    public void clickTheFirstProduct() {
        selectProduct(1);
    }

    @And("^click add to cart$")
    public void clickAddToCart() {
        addToCart();
    }

    @When("^show cart$")
    public void showCart() {
        goToCart();
    }

    @Then("^check if the product added$")
    public void checkIfTheProductAdded() {
          checkIfProductAddedtoCart();
    }

    @And("^driver close$")
    public void driverClose() {
        driverQuit();
    }
}
