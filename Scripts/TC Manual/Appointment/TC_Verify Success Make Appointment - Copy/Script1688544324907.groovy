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

WebUI.callTestCase(findTestCase('Reusable-Test/block_login'), [('username') : 'John Doe', ('pass') : 'g3/DOGG74jC3Flrr3yH+3D/yKbOqqUNM'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Object Spy Manual/Appointment/select_Facility'), facility, false)

if (hospital_readmission == true) {
    //jika true maka click hospital readmission
    WebUI.check(findTestObject('Object Spy Manual/Appointment/inpt_hospital_readmission'))
}

def select_radio = healthcare_program

switch (select_radio) {
    case select_radio = 'Medicaid':
        WebUI.click(findTestObject('Object Spy Manual/Appointment/inpt_Medicaid'))

        break
    case select_radio = 'Medicare':
        WebUI.click(findTestObject('Object Spy Manual/Appointment/inpt_Medicare'))

        break
    case select_radio = 'None':
        WebUI.click(findTestObject('Object Spy Manual/Appointment/inpt_None'))

        break
    default:
        WebUI.click(findTestObject('Object Spy Manual/Appointment/inpt_None'))

        break
}

WebUI.delay(3)

//WebUI.click(findTestObject('Object Spy Manual/Appointment/inpt_Medicaid'), FailureHandling.STOP_ON_FAILURE)
WebUI.setText(findTestObject('Object Spy Manual/Appointment/inpt_visit_date'), visit_date)

WebUI.click(findTestObject('Object Spy Manual/Appointment/txtarea_Comment'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Object Spy Manual/Appointment/txtarea_Comment'), comment)

WebUI.click(findTestObject('Object Spy Manual/Appointment/btn_Book'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Object Spy Manual/Apoointment Confirmation/h2_Appointment Confirmation'), 3)

WebUI.verifyElementPresent(findTestObject('Object Spy Manual/Apoointment Confirmation/h2_Appointment Confirmation'), 0)

WebUI.verifyElementText(findTestObject('Object Spy Manual/Apoointment Confirmation/txt_Facility'), facility)

//Hospital Readmission
if (hospital_readmission == true) {
    WebUI.verifyElementText(findTestObject('Object Spy Manual/Apoointment Confirmation/txt_HospitalReadmission'), 'Yes')
} else {
    WebUI.verifyElementText(findTestObject('Object Spy Manual/Apoointment Confirmation/txt_HospitalReadmission'), 'No')
}

//Healthcare Program
switch (select_radio) {
    case select_radio = 'Medicaid':
        WebUI.verifyElementText(findTestObject('Object Spy Manual/Apoointment Confirmation/txt_HealthcareProgram'), 'Medicaid')

        break
    case select_radio = 'Medicare':
        WebUI.verifyElementText(findTestObject('Object Spy Manual/Apoointment Confirmation/txt_HealthcareProgram'), 'Medicare')

        break
    case select_radio = 'None':
        WebUI.verifyElementText(findTestObject('Object Spy Manual/Apoointment Confirmation/txt_HealthcareProgram'), 'None')

        break
    default:
        WebUI.verifyElementText(findTestObject('Object Spy Manual/Apoointment Confirmation/txt_HealthcareProgram'), 'None')

        break
}

WebUI.verifyElementText(findTestObject('Object Spy Manual/Apoointment Confirmation/txt_VisitDate'), visit_date)

WebUI.verifyElementText(findTestObject('Object Spy Manual/Apoointment Confirmation/txt_Comment'), comment)

WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

