package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import services.CadastroEntregasService;

import java.util.List;
import java.util.Map;

public class CadastroEntregasSteps {

    CadastroEntregasService cadastroEntregasService = new  CadastroEntregasService();


    @Given("the following registration data:")
    public void theFollowingRegistrationData(List<Map<String, String>> rows) {
        for(Map<String, String> columns : rows) {
            cadastroEntregasService.setFieldsDelivery(columns.get("campo"), columns.get("valor"));
        }
    }

    @When("I send the request to the endpoint {string} to register a delivery")
    public void iSendTheRequestToTheEndpointToRegisterADelivery(String endpoint) {
        cadastroEntregasService.createDelivery(endpoint);
    }

    @Then("response status is {int}")
    public void responseStatusIs(int statusCode) {
        Assert.assertEquals(statusCode, cadastroEntregasService.response.statusCode());
    }
}
