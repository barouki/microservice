package com.test.springbdd;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.client.utils.URIBuilder;

public class CategoryStepDefination extends StepDefinition{
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private CategoryRepository categoryRepository;

	ResultActions action;
	
	@Given("there is a category with id={int} and name={string}")
	public void there_is_a_category_with_id_and_name(Integer categoryId, String categoryName) {
	    Category category = new Category(categoryName, categoryId);
	    categoryRepository.save(category);
	}

	@When("the client calls \\/getCategory with id={int}")
	public void the_client_calls_get_category_with_id(Integer id) throws Exception {
		
		URIBuilder urlBuilder = new URIBuilder("/getCategory");
		urlBuilder.addParameter("id", id.toString());

		String url = urlBuilder.build().toString();		
		
		action=mvc.perform(get(url).contentType(MediaType.APPLICATION_JSON));
	}

	@Then("the client receives status code of {int} for category")
	public void the_client_receives_status_code_of_for_category(Integer status) throws Exception {
		action.andExpect(status().isOk());
	}

	@Then("the client receives category with id={int} and name={string}")
	public void the_client_receives_category_with_id_and_name(Integer categoryId, String categoryName) 
			throws Exception {
		
		action.
			andExpect(jsonPath("id", Matchers.is(categoryId))).
			andExpect(jsonPath("name", Matchers.is(categoryName)));
	}
}
