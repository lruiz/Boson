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

import org.tautua.boson.json.TypeAdapterRegistry;
import org.tautua.boson.json.Context;
import org.tautua.boson.json.FetchPlan;
import org.tautua.boson.json.TypeAdapter;
import org.tautua.boson.json.util.DequeStack;
import org.tautua.boson.json.util.Stack;

import java.lang.reflect.Field;


/**
 * @author Larry Ruiz
 */
public class ContextImpl implements Context {
    private Stack stack = new DequeStack();
    private FetchPlan fetchPlan;
    private TypeAdapterRegistry typeAdapterRegistry;

    public ContextImpl(TypeAdapterRegistry typeAdapterRegistry, FetchPlan fetchPlan) {
        this.typeAdapterRegistry = typeAdapterRegistry;
        this.fetchPlan = fetchPlan;
    }

    @SuppressWarnings({"unchecked"})
    public <T> TypeAdapter<T> findAdapter(Class<T> type) {
        return typeAdapterRegistry.findAdapter(type);
    }

    public TypeAdapter<?> findAdapter(Field field) {
        return typeAdapterRegistry.findAdapter(field);
    }

    public Stack getStack() {
        return stack;
    }

    public TypeAdapterRegistry getAdapterManager() {
        return typeAdapterRegistry;
    }

    public FetchPlan getFetchPlan() {
        return fetchPlan;
    }
}
