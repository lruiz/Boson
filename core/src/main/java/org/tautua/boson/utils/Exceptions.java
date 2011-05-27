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

package org.tautua.boson.utils;

/**
 * Created by IntelliJ IDEA.
 * User: lruiz
 * Date: 4/24/11
 * Time: 10:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class Exceptions {

    private Exceptions() {
    }

    /**
     * Re-throws an arbitrary Throwable as a RuntimeException or an Error.
     * <b>Important notes:</b><br>
     * This function never returns properly! Rather, it will
     * always throw an Exception.<br>
     * This function exploits a loophole in the Generics type system. It makes it possible
     * to throw arbitrary checked Exceptions without declaring them in the <tt>throws</tt> clause.
     * @param throwable the source Throwable.
     */
    public static void rethrow(Throwable throwable) {
        Exceptions.<RuntimeException>_rethrow(throwable);
    }

    @SuppressWarnings(value = "unchecked")
    private static <T extends Throwable> void _rethrow(Throwable throwable) throws T {
        throw (T) throwable;
    }
}
