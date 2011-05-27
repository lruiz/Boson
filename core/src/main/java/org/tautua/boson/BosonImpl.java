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

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

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
        try {
            JSONObject jobj = new JSONObject(new JSONTokener(reader));
            String className = (String) jobj.get("class");
            if (className != null) {
                Class expectedType = Class.forName(className);
                return _read(jobj, expectedType);
            }
        } catch (JSONException e) {
            throw new BosonException(e);
        } catch (ClassNotFoundException e) {
            throw new BosonException(e);
        }
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T> T read(Reader reader, Class<T> expectedType) {
        try {
            JSONObject jobj = new JSONObject(new JSONTokener(reader));
            return _read(jobj, expectedType);
        } catch (JSONException e) {
            throw new BosonException(e);
        }
    }

    protected <T> T _read(JSONObject jobj, Class<T> expectedType) {
        return null;
    }



    @Override
    public void write(Writer writer, Object obj) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
