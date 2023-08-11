package id.co.reqres

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import groovy.json.JsonSlurper
import groovy.json.JsonBuilder as JsonBuilder
import groovy.json.JsonOutput as JsonOutput
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable

public class api {

	@Keyword
	def getListUsers (ResponseObject response){
		KeywordUtil.logInfo("HEADER\n"+response.getHeaderFields()+"\n\nBODY\n"+response.getResponseBodyContent())
		JsonSlurper jsonSluper = new JsonSlurper()
		def jsonResp = jsonSluper.parseText(response.getResponseText())
		if (jsonResp.data != null) {
			KeywordUtil.logInfo("API Pass")
			KeywordUtil.logInfo("Data :\n" + jsonResp.data)
		}
		else {
			KeywordUtil.markFailed("API Failed 400")
		}
	}

	@Keyword
	def getSingleUser (ResponseObject response){
		KeywordUtil.logInfo("HEADER\n"+response.getHeaderFields()+"\n\nBODY\n"+response.getResponseBodyContent())
		JsonSlurper jsonSluper = new JsonSlurper()
		def jsonResp = jsonSluper.parseText(response.getResponseText())
		if (jsonResp.data != null) {
			KeywordUtil.logInfo("API Pass")
			KeywordUtil.logInfo("Data :\n" + jsonResp.data)
		}
		else {
			KeywordUtil.markFailed("API Failed 400")
		}
	}

	@Keyword
	def putSingleUser (ResponseObject response){
		KeywordUtil.logInfo("HEADER\n"+response.getHeaderFields()+"\n\nBODY\n"+response.getResponseBodyContent())
		JsonSlurper jsonSluper = new JsonSlurper()
		def jsonResp = jsonSluper.parseText(response.getResponseText())
		def responseCode = WS.getResponseStatusCode(response)
		if (responseCode == 200) {
			KeywordUtil.logInfo("API Pass")
			KeywordUtil.logInfo("Response Code : " + responseCode)
			KeywordUtil.logInfo("Data Change :\n" + response.getResponseText())
		}
		else {
			KeywordUtil.markFailed("API Failed 400")
		}
	}

	@Keyword
	def postSingleUser (ResponseObject response){
		KeywordUtil.logInfo("HEADER\n"+response.getHeaderFields()+"\n\nBODY\n"+response.getResponseBodyContent())
		JsonSlurper jsonSluper = new JsonSlurper()
		def jsonResp = jsonSluper.parseText(response.getResponseText())
		def responseCode = WS.getResponseStatusCode(response)
		if (responseCode == 201) {
			KeywordUtil.logInfo("API Pass")
			KeywordUtil.logInfo("Response Code : " + responseCode)
			KeywordUtil.logInfo("Data Input :\n" + response.getResponseText())
		}
		else {
			KeywordUtil.markFailed("API Failed 400")
		}
	}
}
