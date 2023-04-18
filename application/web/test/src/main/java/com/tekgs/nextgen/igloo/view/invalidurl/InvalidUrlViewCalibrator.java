package com.tekgs.nextgen.igloo.view.invalidurl;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class InvalidUrlViewCalibrator extends Calibrator {
    private final InvalidUrlViewExpected expected;
    private final InvalidUrlView actual;
    private static final String DESCRIPTION = "'Invalid URL' View";
    protected InvalidUrlViewCalibrator(InvalidUrlViewExpected expected, InvalidUrlView actual) {
        super(DESCRIPTION, expected, actual);
        this.actual = actual;
        this.expected = expected;
    }

    public static InvalidUrlViewCalibrator getInstance(InvalidUrlViewExpected expected, InvalidUrlView actual) {
        return new InvalidUrlViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("'404' Message", expected.getInvalidUrlMessage(), actual.getInvalidUrlMessage());
    }
}
