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

import org.tautua.boson.json.ast.Node;
import org.tautua.boson.json.parser.ParseException;
import org.tautua.boson.json.parser.Parser;

import java.io.Reader;
import java.io.Writer;

/**
 * Created by IntelliJ IDEA.
 * User: lruiz
 * Date: 4/24/11
 * Time: 10:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class BosonImpl implements Boson {

    @Override
    public Object read(Reader reader) {
        return read(reader, Object.class);
    }

    @Override
    public <T> T read(Reader reader, Class<T> expectedType) {
        try {
            Parser p = new Parser(reader);
            Node n = p.parse();
            Transformer<T> t = new Transformer<T>(expectedType);
            n.accept(t);
            return t.get();
        } catch (ParseException e) {
            throw new BosonException(e);
        }
    }



    @Override
    public void write(Writer writer, Object obj) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
