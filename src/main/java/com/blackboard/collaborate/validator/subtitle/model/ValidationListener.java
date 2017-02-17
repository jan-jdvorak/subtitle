/*
 * Title: ValidationListener
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
 * Created by jdvorak on 20.1.2017.
 */
public interface ValidationListener {

    void onValidation(ValidationIssue event);

}
