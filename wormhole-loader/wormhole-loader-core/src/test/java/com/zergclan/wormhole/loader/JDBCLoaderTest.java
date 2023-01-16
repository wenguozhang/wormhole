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

package com.zergclan.wormhole.loader;

import com.zergclan.wormhole.common.metadata.catched.CachedTargetMetaData;
import com.zergclan.wormhole.common.metadata.datasource.DataSourcePoolMetadata;
import com.zergclan.wormhole.common.metadata.datasource.WormholeDataSourceMetaData;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * JDBC loader test.
 */
public final class JDBCLoaderTest {

    @Test
    public void assertGetInstance() {
        String identifier = "ds-source";
        String databaseType = "MySQL";
        String url = "jdbc:mysql://127.0.0.1:3306/ds_source?serverTimezone=UTC&useSSL=false";
        String username = "root";
        String password = "root";
        DataSourcePoolMetadata pool = new DataSourcePoolMetadata("wormhole-test-pool", 2, 2, 30000, 60000, 1800000);
        WormholeDataSourceMetaData dataSourceMetaData = new WormholeDataSourceMetaData(identifier, databaseType, url, username, password, pool);

        CachedTargetMetaData cachedTargetMetaData = new CachedTargetMetaData("", 0L, dataSourceMetaData, "", null, null, null, null, null);
        Optional<WormholeLoader> optional = WormholeLoaderFactory.getLoader(cachedTargetMetaData);
        assertTrue(optional.isPresent());
    }

}
