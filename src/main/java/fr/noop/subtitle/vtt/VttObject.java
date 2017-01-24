/*
 *  This file is part of the noOp organization .
 *
 *  (c) Cyrille Lebeaupin <clebeaupin@noop.fr>
 *
 *  For the full copyright and license information, please view the LICENSE
 *  file that was distributed with this source code.
 *
 */

package fr.noop.subtitle.vtt;

import fr.noop.subtitle.base.BaseSubtitleObject;
import fr.noop.subtitle.model.SubtitleCue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by clebeaupin on 11/10/15.
 */
public class VttObject extends BaseSubtitleObject {
    private Map<String, VttRegion> regions;
    private List<VttStyle> styles;

    private List<Object> objects;

    public VttObject() {
        super();

        regions = new HashMap<>();
        styles = new ArrayList<>();
        objects = new ArrayList<>();
    }

    public void addCue(SubtitleCue cue) {
        objects.add(cue);
        super.addCue(cue);
    }

    public Iterable<VttRegion> getRegions() {
        return regions.values();
    }

    public VttRegion getRegion(String id) {
        return regions.get(id);
    }

    public boolean addRegion(VttRegion vttRegion) {
        objects.add(vttRegion);
        return regions.put(vttRegion.getId(), vttRegion) == null;
    }

    public Iterable<VttStyle> getStyles() {
        return styles;
    }

    public void addStyles(VttStyle vttStyle) {
        objects.add(vttStyle);
        styles.add(vttStyle);
    }

    Iterable<Object> getObjects() {
        return objects;
    }
}
