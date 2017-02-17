package com.blackboard.collaborate.csl.validators.subtitle.vtt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jdvorak on 02/02/2017.
 */
public class VttCssRule {

    private final List<VttCssSelector> selectors;
    private final Map<String, String> propertyValues;
    
    public VttCssRule() {
        selectors = new ArrayList<>();
        propertyValues = new HashMap<>();
    }

    @Override
    public String toString() {
        StringBuilder bld = new StringBuilder();

        for (VttCssSelector selector : selectors) {
            if (bld.length() > 0) {
                bld.append(", ");
            }
            bld.append(selector.toString());
        }

        bld.append(" {\n");
        for (Map.Entry<String, String> entry : propertyValues.entrySet()) {
            bld.append("  ").append(entry.getKey()).append(":").append(entry.getValue()).append(";\n");
        }
        bld.append("}\n");

        return bld.toString();
    }

    public void addProperty(String name, String value) {
        propertyValues.put(name, value);
    }

   
    /**
     * @return List of all selectors attached to the rule.
     */
    public Iterable<VttCssSelector> selectors() {
        return selectors;
    }

    /**
     * Adds a selector to the rule.
     *
     * @param selector The selector that should be attached to the rule.
     */
    public void addSelector(final VttCssSelector selector) {
        selectors.add(selector);
    }

}
