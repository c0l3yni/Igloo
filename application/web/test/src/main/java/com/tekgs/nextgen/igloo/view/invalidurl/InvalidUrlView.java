package com.tekgs.nextgen.igloo.view.invalidurl;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.softwareonpurpose.uinavigator.web.WebUiHost;
import com.tekgs.nextgen.igloo.view.IglooView;

public class InvalidUrlView extends IglooView implements InvalidUrlViewCalibratable {
    private static final String RELATIVE_URI = "invalid-url-error";
    private static final String DESCRIPTION = "'Invalid URL' View";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "Invalid-URL-View";

    public InvalidUrlView() {
        super(RELATIVE_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static InvalidUrlView directNav() {
        new InvalidUrlView().load();
        return UiView.expect(InvalidUrlView.class);
    }

    @Override
    protected boolean confirmElementStates() {
        return WebUiHost.getInstance().getAddress().contains(RELATIVE_URI);
    }

    @Override
    public String getInvalidUrlMessage() {
        return getInvalidUrlMessageElement().getText();
    }

    private UiElement getInvalidUrlMessageElement() {
        return UiElement.getInstance("'Invalid URL' Message", UiLocatorType.ID, "url-message", this.getElement());
    }
}
