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
 * <p>A fetch policy determines if a field is going to be fetched or not.</p>
 *
 * @author Larry Ruiz
 */
public interface FetchRule {
    Decision decide(Field field, Context context);

    public static enum Decision {
        FETCH,
        SKIP,
        NOT_APPLY,
    }
}
