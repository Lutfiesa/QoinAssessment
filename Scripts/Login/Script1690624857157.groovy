import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.apache.commons.lang.RandomStringUtils

WebUI.openBrowser('')

WebUI.navigateToUrl('https://staging-my.qoin.id/register')

WebUI.setText(findTestObject('Object Repository/Page_Qoin Web Merchant/input_Business Brand_businessBrand'), 'Test')

WebUI.setText(findTestObject('Object Repository/Page_Qoin Web Merchant/input_Full Name_name'), 'Lutfi')

String randomMail = "Test" + RandomStringUtils.randomAlphanumeric(5) + "@mymail.com"

WebUI.setText(findTestObject('Object Repository/Page_Qoin Web Merchant/input_Email_email'), randomMail)

WebUI.setText(findTestObject('Object Repository/Page_Qoin Web Merchant/input_Website (optional)_website'), 'lutfi.co.id')

WebUI.setText(findTestObject('Object Repository/Page_Qoin Web Merchant/input_Instagram (optional)_instagram'), '@lutfiesap')

String randomPhone = "08" + RandomStringUtils.randomNumeric(9)

WebUI.setText(findTestObject('Object Repository/Page_Qoin Web Merchant/input_Phone_phone'), randomPhone)

//WebUI.setEncryptedText(findTestObject('Object Repository/Page_Qoin Web Merchant/input_Password_password'), 'PYvvGBzRMcDGTpsDgD+rKA==')
//
//WebUI.setEncryptedText(findTestObject('Object Repository/Page_Qoin Web Merchant/input_Re-enter Password_passwordConfirmation'), 
//    '9NLz+4tGZcQ=')
//
//WebUI.click(findTestObject('Object Repository/Page_Qoin Web Merchant/div_Merchant DashboardMerchant DashboardV1._65c1cd'))

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Qoin Web Merchant/input_Password_password'), 'pKtidpWx/wEF9EGFlfeUyw==')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Qoin Web Merchant/input_Re-enter Password_passwordConfirmation'), 
    'pKtidpWx/wEF9EGFlfeUyw==')

WebUI.click(findTestObject('Object Repository/Page_Qoin Web Merchant/button_Sign Up'))

