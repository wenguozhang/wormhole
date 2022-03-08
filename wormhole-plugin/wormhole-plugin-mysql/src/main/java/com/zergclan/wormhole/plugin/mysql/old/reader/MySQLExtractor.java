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

package com.zergclan.wormhole.plugin.mysql.old.reader;

import com.zergclan.wormhole.core.api.data.DataGroup;
import com.zergclan.wormhole.core.metadata.task.SourceMetadata;
import com.zergclan.wormhole.plugin.api.Extractor;
import lombok.RequiredArgsConstructor;

import javax.sql.DataSource;

/**
 * Extractor for MySQL.
 */
@RequiredArgsConstructor
public final class MySQLExtractor implements Extractor<DataGroup> {
    
    private final DataSource dataSource;
    
    @Override
    public DataGroup extract(final SourceMetadata source) {
        return null;
    }
}