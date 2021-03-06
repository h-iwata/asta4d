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

package com.astamuse.asta4d.util.i18n;

import java.util.Collections;
import java.util.Locale;
import java.util.Map;

import com.astamuse.asta4d.format.PlaceholderFormatter;
import com.astamuse.asta4d.util.InvalidMessageException;

public class ParamMapResourceBundleHelper extends ResourceBundleHelperBase {

    public ParamMapResourceBundleHelper() {
        super();
    }

    public ParamMapResourceBundleHelper(Locale locale, PlaceholderFormatter formatter) {
        super(locale, formatter);
    }

    public ParamMapResourceBundleHelper(Locale locale) {
        super(locale);
    }

    public ParamMapResourceBundleHelper(PlaceholderFormatter formatter) {
        super(formatter);
    }

    public String getMessage(String key) throws InvalidMessageException {
        return ResourceBundleUtil.getMessage(getFormatter(), getLocale(), key, Collections.<String, Object> emptyMap());
    }

    public String getMessage(String key, Map<String, Object> paramMap) throws InvalidMessageException {
        return ResourceBundleUtil.getMessage(getFormatter(), getLocale(), key, paramMap);
    }

}
