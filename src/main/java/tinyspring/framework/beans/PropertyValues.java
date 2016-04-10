package tinyspring.framework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenqing on 2016/4/9.
 */
public class PropertyValues {
    private List<PropertyValue> propertyValueList;

    public PropertyValues() {
        propertyValueList = new ArrayList<PropertyValue>(0);
    }

    public PropertyValues(List<PropertyValue> propertyValues) {
        this.propertyValueList = (propertyValues != null ? propertyValues : new ArrayList<PropertyValue>(0));
    }

    public void addPropertyValue(PropertyValue pv) {
        propertyValueList.add(pv);
    }

    public List<PropertyValue> getPropertyValues() {
        return this.propertyValueList;
    }
}
