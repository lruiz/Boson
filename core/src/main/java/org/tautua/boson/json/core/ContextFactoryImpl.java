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

import org.tautua.boson.json.Context;
import org.tautua.boson.json.ContextFactory;
import org.tautua.boson.json.FetchPlan;
import org.tautua.boson.json.core.fetching.FetchAllPlan;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Larry Ruiz
 */
public class ContextFactoryImpl implements ContextFactory {
    private static final FetchPlan DEFAULT_FETCH_PLAN = new FetchAllPlan();
    private List<TypeAdapterRegistryImpl.Component> components;
    private FetchPlan fetchPlan = DEFAULT_FETCH_PLAN;

    public ContextFactoryImpl() {
        components = new ArrayList<TypeAdapterRegistryImpl.Component>();
    }

    public Context create() {
        TypeAdapterRegistryImpl adapterManager = new TypeAdapterRegistryImpl();
        for (TypeAdapterRegistryImpl.Component c : components) {
            c.register(adapterManager);
        }
        return new ContextImpl(adapterManager, fetchPlan);
    }

    public void addComponent(TypeAdapterRegistryImpl.Component c) {
        components.add(c);
    }

    public void setFetchPlan(FetchPlan fetchPlan) {
        this.fetchPlan = fetchPlan;
    }
}
