/*
 * Title: SubtitleText
 * Copyright: Copyright (c) 2017. Blackboard Inc. and its subsidiary companies.
 *
 * This program is based on noophq/subtitle.
 * (c) Cyrille Lebeaupin <clebeaupin@noop.fr>
 *
 * This program is free software licensed under the GNU Lesser General Public License v3.
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.blackboard.collaborate.validator.subtitle.model;

/**
 * Created by clebeaupin on 11/10/15.
 */
public interface SubtitleText {
    /**
     *
     * @return the text
     */
    String toString();

    /**
     *
     * @return true if there is no text
     */
    boolean isEmpty();
}
