package com.tekgs.nextgen.igloo.view.catchallerror;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.softwareonpurpose.uinavigator.web.WebUiHost;
import com.tekgs.nextgen.igloo.view.IglooView;

public class CatchAllErrorView extends IglooView implements CatchAllErrorViewCalibratable{

    private static final String RELATIVE_URI = "catch-all-error";
    private static final String LOCATOR_VALUE = "catch-all-error-view";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;

    private static final String DESCRIPTION = "'Catch All Error' View";

    public CatchAllErrorView() {
        super(RELATIVE_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static CatchAllErrorView directNav() {
        new CatchAllErrorView().load();
        return UiView.expect(CatchAllErrorView.class);
    }

    @Override
    public String getCatchAllErrorMessage() {
        return getCatchAllErrorMessageElement().getText();
    }

    private UiElement getCatchAllErrorMessageElement() {
        String description = "'Catch All Error' Message";
        String locatorValue = "catch-all-error-message";
        return getViewElementById(description, locatorValue);
    }

    @Override
    protected boolean confirmElementStates() {
        return WebUiHost.getInstance().getAddress().contains(RELATIVE_URI);
    }
}
