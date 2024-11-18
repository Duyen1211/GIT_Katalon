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
import static org.assertj.core.api.InstanceOfAssertFactories.CHARACTER
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('ThemKyThi/ddlCauHinh'))

WebUI.click(findTestObject('ThemKyThi/ddlQuanLyDanhMuc'))

WebUI.click(findTestObject('ThemKyThi/ddlKyThi'))

WebUI.click(findTestObject('ThemKyThi/btnThemKyThi'))

WebUI.click(findTestObject('ThemKyThi/ddNam'))

WebUI.click(findTestObject('ThemKyThi/itemNam'))

WebUI.setText(findTestObject('ThemKyThi/txtTenKyThi'), 'Kỳ thi 6')

//Tạo đối tượng Random
Random random = new Random()

//Tạo chuỗi ngẫu nhiên
String characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789'

int length = 6 // độ dài của chuỗi ngẫu nhiên

StringBuilder randomString = new StringBuilder()

for (int i = 0; i < length; i++) {
    randomString.append(characters.charAt(random.nextInt(characters.length())))
}

WebUI.setText(findTestObject('ThemKyThi/txtMaKyThi'), randomString.toString())

WebUI.setText(findTestObject('ThemKyThi/txtMoTa'), 'Kỳ thi ')

WebUI.click(findTestObject('ThemKyThi/btnDongY'))

WebUI.verifyElementPresent(findTestObject('ThemKyThi/alertThongBaoTC'), 0)

WebUI.verifyElementText(findTestObject('ThemKyThi/alertThongBaoTC'), 'Thêm dữ liệu thành công')

WebUI.closeBrowser()

