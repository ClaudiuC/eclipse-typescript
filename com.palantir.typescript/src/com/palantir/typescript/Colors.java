/*
 * Copyright 2013 Palantir Technologies, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.palantir.typescript;

import static com.google.common.base.Preconditions.checkNotNull;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * The colors.
 *
 * @author dcicerone
 */
public final class Colors {

    public static final RGB COMMENT = new RGB(63, 127, 95);
    public static final RGB IDENTIFIER = new RGB(0, 0, 0);
    public static final RGB KEYWORD = new RGB(127, 0, 85);
    public static final RGB NUMBER_LITERAL = new RGB(0, 0, 0);
    public static final RGB OPERATOR = new RGB(0, 0, 0);
    public static final RGB PUNCTUATION = new RGB(0, 0, 0);
    public static final RGB REG_EXP_LITERAL = new RGB(219, 0, 0);
    public static final RGB STRING_LITERAL = new RGB(42, 0, 255);
    public static final RGB WHITESPACE = new RGB(0, 0, 0);

    private static final LoadingCache<RGB, Color> COLORS = CacheBuilder.newBuilder().build(new CacheLoader<RGB, Color>() {
        @Override
        public Color load(RGB rgb) throws Exception {
            return new Color(Display.getCurrent(), rgb);
        }
    });

    public static Color getColor(RGB rgb) {
        checkNotNull(rgb);

        return COLORS.getUnchecked(rgb);
    }

    private Colors() {
        // prevent instantiation
    }
}
