package com.tekgs.nextgen.igloo.view;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;

public abstract class IglooRegion extends UiRegion {

    protected IglooRegion(UiElement parentElement) {
        super(parentElement);
    }

    protected UiElement getRegionElementByName(String description, String locatorId){
        return UiElement.getInstance(description, UiLocatorType.NAME, locatorId, this.getElement());
    }
}
