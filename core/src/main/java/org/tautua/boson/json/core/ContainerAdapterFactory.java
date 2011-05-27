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

package org.tautua.boson.json.core;

import org.tautua.boson.json.TypeAdapter;

/**
 * <p>A TypeAdapter factory for container types (Collection, List, Set, Map, Arrays).<p>
 *
 * @author Larry Ruiz
 */

@Deprecated
public interface ContainerAdapterFactory<T extends TypeAdapter> {
    T create(Class<?> containedType);
}
