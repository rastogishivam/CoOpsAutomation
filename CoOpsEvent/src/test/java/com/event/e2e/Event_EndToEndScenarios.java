package com.event.e2e;

import com.org.coops.base.BaseTest;
import com.org.coops.utilities.DataProviderUtils;
import org.testng.annotations.Test;

public class Event_EndToEndScenarios extends BaseTest {
    @Test(description = "Validate to Purchase the policy with 1 Vehicle and 1 Driver", priority = 1, dataProvider = "fordUI_Web_TestData", dataProviderClass = DataProviderUtils.class)
    public void validate_Ford_E2EScenario_1Driver_1Vehicle(String vinNumber, String homeAddress, String yearlyKM, String driverFirstName, String driverLastName, String sex, String marital, String dob, String driverLicClass, String ageForGLic, String email, String phoneNum, String driverLic, String addInfo){
        System.out.println("Event Test Class..");
    }
}
