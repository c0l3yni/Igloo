package com.tekgs.nextgen.igloo.view.catchallerror;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class CatchAllErrorViewCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Catch All Error' view";
    private final CatchAllErrorViewExpected expected;
    private final CatchAllErrorView actual;

    protected CatchAllErrorViewCalibrator(CatchAllErrorViewExpected expected, CatchAllErrorView actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static Calibrator getInstance(CatchAllErrorViewExpected expected, CatchAllErrorView actual) {
        return new CatchAllErrorViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Catch All Error Message", expected.getCatchAllErrorMessage(), actual.getCatchAllErrorMessage());
    }
}
