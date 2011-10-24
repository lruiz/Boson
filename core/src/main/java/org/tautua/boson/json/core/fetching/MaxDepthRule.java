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

import java.lang.reflect.Field;
import java.sql.Date;

/**
 * @author Larry Ruiz
 */
public class MaxDepthRule implements FetchRule {
    private int maxDepth;

    public MaxDepthRule(int maxDepth) {
        this.maxDepth = maxDepth;
    }

    public Decision decide(Field field) {
        int currentDepth = 0;//context.getStack().size();

        // AT MINOR LEVEL THAN THE MAX
        if(currentDepth < maxDepth) {
            return Decision.FETCH;
        } else if (currentDepth == maxDepth) { // AT MAX LEVEL
            if (isLiteral(field) || isEnum(field) ) {
                return Decision.FETCH;
            }
        }

        return Decision.SKIP;
    }

    private boolean isLiteral(Field field) {
        Class type = field.getType();
        return type.isPrimitive()
                || Number.class.isAssignableFrom(type)
                || Character.class.equals(type)
                || String.class.equals(type)
                || Date.class.isAssignableFrom(type)
                || Boolean.class.equals(type);
    }

    private boolean isEnum(Field field) {
        return field.getType().isEnum();
    }
}
