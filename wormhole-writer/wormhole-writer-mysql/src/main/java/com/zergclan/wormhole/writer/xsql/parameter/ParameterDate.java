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

package com.zergclan.wormhole.writer.xsql.parameter;

import com.zergclan.wormhole.writer.xsql.convert.Converter;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ParameterDate extends Parameter {
    private Converter<Date> converter = Converter.getConverter(Date.class);

    @Override
    public int set(final PreparedStatement ps, final Object params, final int index) throws SQLException {
        Object v = getGetter().get(params);
        ps.setDate(index, converter.convert(v, Date.class));
        return index;
    }
}