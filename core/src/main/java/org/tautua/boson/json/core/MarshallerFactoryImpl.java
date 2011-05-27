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

import org.tautua.boson.json.Marshaller;
import org.tautua.boson.json.MarshallerFactory;

/**
 * Created by IntelliJ IDEA.
 * User: Lruiz
 * Date: Aug 12, 2008
 * Time: 11:07:12 AM
 * To change this template use File | Settings | File Templates.
 */
@Deprecated
public class MarshallerFactoryImpl implements MarshallerFactory {
    public <T> Marshaller<T> create(Class<T> type) {
        return new MarshallerImpl<T>(type);
    }
}
