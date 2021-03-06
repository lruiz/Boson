/*
 * Copyright 2011, TAUTUA
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

package org.tautua.boson.json.core.adapters;

import org.tautua.boson.json.core.LiteralAdapter;
import org.tautua.boson.json.core.TypeAdapterRegistryImpl;

import java.io.IOException;
import java.io.Writer;

/**
 * @author Larry Ruiz
 */
public class CharacterAdapter extends LiteralAdapter<Character> {
    public void register(TypeAdapterRegistryImpl adapterManager) {
        adapterManager.register(Character.class, this);
        adapterManager.register(char.class, this);
    }

    public Character _read(Object value) {
        return ((String) value).charAt(0);
    }

    public void _write(Character character, Writer writer) throws IOException {
        writer.append("\"").append(character).append("\"");
    }
}