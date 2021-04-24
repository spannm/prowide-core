/*
 * Copyright 2006-2021 Prowide
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
package com.prowidesoftware.swift.constraints;

import com.prowidesoftware.swift.utils.IsoUtils;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Implementation of the ISO Alpha-2 country validation constraint
 *
 * @see IsoUtils#isValidISOCountry(String) for implementation details
 * @since 7.10.3
 */
public class CurrencyValidator implements ConstraintValidator<CountryConstraint, String> {

    @Override
    public void initialize(CountryConstraint currency) {
    }

    @Override
    public boolean isValid(String currency, ConstraintValidatorContext context) {
        if (StringUtils.isBlank(currency)) {
            return true;
        }
        return IsoUtils.getInstance().isValidISOCurrency(currency);
    }

}