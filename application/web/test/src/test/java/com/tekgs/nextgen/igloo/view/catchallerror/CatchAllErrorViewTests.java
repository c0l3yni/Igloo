package com.tekgs.nextgen.igloo.view.catchallerror;

import com.tekgs.nextgen.igloo.view.error.ErrorView;
import org.softwareonpurpose.softwaregauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.IGLOO, GauntletTest.View.CATCH_ALL_ERROR})
public class CatchAllErrorViewTests extends GauntletTest {
    @DataProvider
    public static Object[][] scenarios() {
        String clientError = "400";
        String pageNotFoundError = "404";
        String serverError = "500";
        String statusCodeOutsideAcceptedRange = "300";
        return new Object[][]{
                {clientError},
                {serverError},
                {pageNotFoundError},
                {statusCodeOutsideAcceptedRange}
        };
    }

    @Test(groups = {TestSuite.SMOKE})
    public void smoke() {
        addRequirements("81 - Load Times");
        CatchAllErrorViewExpected expected = CatchAllErrorViewExpected.getInstance();
        CatchAllErrorView actual = CatchAllErrorView.directNav();
        then(CatchAllErrorViewCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.RELEASE}, dependsOnMethods = "smoke", dataProvider = "scenarios")
    public void directNav(String statusCode){
        addRequirements("81 - Load Times");
        CatchAllErrorViewExpected expected = CatchAllErrorViewExpected.getInstance();
        CatchAllErrorView actual = ErrorView.directNav(statusCode);
        then(CatchAllErrorViewCalibrator.getInstance(expected, actual));
    }
}
