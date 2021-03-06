/*
 * Copyright 2012 astamuse company,Ltd.
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
 * 
 */

package com.astamuse.asta4d.web.util;

import java.util.List;

import com.astamuse.asta4d.Context;
import com.astamuse.asta4d.web.WebApplicationConfiguration;

public class DeclareInstanceUtil {

    private final static DeclareInstanceResolver defaultResolver = new DefaultDeclareInstanceResolver();

    @SuppressWarnings("unchecked")
    public final static <T> T createInstance(Object declaration) {
        WebApplicationConfiguration conf = (WebApplicationConfiguration) Context.getCurrentThreadContext().getConfiguration();
        List<DeclareInstanceResolver> resolverList = conf.getInstanceResolverList();
        Object handler = null;
        for (DeclareInstanceResolver resolver : resolverList) {
            handler = resolver.resolve(declaration);
            if (handler != null) {
                break;
            }
        }
        if (handler == null) {
            handler = defaultResolver.resolve(declaration);
        }
        return (T) handler;
    }
}
