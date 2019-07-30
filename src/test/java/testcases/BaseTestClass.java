package testcases;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import utils.PropertyUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTestClass {

    public MobileDriver driver;

    @BeforeMethod
    public void setUpAppium() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        setDesiredCapabilitiesForIOS(capabilities);
        String url = PropertyUtils.getProperty("appium.server.url");
        driver = new IOSDriver<>(new URL(url), capabilities);
    }

    /**
     * Setting the desired capabilities for the local execution
     * @param desiredCapabilities
     */
    private void setDesiredCapabilitiesForIOS(DesiredCapabilities desiredCapabilities) {
        String PLATFORM_NAME = PropertyUtils.getProperty("ios.platform.name");
        String PLATFORM_VERSION = PropertyUtils.getProperty("ios.platform.version");
        String APP = PropertyUtils.getProperty("ios.app");
        String DEVICE_NAME = PropertyUtils.getProperty("ios.device.name");
        String NO_RESET = PropertyUtils.getProperty("ios.app.no.reset");
        String FULL_RESET = PropertyUtils.getProperty("ios.app.full.reset");
        String AUTOMATION_NAME = PropertyUtils.getProperty("ios.automation.name"); //XCUITest


        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, APP);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, NO_RESET);
        desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, FULL_RESET);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AUTOMATION_NAME);
        }

    public static String getAbsolutePath(String appRelativePath){
        File file = new File(appRelativePath);
        return file.getAbsolutePath();

    }


    private void quitDriver(){
        try{
            this.driver.quit();
        }catch (Exception ex){

        }
    }

}
