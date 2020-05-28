package StepDefination;

import java.net.MalformedURLException;

import PageFile.LaunchBrowser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

//import io.cucumber.java.en.Then;

public class BookTrainTicket {
	LaunchBrowser obj = new LaunchBrowser();

	@Given("I launch the browser")
	public void i_launch_the_browser() throws MalformedURLException, InterruptedException {
		obj.createDriver();
	}

	@Then("I register userid with {string} and password {string}")
	public void i_register_userid_with_and_password(String username, String pswd)
			throws MalformedURLException, InterruptedException {
		obj.booking(username, pswd);
	}

	@Then("I select security question as {string}")
	public void i_select_security_question_as(String ques) throws MalformedURLException, InterruptedException {
		obj.selectques(ques);
	}

	@Then("I provide the security answer as {string}")
	public void i_provide_the_security_answer_as(String ans) throws MalformedURLException, InterruptedException {
		obj.selectans(ans);
	}

	@Then("I select preferred language as {string}")
	public void i_select_preferred_language_as(String lang) throws MalformedURLException, InterruptedException {
		obj.selectlang(lang);
	}

	@Then("I enter user's first name as {string} and last name as {string}")
	public void i_enter_user_s_first_name_as_and_last_name_as(String firstname, String lastname)
			throws MalformedURLException, InterruptedException {
		obj.enteringuserdeatils(firstname, lastname);
	}

	@Then("I provide user's date of birth as {string} month {string} year and {string} day")
	public void i_provide_user_s_date_of_birth_as_month_year_and_day(String mon, String year, String day) throws MalformedURLException, InterruptedException {
		obj.seluserdob(mon, year, day);
	}

	@Then("I select country {string}")
	public void i_select_country(String cntry) {
		obj.selcntry(cntry);
	}

	@Then("I write email {string}")
	public void i_write_email(String mailid) {
		obj.entermailid(mailid);
	}

	@Then("I give phone number {string}")
	public void i_give_phone_number(String phno) {
		obj.enterphn(phno);
	}

	@Then("I select nationality as {string}")
	public void i_select_nationality_as(String nation) {
		obj.nationality(nation);
	}

	@Then("I provide residentional address deatils")
	public void i_provide_residentional_address_deatils() throws InterruptedException {
		obj.address();
	}

}
