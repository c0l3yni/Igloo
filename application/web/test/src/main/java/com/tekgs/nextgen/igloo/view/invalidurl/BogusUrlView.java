package com.tekgs.nextgen.igloo.view.invalidurl;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.igloo.view.IglooView;

public class BogusUrlView extends IglooView {
    private static final String RELATIVE_URI = "bogusurl";
    private static final String DESCRIPTION = "'Bogus Url' View";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "bogusurl";

    public BogusUrlView() {
        super(RELATIVE_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static InvalidUrlView directNav() {
        new BogusUrlView().load();
        return UiView.expect(InvalidUrlView.class);
    }

    @Override
    protected boolean confirmElementStates() {
        return false;
    }
}
