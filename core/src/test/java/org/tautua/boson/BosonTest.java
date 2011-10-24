/*
 * Copyright 2011 TAUTUA
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

import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.tautua.foo.Person;
import org.tautua.foo.Status;

import java.io.StringReader;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: lruiz
 * Date: 10/23/11
 * Time: 12:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class BosonTest {
    
    @Test
    public void read(){
        Boson b = new BosonImpl();
        Person p = b.read(new StringReader("{\"firstName\":\"John\",\"roles\":[\"ADMIN\", \"USER\"],\"status\": \"INVALID\"}"), Person.class);
        assertThat(p, notNullValue());
        assertThat(p.getFirstName(), equalTo("John"));
        assertThat(p.getRoles().size(), is(equalTo(2)));
        assertThat(p.getStatus(), is(IsEqual.equalTo(Status.INVALID)));
    }
}
