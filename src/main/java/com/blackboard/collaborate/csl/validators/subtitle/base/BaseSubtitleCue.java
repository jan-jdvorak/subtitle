/*
 *  This file is part of the noOp organization .
 *
 *  (c) Cyrille Lebeaupin <clebeaupin@noop.fr>
 *
 *  For the full copyright and license information, please view the LICENSE
 *  file that was distributed with this source code.
 *
 */

package com.blackboard.collaborate.csl.validators.subtitle.base;

import com.blackboard.collaborate.csl.validators.subtitle.model.SubtitleCue;
import com.blackboard.collaborate.csl.validators.subtitle.model.SubtitleLine;
import com.blackboard.collaborate.csl.validators.subtitle.util.SubtitleTimeCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by clebeaupin on 09/10/15.
 */
public abstract class BaseSubtitleCue implements SubtitleCue {
    private String id; // Id of cue. 1 or c1
    private SubtitleTimeCode startTime; // Start displaying the cue at this time code
    private SubtitleTimeCode endTime; // Stop displaying the cue at this time code
    private List<SubtitleLine> lines; // Lines composed of texts

    protected BaseSubtitleCue(SubtitleCue cue) {
        this.id = cue.getId();
        this.startTime = cue.getStartTime();
        this.endTime = cue.getEndTime();
        this.lines = new ArrayList<>(cue.getLines());
    }

    protected BaseSubtitleCue() {
        this.lines = new ArrayList<>();
    }

    protected BaseSubtitleCue(SubtitleTimeCode startTime, SubtitleTimeCode endTime) {
        this.lines = new ArrayList<>();
        this.startTime = startTime;
        this.endTime = endTime;
    }

    protected BaseSubtitleCue(SubtitleTimeCode startTime, SubtitleTimeCode endTime, List<SubtitleLine> lines) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.lines = lines;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public SubtitleTimeCode getStartTime() {
        return this.startTime;
    }

    public void setStartTime(SubtitleTimeCode startTime) {
        this.startTime = startTime;
    }

    @Override
    public SubtitleTimeCode getEndTime() {
        return this.endTime;
    }

    public void setEndTime(SubtitleTimeCode endTime) {
        this.endTime = endTime;
    }

    @Override
    public List<SubtitleLine> getLines() {
        return this.lines;
    }

    public void setLines(List<SubtitleLine> lines) {
        this.lines = lines;
    }

    public void addLine(SubtitleLine line) {
        this.lines.add(line);
    }

    public void subtractTime(SubtitleTimeCode toSubtract) {
        this.setStartTime(this.getStartTime().subtract(toSubtract));
        this.setEndTime(this.getEndTime().subtract(toSubtract));
    }

    @Override
    public String getText() {
        StringBuilder bld = new StringBuilder();

        for (SubtitleLine line : lines) {
            bld.append(line.toString()).append("\n");
        }

        return bld.toString();
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