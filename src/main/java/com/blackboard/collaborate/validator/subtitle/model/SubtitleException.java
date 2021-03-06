/*
 * Title: SubtitleException
 * Copyright (c) 2019. Blackboard Inc. and its subsidiary companies.
 *
 * This program is based on noophq/subtitle.
 * Copyright (c) 2015-2016 Cyrille Lebeaupin <clebeaupin@noop.fr>
 *
 * This program is free software licensed under the GNU Lesser General Public License v3.
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.blackboard.collaborate.validator.subtitle.model;

import lombok.Getter;

import java.util.List;

public class SubtitleException extends Exception {
    @Getter
    private List<ValidationIssue> issueList;

    public SubtitleException(String message) {
        super(message);
    }

    public SubtitleException(String message, Throwable cause) {
        super(message, cause);
    }

    public SubtitleException(String message, List<ValidationIssue> validationIssues) {
        super(message);
        this.issueList = validationIssues;
    }
}
