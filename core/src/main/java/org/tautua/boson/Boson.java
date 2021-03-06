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

package org.tautua.boson;

import java.io.Reader;
import java.io.Writer;

/**
 * Created by IntelliJ IDEA.
 * User: lruiz
 * Date: 4/24/11
 * Time: 8:11 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Boson {
    Object read(Reader reader);
    <T> T read(Reader reader, Class<T> expectedType);
    void write(Writer writer, Object instance);
}
