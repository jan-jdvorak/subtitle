package com.blackboard.collaborate.csl.validators.subtitle.vtt;

import lombok.Builder;

import java.util.List;

/**
 * Created by jdvorak on 03/02/2017.
 */
@Builder
public class VttCssSelector {
    private String pseudo;
    private String elem;
    private String id;
    private List<String> classes;
    private List<String> attrs;


    private boolean bracketIfNot(StringBuilder bld, boolean added) {
        if (!added) {
            bld.append('(');
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder bld = new StringBuilder();
        bld.append("::").append(pseudo);
        boolean bracket = false;

        if (elem != null) {
            bracket = bracketIfNot(bld, bracket);
            bld.append(elem);
        }
        if (id != null) {
            bracket = bracketIfNot(bld, bracket);
            bld.append('#').append(id);
        }
        if (classes != null) {
            bracket = bracketIfNot(bld, bracket);
            for (String cls : classes) {
                bld.append('.').append(cls);
            }
        }
        if (attrs != null) {
            bracket = bracketIfNot(bld, bracket);
            for (String attr : attrs) {
                bld.append('[');
                bld.append(attr);
                bld.append(']');
            }
        }
        if (bracket) {
            bld.append(')');
        }
        return bld.toString();
    }
}
