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

package com.zergclan.wormhole.pipeline.core.helper;

import com.zergclan.wormhole.data.core.node.PatternedDataTime;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class PatternedDataTimeConvertorHelperTest {
    
    @Test
    public void assertConvert() {
        PatternedDataTime.DatePattern source = PatternedDataTime.DatePattern.valueOfPattern("STANDARD");
        PatternedDataTime.DatePattern target = PatternedDataTime.DatePattern.valueOfPattern("DATE");
        PatternedDataTimeConvertorHelper helper = new PatternedDataTimeConvertorHelper(source, target);
        Optional<PatternedDataTime> patternedDataTime = helper.convert(new PatternedDataTime("2022-04-24 15:00:00", "yyyy-MM-dd HH:mm:ss"));
        assertTrue(patternedDataTime.isPresent());
        PatternedDataTime expectedPatternedDataTime = new PatternedDataTime("2022-04-24", "yyyy-MM-dd");
        assertEquals(expectedPatternedDataTime.getPattern(), patternedDataTime.get().getPattern());
        assertEquals(expectedPatternedDataTime.getPatternedValue(), patternedDataTime.get().getPatternedValue());
    }
}
