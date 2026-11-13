package objectrepository;

import org.openqa.selenium.By;

public class Locators {

	// locators for login page
	public static By signin_button = By.id("signin_button");
	public static By user_name = By.xpath("//input[@id='user_login']");
	public static By user_password = By.id("user_password");
	public static By submit = By.xpath("//input[@name='submit']");
	public static By invalid_alert = By.xpath("//div[@class='alert alert-error']");

	// Locators for Home
	public static By Home = By.xpath("//p[contains(text(), 'Welcome to Zero Online Banking')]");
	public static By OnlineBanking = By.xpath("//strong[text()='Online Banking']");

	// Locators for Pay Bill
	public static By Pay_Bill = By.xpath("//a[contains(@href, 'pay-bills.html')]");
	public static By Payee_Dropdown = By.id("sp_payee");
	public static By Account_Dropdown = By.id("sp_account");
	public static By Amount_Input = By.id("sp_amount");
	public static By Date_Input = By.id("sp_date");
	public static By Calendar_Next = By.xpath("//a[@class='ui-datepicker-next']");
	public static By Calendar_Title = By.className("ui-datepicker-title");
	public static By Calendar_Day_27 = By
			.xpath("//td[@data-handler='selectDay' and @data-month='2' and @data-year='2025']/a[text()='27']");
	public static By Pay_Button = By.id("pay_saved_payees");
	public static By Confirmation_Message = By
			.xpath("//span[contains(text(), 'The payment was successfully submitted.')]");

	// Locator for the "Add New Payee"
	public static By Add_New_Payee_Tab = By.xpath("//a[@href='#ui-tabs-2']");
	public static By New_Payee_Name = By.id("np_new_payee_name");
	public static By New_Payee_Address = By.id("np_new_payee_address");
	public static By New_Payee_Account = By.id("np_new_payee_account");
	public static By Add_New_Payee_Button = By.id("add_new_payee");
	public static final By New_Payee_Confirmation = By.id("alert_content");

}