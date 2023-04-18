package com.tekgs.nextgen.igloo.view.catchallerror;

public class CatchAllErrorViewExpected implements CatchAllErrorViewCalibratable{
    public static CatchAllErrorViewExpected getInstance() {
        return new CatchAllErrorViewExpected();
    }

    @Override
    public String getCatchAllErrorMessage() {
        return "Sorry something went wrong :(";
    }
}
