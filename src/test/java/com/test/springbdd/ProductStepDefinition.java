package com.test.springbdd;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class ProductStepDefinition extends StepDefinition{

	@Autowired
	private MockMvc mvc;

	ResultActions action;


    @Given("I am logged in with status {int}")
    public void i_am_logged_in_with_status(int stat) throws Exception{
        action=mvc.perform(get("/logged")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().is(stat));
    }


    @Given("I am on the product page with id {int}")
    public void i_am_on_the_product_page_with_id(Integer int1) throws Exception {
        action=mvc.perform(get("/products/"+int1).contentType(MediaType.APPLICATION_JSON));
    }

    @When("I try to disable product with id {int}")
    public void i_try_to_disable_product_with_id(Integer int1) throws Exception{
        action=mvc.perform(get("/product/"+int1+"/disable").contentType(MediaType.APPLICATION_JSON));
    }

    @When("I try to enable product with id {int}")
    public void i_try_to_enable_product_with_id(Integer int1) throws  Exception {
        action=mvc.perform(get("/product/"+int1+"/enable").contentType(MediaType.APPLICATION_JSON));
    }



    @Then("I should see {string} for product with id {int}")
    public void i_should_see(String str,int id) throws Exception {
        action=mvc.perform(get("/product/"+id+"/status")
                .contentType(MediaType.APPLICATION_JSON));
    }

    @When("I try to remove product with id {int}")
    public void i_try_to_remove_product_with_id(Integer int1) throws Exception{
        action=mvc.perform(get("/product/"+int1+"/remove").contentType(MediaType.APPLICATION_JSON));
    }

    @Given("I am on the Add product page")
    public void i_am_on_the_add_product_page() throws Exception {
        action=mvc.perform(get("/products/add").contentType(MediaType.APPLICATION_JSON));
    }

    @When("Entering  {string} and {string} and {string} and {int} and {string} and {float}")
    public void entering_and_and_and_and(String category, String description,
                                         String status,Integer Unit, String data, Float price)  throws  Exception{
        action=mvc.perform(get("/products/addProduct").contentType(MediaType.APPLICATION_JSON));
    }

    @Then("I should see {string} for product with {int}")
    public void i_should_see_for_product_with_id(String string, int id) throws Exception {
        action=mvc.perform(get("/product/"+id+"/added")
                .contentType(MediaType.APPLICATION_JSON));
    }


    @Given("I am on the {string} page to do a product search")
    public void i_am_on_page_to_do_a_product_list(String url) throws Exception {
        mvc.perform(get("/search").contentType(MediaType.APPLICATION_JSON));
    }


    @When("I do a product search with the id {int}")
    public void i_do_a_product_search_with_the_id(Integer int1) throws Exception {
        action=mvc.perform(get("/products/"+int1).requestAttr("id", int1)).andExpect(status().isOk());
    }


    @Then("I receive status code of {int} for product")
    public void i_receive_status_code_of_for_product(Integer int1) throws Exception {
        action.andExpect(status().is(int1));
    }

    @Then("I see a product listed result page with product id {int}")
    public void i_see_a_product_listed_result_page_with_product_id(Integer id) throws Exception {
        action.andExpect(jsonPath("id", Matchers.is(id)));
    }


    @Given("I am on the homepage to do a search")
    public void i_am_on_the_homepage_to_do_a_search() throws Exception{
        action=mvc.perform(get("/search").contentType(MediaType.APPLICATION_JSON));
    }

    @When("I do a search using keyword {string}")
    public void i_do_a_search_using_keyword(String string)  throws Exception {
        action = mvc.perform(get("/search/"+string).param("name",string)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());;
    }


    @Then("I see a search result page with product id {int}")
    public void i_see_a_search_result_page_with_product_id(int id) throws Exception{
        action.andExpect(jsonPath("id", Matchers.is(id)));
    }







}
