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

package com.palantir.typescript.services.language;

import static com.google.common.base.Preconditions.checkArgument;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;

/**
 * Corresponds to the class with the same name in languageService.ts.
 *
 * @author dcicerone
 */
public class EditorOptions {

    protected static final Escaper NEW_LINE_ESCAPER = Escapers.builder()
        .addEscape('\n', "\\n")
        .addEscape('\r', "\\r")
        .build();

    @JsonProperty("IndentSize")
    private int indentSize;

    @JsonProperty("TabSize")
    private int tabSize;

    @JsonProperty("NewLineCharacter")
    private String newLineCharacter;

    @JsonProperty("ConvertTabsToSpaces")
    private boolean convertTabsToSpaces;

    public EditorOptions(int indentSize, int tabSize, boolean convertTabsToSpaces) {
        checkArgument(indentSize >= 0);
        checkArgument(tabSize >= 0);

        this.indentSize = indentSize;
        this.tabSize = tabSize;
        this.newLineCharacter = System.getProperty("line.separator");
        this.convertTabsToSpaces = convertTabsToSpaces;
    }

    public int getIndentSize() {
        return this.indentSize;
    }

    public int getTabSize() {
        return this.tabSize;
    }

    public String getNewLineCharacter() {
        return this.newLineCharacter;
    }

    public boolean getConvertTabsToSpaces() {
        return this.convertTabsToSpaces;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
            .add("indentSize", this.indentSize)
            .add("tabSize", this.tabSize)
            .add("newLineCharacter", NEW_LINE_ESCAPER.escape(this.newLineCharacter))
            .add("convertTabsToSpaces", this.convertTabsToSpaces)
            .toString();
    }
}
