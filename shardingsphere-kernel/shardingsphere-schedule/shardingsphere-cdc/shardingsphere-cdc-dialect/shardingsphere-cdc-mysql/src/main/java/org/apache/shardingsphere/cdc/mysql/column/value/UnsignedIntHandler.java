/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.cdc.mysql.column.value;

import java.io.Serializable;

public final class UnsignedIntHandler implements ValueHandler {
    
    private static final long INT_MODULO = 4294967296L;
    
    @Override
    public String getTypeName() {
        return "INT UNSIGNED";
    }
    
    @Override
    public Serializable handle(final Serializable value) {
        int intValue = (int) value;
        return 0 > intValue ? INT_MODULO + intValue : intValue;
    }
}
