/*
 * Copyright (c)  2010 Ghais Issa and others. All rights reserved.
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
package org.streaminer.stream.sampler.gamma;

import java.util.Random;

/**
 * The simplest skip function.
 * @author Ghais Issa
 */
final public class R implements GammaFunction {

    private static final Random RANDOM = new Random();

    private long n;

    public R(int n) {
        super();
        this.n = n;
    }

    /**
     * Keep generating random numbers until we reache a random number that is <= n.
     * @param t the current number of items we have seen so far
     * @return the number of items to skip.
     */
    @Override
    public long apply(long t) {
        int skipCount = 0;
        while (RANDOM.nextDouble() * t >= n) {
            skipCount++;
        }
        return skipCount;
    }
}