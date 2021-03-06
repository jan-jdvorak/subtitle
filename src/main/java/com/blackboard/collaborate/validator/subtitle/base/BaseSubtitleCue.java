/*
 * Title: BaseSubtitleCue
 * Copyright (c) 2017. Blackboard Inc. and its subsidiary companies.
 *
 * This program is based on noophq/subtitle.
 * Copyright (c) 2015-2016 Cyrille Lebeaupin <clebeaupin@noop.fr>
 *
 * This program is free software licensed under the GNU Lesser General Public License v3.
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.blackboard.collaborate.validator.subtitle.base;

import com.blackboard.collaborate.validator.subtitle.model.SubtitleCue;
import com.blackboard.collaborate.validator.subtitle.util.SubtitleTimeCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * Created by clebeaupin on 09/10/15.
 */
@Getter
@Setter
public abstract class BaseSubtitleCue implements SubtitleCue {
    private String id; // Id of cue. 1 or c1
    private SubtitleTimeCode startTime; // Start displaying the cue at this time code
    private SubtitleTimeCode endTime; // Stop displaying the cue at this time code

    protected BaseSubtitleCue(SubtitleCue cue) {
        this.id = cue.getId();
        this.startTime = cue.getStartTime();
        this.endTime = cue.getEndTime();
    }

    protected BaseSubtitleCue() {

    }

    protected BaseSubtitleCue(SubtitleTimeCode startTime, SubtitleTimeCode endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void subtractTime(SubtitleTimeCode toSubtract) {
        this.setStartTime(this.getStartTime().subtract(toSubtract));
        this.setEndTime(this.getEndTime().subtract(toSubtract));
    }

    @Override
    public Iterable<Map.Entry<String, String>> getSettings() {
        return null;
    }

    @Override
    public String toString() {
        return this.getText();
    }
}
