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
package com.prowidesoftware.swift.model.field;

import com.prowidesoftware.swift.model.Tag;
import com.prowidesoftware.Generated;

import java.io.Serializable;
import java.util.Locale;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Currency;
import com.prowidesoftware.swift.model.field.CurrencyContainer;
import com.prowidesoftware.swift.model.field.CurrencyResolver;
import java.math.BigDecimal;
import com.prowidesoftware.swift.model.field.AmountContainer;
import com.prowidesoftware.swift.model.field.AmountResolver;


import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.field.SwiftParseUtils;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * <strong>SWIFT MT Field 32G</strong>
 * <p>
 * Model and parser for field 32G of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>Currency</code></li>
 * 		<li><code>Number</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>&lt;CUR&gt;&lt;AMOUNT&gt;15</code></li>
 * 		<li>parser pattern: <code>SN</code></li>
 * 		<li>components pattern: <code>CN</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2021</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field32G extends Field implements Serializable, CurrencyContainer, AmountContainer {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2021;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 32G
	 */
    public static final String NAME = "32G";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_32G = "32G";
	public static final String PARSER_PATTERN ="SN";
	public static final String COMPONENTS_PATTERN = "CN";

	/**
	 * Component number for the Currency subfield
	 */
	public static final Integer CURRENCY = 1;

	/**
	 * Component number for the Amount subfield
	 */
	public static final Integer AMOUNT = 2;

	/**
	 * Default constructor. Creates a new field setting all components to null.
	 */
	public Field32G() {
		super(2);
	}
	    					
	/**
	 * Creates a new field and initializes its components with content from the parameter value.
	 * @param value complete field value including separators and CRLF
	 */
	public Field32G(final String value) {
		super(value);
	}
	
	/**
	 * Creates a new field and initializes its components with content from the parameter tag.
	 * The value is parsed with {@link #parse(String)} 	 
	 * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
	 * @since 7.8
	 */
	public Field32G(final Tag tag) {
		this();
		if (tag == null) {
			throw new IllegalArgumentException("tag cannot be null.");
		}
		if (!StringUtils.equals(tag.getName(), "32G")) {
			throw new IllegalArgumentException("cannot create field 32G from tag "+tag.getName()+", tagname must match the name of the field.");
		}
		parse(tag.getValue());
	}

	/**
	 * Copy constructor.<br>
	 * Initializes the components list with a deep copy of the source components list.
	 * @param source a field instance to copy
	 * @since 7.7
	 */
	public static Field32G newInstance(Field32G source) {
		Field32G cp = new Field32G();
		cp.setComponents(new ArrayList<>(source.getComponents()));
		return cp;
	}

	/**
	 * Create a Tag with this field name and the given value.
	 * Shorthand for <code>new Tag(NAME, value)</code>
	 * @see #NAME
	 * @since 7.5
	 */
	public static Tag tag(final String value) {
		return new Tag(NAME, value);
	}

	/**
	 * Create a Tag with this field name and an empty string as value
	 * Shorthand for <code>new Tag(NAME, "")</code>
	 * @see #NAME
	 * @since 7.5
	 */
	public static Tag emptyTag() {
		return new Tag(NAME, "");
	}


	/**
	 * Parses the parameter value into the internal components structure.
	 *
	 * <p>Used to update all components from a full new value, as an alternative
	 * to setting individual components. Previous component values are overwritten.
	 *
	 * @param value complete field value including separators and CRLF
	 * @since 7.8
	 */
	@Override
	public void parse(final String value) {
		init(2);
		setComponent1(SwiftParseUtils.getAlphaPrefix(value));
		setComponent2(SwiftParseUtils.getNumericSuffix(value));
	}
	/**
	 * Serializes the fields' components into the single string value (SWIFT format)
	 */
	@Override
	public String getValue() {
		final StringBuilder result = new StringBuilder();
		result.append(joinComponents());
		return result.toString();
	}
	/**
	 * Returns a localized suitable for showing to humans string of a field component.<br>
	 *
	 * @param component number of the component to display
	 * @param locale optional locale to format date and amounts, if null, the default locale is used
	 * @return formatted component value or null if component number is invalid or not present
	 * @throws IllegalArgumentException if component number is invalid for the field
	 * @since 7.8
	 */
	@Override
	public String getValueDisplay(int component, Locale locale) {
		if (component < 1 || component > 2) {
			throw new IllegalArgumentException("invalid component number "+component+" for field 32G");
		}
		if (component == 1) {
			//default format (as is)
			return getComponent(1);
		}
		if (component == 2) {
			//number, amount, rate
			java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
			f.setMaximumFractionDigits(13);
    		Number n = getComponent2AsNumber();
			if (n != null) {
				return f.format(n);
			}
		}
		return null;
	}
	/**
	 * Returns the field components pattern
	 * @return the static value of Field32G.COMPONENTS_PATTERN
	 */
	@Override
	public final String componentsPattern() {
		return COMPONENTS_PATTERN;
	}

	/**
     * Returns the field parser pattern
     * @return the static value of Field32G.PARSER_PATTERN
     */
	@Override
	public final String parserPattern() {
        return PARSER_PATTERN;
    }

	/**
	 * Returns the field validator pattern
	 */
	@Override
	public final String validatorPattern() {
		return "<CUR><AMOUNT>15";
	}

    /**
     * Given a component number it returns true if the component is optional,
     * regardless of the field being mandatory in a particular message.<br>
     * Being the field's value conformed by a composition of one or several
     * internal component values, the field may be present in a message with
     * a proper value but with some of its internal components not set.
     *
     * @param component component number, first component of a field is referenced as 1
     * @return true if the component is optional for this field, false otherwise
     */
    @Override
    public boolean isOptional(int component) {
        return false;
    }

    /**
     * Returns true if the field is a GENERIC FIELD as specified by the standard.
     * @return true if the field is generic, false otherwise
     */
    @Override
    public boolean isGeneric() {
        return false;
    }

	/**
	 * Returns the defined amount of components.<br>
	 * This is not the amount of components present in the field instance, but the total amount of components
	 * that this field accepts as defined.
	 * @since 7.7
	 */
	@Override
	public int componentsSize() {
		return 2;
	}

	/**
	 * Returns english label for components.
	 * <br>
	 * The index in the list is in sync with specific field component structure.
	 * @see #getComponentLabel(int)
	 * @since 7.8.4
	 */
	@Override
	protected List<String> getComponentLabels() {
		List<String> result = new ArrayList<>();
		result.add("Currency");
		result.add("Amount");
		return result;
	}

	/**
	 * Returns a mapping between component numbers and their label in camel case format.
	 * @since 7.10.3
	 */
	@Override
	protected Map<Integer, String> getComponentMap() {
		Map<Integer, String> result = new HashMap<>();
		result.put(1, "currency");
		result.put(2, "amount");
		return result;
	}
	/**
	 * Gets the component 1 (Currency).
	 * @return the component 1
	 */
	public String getComponent1() {
		return getComponent(1);
	}

	/**
	 * Get the component 1 as Currency
	 * @return the component 1 converted to Currency or null if cannot be converted
	 */
	public java.util.Currency getComponent1AsCurrency() {
		return SwiftFormatUtils.getCurrency(getComponent(1));
	}

	/**
	 * Gets the Currency (component 1).
	 * @return the Currency from component 1
	 */
	public String getCurrency() {
		return getComponent(1);
	}
	
	/**
	 * Get the Currency (component 1) as Currency
	 * @return the Currency from component 1 converted to Currency or null if cannot be converted
	 */
	public java.util.Currency getCurrencyAsCurrency() {
		return SwiftFormatUtils.getCurrency(getComponent(1));
	}
	/**
	 * Gets the component 2 (Amount).
	 * @return the component 2
	 */
	public String getComponent2() {
		return getComponent(2);
	}

	/**
	 * Get the component 2 as Number
	 * @return the component 2 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getComponent2AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(2));
	}

	/**
	 * Gets the Amount (component 2).
	 * @return the Amount from component 2
	 */
	public String getAmount() {
		return getComponent(2);
	}
	
	/**
	 * Get the Amount (component 2) as Number
	 * @return the Amount from component 2 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getAmountAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(2));
	}
    
	public List<String> currencyStrings() {
		return CurrencyResolver.resolveComponentsPattern(COMPONENTS_PATTERN, components);
	}

	public List<Currency> currencies() {
		final List<String> l = currencyStrings();
		if (l.isEmpty()) {
			return java.util.Collections.emptyList();
		}
		final List<Currency> result = new ArrayList<>();
		for (String s: l) {
			result.add(Currency.getInstance(s));
		}
		return result;
	}
    
	public Currency currency() {
		return CurrencyResolver.resolveCurrency(this);
	}

	public String currencyString() {
		return CurrencyResolver.resolveCurrencyString(this);
	}

	public void initializeCurrencies(String cur) {
		CurrencyResolver.resolveSetCurrency(this, cur);
	}

	public void initializeCurrencies(Currency cur) {
		CurrencyResolver.resolveSetCurrency(this, cur);
	}
    
	/**
	 * @see AmountResolver#amounts(Field)
	 */
	public List<BigDecimal> amounts() {
		return AmountResolver.amounts(this);
	}
	
	/**
	 * @see AmountResolver#amount(Field)
	 */
	public BigDecimal amount() {
		return AmountResolver.amount(this);
	}


	/**
	 * Set the component1 (Currency).
	 * @param component1 the component1 to set
	 */
	public Field32G setComponent1(String component1) {
		setComponent(1, component1);
		return this;
	}
	
	/**
	 * Set the component1 from a Currency object.
	 * <br>
	 * Parses the Number into a SWIFT amount with truncated zero decimals and mandatory decimal separator.
	 * <ul>
	 * 	<li>Example: 1234.00 -&gt; 1234,</li>
	 * 	<li>Example: 1234 -&gt; 1234,</li>
	 * 	<li>Example: 1234.56 -&gt; 1234,56</li>
	 * </ul>
	 * @param component1 the Currency with the component1 content to set
	 */
	public Field32G setComponent1(java.util.Currency component1) {
		setComponent(1, SwiftFormatUtils.getCurrency(component1));
		return this;
	}
	
	/**
	 * Set the Currency (component1).
	 * @param component1 the Currency to set
	 */
	public Field32G setCurrency(String component1) {
		setComponent(1, component1);
		return this;
	}
	
	/**
	 * Set the Currency (component1) from a Currency object.
	 * @see #setComponent1(java.util.Currency)
	 * @param component1 Currency with the Currency content to set
	 */
	public Field32G setCurrency(java.util.Currency component1) {
		setComponent1(component1);
		return this;
	}

	/**
	 * Set the component2 (Amount).
	 * @param component2 the component2 to set
	 */
	public Field32G setComponent2(String component2) {
		setComponent(2, component2);
		return this;
	}
	
	/**
	 * Set the component2 from a Number object.
	 * <br>
	 * Parses the Number into a SWIFT amount with truncated zero decimals and mandatory decimal separator.
	 * <ul>
	 * 	<li>Example: 1234.00 -&gt; 1234,</li>
	 * 	<li>Example: 1234 -&gt; 1234,</li>
	 * 	<li>Example: 1234.56 -&gt; 1234,56</li>
	 * </ul>
	 * @param component2 the Number with the component2 content to set
	 */
	public Field32G setComponent2(java.lang.Number component2) {
		setComponent(2, SwiftFormatUtils.getNumber(component2));
		return this;
	}
	
	/**
	 * Set the Amount (component2).
	 * @param component2 the Amount to set
	 */
	public Field32G setAmount(String component2) {
		setComponent(2, component2);
		return this;
	}
	
	/**
	 * Set the Amount (component2) from a Number object.
	 * @see #setComponent2(java.lang.Number)
	 * @param component2 Number with the Amount content to set
	 */
	public Field32G setAmount(java.lang.Number component2) {
		setComponent2(component2);
		return this;
	}

   
	/**
	 * Returns the field's name composed by the field number and the letter option (if any)
	 * @return the static value of Field32G.NAME
	 */
	@Override
	public String getName() {
		return NAME;
	}

	/**
	 * Gets the first occurrence form the tag list or null if not found.
	 * @return null if not found o block is null or empty
	 * @param block may be null or empty 
	 */
	public static Field32G get(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return null;
		}
		final Tag t = block.getTagByName(NAME);
		if (t == null) {
			return null;
		}
		return new Field32G(t) ;
	}
	
	/**
	 * Gets the first instance of Field32G in the given message.
	 * @param msg may be empty or null
	 * @return null if not found or msg is empty or null
	 * @see #get(SwiftTagListBlock)
	 */
	public static Field32G get(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return null;
		return get(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field32G in the given message
	 * an empty list is returned if none found.
	 * @param msg may be empty or null in which case an empty list is returned
	 * @see #getAll(SwiftTagListBlock)
	 */ 
	public static List<Field32G> getAll(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return java.util.Collections.emptyList();
		return getAll(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field32G from the given block
	 * an empty list is returned if none found.
	 *
	 * @param block may be empty or null in which case an empty list is returned 
	 */ 
	public static List<Field32G> getAll(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return java.util.Collections.emptyList();
		}
		final Tag[] arr = block.getTagsByName(NAME);
		if (arr != null && arr.length > 0) {
			final List<Field32G> result = new ArrayList<>(arr.length);
			for (final Tag f : arr) {
				result.add( new Field32G(f));
			}
			return result;
		}
		return java.util.Collections.emptyList();
	}

	/**
	 * This method deserializes the JSON data into a Field32G object.
	 * @param json JSON structure including tuples with label and value for all field components
	 * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
	 * @since 7.10.3
	 * @see Field#fromJson(String)
	 */
	public static Field32G fromJson(final String json) {
		Field32G field = new Field32G();
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = (JsonObject) parser.parse(json);
		if (jsonObject.get("currency") != null) {
			field.setComponent1(jsonObject.get("currency").getAsString());
		}
		if (jsonObject.get("amount") != null) {
			field.setComponent2(jsonObject.get("amount").getAsString());
		}
		return field;
	}
	

}
