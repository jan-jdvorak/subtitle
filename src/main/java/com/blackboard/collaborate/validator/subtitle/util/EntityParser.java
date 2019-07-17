/*
 * Title: EntityParser
 * Copyright (c) 2018. Blackboard Inc. and its subsidiary companies.
 *
 * This program is based on noophq/subtitle.
 * Copyright (c) 2015-2016 Cyrille Lebeaupin <clebeaupin@noop.fr>
 *
 * This program is free software licensed under the GNU Lesser General Public License v3.
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.blackboard.collaborate.validator.subtitle.util;

import com.blackboard.collaborate.validator.subtitle.model.ValidationReporter;

import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;


public class EntityParser {
    private static final Pattern entityPattern = Pattern.compile("^[A-Za-z][A-Za-z0-9]+$");

    private static final List<Integer> FORBIDDEN_CODES = Arrays.asList(
            0x00, 0x80, 0x82, 0x83, 0x84, 0x85, 0x86, 0x87, 0x88, 0x89,
            0x8A, 0x8B, 0x8C, 0x8E, 0x91, 0x92, 0x93, 0x94, 0x95, 0x96,
            0x97, 0x98, 0x99, 0x9A, 0x9B, 0x9C, 0x9E, 0x9F
    );

    public static int accumulate(Reader reader, StringBuilder entity) throws IOException {
        int c = reader.read();
        while (c != -1 && c != '<' && c != '>' && c != '&' && !Character.isWhitespace(c) && c != ';') {
            entity.append((char) c);
            c = reader.read();
        }
        return c;
    }

    public static void notify(ValidationReporter reporter, String msg, boolean strict) {
        if (strict) {
            reporter.notifyError(msg);
        } else {
            reporter.notifyWarning(msg);
        }
    }

    public static boolean parse(ValidationReporter reporter, String entity, boolean strict) {
        if (entity.startsWith("#") && entity.length() > 1) {
            int code;
            String toParse;
            int radix;

            if (entity.charAt(1) == 'x' || entity.charAt(1) == 'X') {
                radix = 16;
                toParse = entity.substring(2);
            } else {
                radix = 10;
                toParse = entity;
            }

            try {
                code = Integer.parseInt(toParse, radix);
            } catch (NumberFormatException e) {
                notify(reporter, "Invalid entity code: '&" + entity + ";'", strict);
                return false;
            }

            if (Collections.binarySearch(FORBIDDEN_CODES, code) >= 0 || (code >= 0xD800 && code <= 0xDFFF) || code > 0x10FFFF) {
                notify(reporter, "Forbidden entity code: '&" + entity + ";'", strict);
                return false;
            }
        } else if (!entityPattern.matcher(entity).matches()) {
            notify(reporter, "Invalid entity name: '&" + entity + "'", strict);
            return false;
        }
        return true;
    }
}
