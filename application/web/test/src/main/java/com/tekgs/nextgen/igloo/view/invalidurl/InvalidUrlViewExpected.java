package com.tekgs.nextgen.igloo.view.invalidurl;

public class InvalidUrlViewExpected implements InvalidUrlViewCalibratable {
    public static InvalidUrlViewExpected getInstance() {
        return new InvalidUrlViewExpected();
    }

    @Override
    public String getInvalidUrlMessage() {
        return "Error 404: Page Not Found, sorry :(";
    }
}
