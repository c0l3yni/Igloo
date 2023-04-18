package com.tekgs.nextgen.igloo.view.invalidurl;

import org.softwareonpurpose.softwaregauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test (groups = {GauntletTest.Application.IGLOO, GauntletTest.View.INVALID_URL})
public class InvalidUrlViewTests extends GauntletTest {
    @Test (groups = {TestSuite.SMOKE, TestSuite.RELEASE})
    public void smoke () {
        addRequirements("81 - Load Times");
        InvalidUrlViewExpected expected = InvalidUrlViewExpected.getInstance();
        InvalidUrlView actual = InvalidUrlView.directNav();
        then(InvalidUrlViewCalibrator.getInstance(expected, actual));
    }
    @Test(dependsOnMethods = "smoke")
    public void routing () {
        addRequirements("81 - Load Times");
        InvalidUrlViewExpected expected = InvalidUrlViewExpected.getInstance();
        InvalidUrlView actual = BogusUrlView.directNav();
        then(InvalidUrlViewCalibrator.getInstance(expected, actual));
    }

}
