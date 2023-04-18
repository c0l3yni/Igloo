package com.tekgs.nextgen.igloo.view.error;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.igloo.view.IglooView;
import com.tekgs.nextgen.igloo.view.catchallerror.CatchAllErrorView;

public class ErrorView extends IglooView{
    private static final String RELATIVE_URI = "catch-all-error";
    private static final String DESCRIPTION = "'Simulate Error' view";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "simulate-error-view";

    public ErrorView() {
        super(RELATIVE_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static CatchAllErrorView directNav(String statusCode) {
        String relativeUri = String.format("?statusCode=%s", statusCode);
        new ErrorView().load(relativeUri);
        return UiView.expect(CatchAllErrorView.class);
    }

}
