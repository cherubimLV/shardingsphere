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

package org.apache.shardingsphere.cdc.mysql.binlog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.shardingsphere.cdc.core.position.CDCPosition;

/**
 * Binlog Position.
 */
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public final class BinlogPosition implements CDCPosition<BinlogPosition> {
    
    private final String filename;
    
    private final long position;
    
    private long serverId;
    
    @Override
    public int compareTo(final BinlogPosition position) {
        if (null == position) {
            return 1;
        }
        return Long.compare(toLong(), position.toLong());
    }
    
    private long toLong() {
        return Long.parseLong(filename.substring(filename.lastIndexOf('.') + 1)) << 32 | position;
    }
    
    @Override
    public String toString() {
        return String.format("%s#%d", filename, position);
    }
}
