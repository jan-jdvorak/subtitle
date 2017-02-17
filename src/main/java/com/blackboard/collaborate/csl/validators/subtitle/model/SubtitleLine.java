/*
 *  This file is part of the noOp organization .
 *
 *  (c) Cyrille Lebeaupin <clebeaupin@noop.fr>
 *
 *  For the full copyright and license information, please view the LICENSE
 *  file that was distributed with this source code.
 *
 */

package com.blackboard.collaborate.csl.validators.subtitle.model;

import java.util.List;

/**
 * Created by clebeaupin on 14/10/15.
 */
public interface SubtitleLine {
    List<SubtitleText> getTexts();

    /**
     *
     * @return true if there is no text
     */
    boolean isEmpty();
}
