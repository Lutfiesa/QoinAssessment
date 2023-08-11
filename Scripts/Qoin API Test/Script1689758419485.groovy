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
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import groovy.json.JsonBuilder as JsonBuilder
import groovy.json.JsonOutput as JsonOutput
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

//API Get List Users
RequestObject UserList = findTestObject('Object Repository/Postman/Get List User')
ResponseObject UserListResp = WS.sendRequestAndVerify(UserList, FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'id.co.reqres.api.getListUsers'(UserListResp)

//API GET Single User
RequestObject SingleUser = findTestObject('Object Repository/Postman/Get Single User')
ResponseObject SingleUserResp = WS.sendRequestAndVerify(SingleUser, FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'id.co.reqres.api.getSingleUser'(SingleUserResp)

//API PUT Single User
TestData editdata = findTestData('Data Files/PUT')
RequestObject EditData = findTestObject('Object Repository/Postman/Put Update',
	[
		('first_name') : editdata.getValue('firstname', 1)
		])
ResponseObject EditDataResp = WS.sendRequestAndVerify(EditData, FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'id.co.reqres.api.putSingleUser'(EditDataResp)

//API POST Single User
JsonSlurper jsonSluper = new JsonSlurper()
def jsonResp = jsonSluper.parseText(SingleUserResp.getResponseText())
email = jsonResp.data.email
first_name = jsonResp.data.first_name
last_name = jsonResp.data.last_name
//TestData inputdata = findTestData('Data Files/POST')
RequestObject InputData = findTestObject('Object Repository/Postman/Post Request',
	[
		    ('email') : email,
			('first_name'): first_name,
			('last_name'): last_name
		])
ResponseObject InputDataResp = WS.sendRequestAndVerify(InputData, FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'id.co.reqres.api.postSingleUser'(InputDataResp)