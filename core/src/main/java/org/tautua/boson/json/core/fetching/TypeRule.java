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

package org.tautua.boson.json.core.fetching;

import org.tautua.boson.json.Context;

import java.lang.reflect.Field;

/**
 * @author Larry Ruiz
 */
public class TypeRule implements FetchRule {
    private Class type;
    private boolean includes;

    public TypeRule(Class type, boolean includes) {
        this.type = type;
        this.includes = includes;
    }

    public Decision decide(Field field, Context context) {
        if (field.getType().equals(type)) {
            return includes ? Decision.FETCH : Decision.SKIP;
        }
        return Decision.NOT_APPLY;
    }
}