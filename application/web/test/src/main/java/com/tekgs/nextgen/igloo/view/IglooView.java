package com.tekgs.nextgen.igloo.view;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import org.softwareonpurpose.softwaregauntlet.Environment;

public abstract class IglooView extends UiView {
    private static final String DOMAIN_URL = Environment.getInstance().getDomainUrl();

    protected IglooView(String relativeUri, UiElement viewElement) {
        super(String.format("%s/%s", DOMAIN_URL, relativeUri), viewElement);
    }

    @Override
    protected boolean confirmElementStates() {
        return this.getElement().waitUntilVisible();
    }

    protected UiElement getViewElementById(String description, String locatorId) {
        return UiElement.getInstance(description, UiLocatorType.ID, locatorId, this.getElement());
    }

    protected UiElement getViewElementByClass(String description, String locatorId) {
        return UiElement.getInstance(description, UiLocatorType.CLASS, locatorId, this.getElement());
    }

    protected UiElement getViewElementByName(String description, String locatorName) {
        return UiElement.getInstance(description, UiLocatorType.NAME, locatorName, this.getElement());
    }
}
