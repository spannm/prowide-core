/*
 * Copyright 2006-2022 Prowide
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
import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;

import java.io.Serializable;
import java.util.Locale;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import java.math.BigDecimal;
import java.math.BigInteger;

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
 * SWIFT MT Field 34K.
 * <p>
 * Model and parser for field 34K of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>String</code></li>
 * 		<li><code>BigDecimal</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>3!a&lt;AMOUNT&gt;15</code></li>
 * 		<li>parser pattern: <code>SN</code></li>
 * 		<li>components pattern: <code>SN</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2022</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field34K extends Field implements Serializable, AmountContainer {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2022;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 34K.
	 */
    public static final String NAME = "34K";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_34K = "34K";

    /**
     * @deprecated Use {@link #parserPattern()} method instead.
     */
    @Deprecated
    @ProwideDeprecated(phase3 = TargetYear.SRU2023)
	public static final String PARSER_PATTERN = "SN";

    /**
     * @deprecated Use {@link #typesPattern()} method instead.
     */
    @Deprecated
    @ProwideDeprecated(phase3 = TargetYear.SRU2023)
	public static final String COMPONENTS_PATTERN = "SN";

    /**
     * @deprecated Use {@link #typesPattern()} method instead.
     */
    @Deprecated
    @ProwideDeprecated(phase3 = TargetYear.SRU2023)
	public static final String TYPES_PATTERN = "SI";

	/**
	 * Component number for the Currency subfield.
	 */
	public static final Integer CURRENCY = 1;

	/**
	 * Component number for the Amount subfield.
	 */
	public static final Integer AMOUNT = 2;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field34K() {
        super(2);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field34K(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field34K(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "34K")) {
            throw new IllegalArgumentException("cannot create field 34K from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field34K newInstance(Field34K source) {
        Field34K cp = new Field34K();
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
     * Create a Tag with this field name and an empty string as value.
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
            throw new IllegalArgumentException("invalid component number " + component + " for field 34K");
        }
        if (component == 1) {
            //default format (as is)
            return getComponent(1);
        }
        if (component == 2) {
            //amount, rate
            java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
            f.setMaximumFractionDigits(13);
            BigDecimal n = getComponent2AsBigDecimal();
            if (n != null) {
                return f.format(n);
            }
        }
        return null;
    }

    /**
     * @deprecated Use {@link #typesPattern()} instead.
     */
    @Override
    @Deprecated
    @ProwideDeprecated(phase3 = TargetYear.SRU2023)
    public String componentsPattern() {
        return "SN";
    }

    /**
     * Returns the field component types pattern.
     *
     * This method returns a letter representing the type for each component in the Field. It supersedes
     * the Components Pattern because it distinguishes between N (Number) and I (BigDecimal).
     * @since 9.2.7
     */
    @Override
    public String typesPattern() {
        return "SI";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "SN";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return "3!a<AMOUNT>15";
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
    public List<String> getComponentLabels() {
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
     * @see Field#getLabelMap()
     * @since 9.3.12
     */
    @Override
    protected Map<String, Integer> getLabelMap() {
        if (super.labelMap != null && !super.labelMap.isEmpty()) {
            // return cached map
            return super.labelMap;
        }
        super.labelMap = new HashMap<>();
        super.labelMap.put("currency", 1);
        super.labelMap.put("amount", 2);
        return super.labelMap;
    }

    /**
     * Gets the component 1 (Currency).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Gets the Currency (component 1).
     * @return the Currency from component 1
     */
    public String getCurrency() {
        return getComponent1();
    }

    /**
     * Gets the component 2 (Amount).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Get the component 2 as BigDecimal
     *
     * @return the component 2 converted to BigDecimal or null if cannot be converted
     * @since 9.2.7
     */
    public java.math.BigDecimal getComponent2AsBigDecimal() {
        return SwiftFormatUtils.getBigDecimal(getComponent(2));
    }

    /**
     * Get the component 2 as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent2AsBigDecimal()</code> to get the proper value.
     *
     * @return the component 2 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getComponent2AsBigDecimal()
     */
    @Deprecated
    @ProwideDeprecated(phase3 = TargetYear.SRU2023)
    public java.lang.Number getComponent2AsNumber() {
        return getComponent2AsBigDecimal();
    }

    /**
     * Gets the Amount (component 2).
     * @return the Amount from component 2
     */
    public String getAmount() {
        return getComponent2();
    }

    /**
     * Get the Amount (component 2) as BigDecimal
     * @return the Amount from component 2 converted to BigDecimal or null if cannot be converted
     * @since 9.2.7
     */
    public java.math.BigDecimal getAmountAsBigDecimal() {
        return getComponent2AsBigDecimal();
    }

    /**
     * Get the Amount (component 2) as as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent2AsBigDecimal()</code> to get the proper value.
     *
     * @return the component 2 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getAmountAsBigDecimal()
     */
    @Deprecated
    @ProwideDeprecated(phase3 = TargetYear.SRU2023)
    public java.lang.Number getAmountAsNumber() {
        return getComponent2AsNumber();
    }

    /**
     * Set the component 1 (Currency).
     *
     * @param component1 the Currency to set
     * @return the field object to enable build pattern
     */
    public Field34K setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Currency (component 1).
     *
     * @param component1 the Currency to set
     * @return the field object to enable build pattern
     */
    public Field34K setCurrency(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Amount).
     *
     * @param component2 the Amount to set
     * @return the field object to enable build pattern
     */
    public Field34K setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the component2 from a BigDecimal object.
     * <br>
     * Parses the BigDecimal into a SWIFT amount with truncated zero decimals and mandatory decimal separator.
     * <ul>
     *     <li>Example: 1234.00 -&gt; 1234,</li>
     *     <li>Example: 1234 -&gt; 1234,</li>
     *     <li>Example: 1234.56 -&gt; 1234,56</li>
     * </ul>
     * @since 9.2.7
     *
     * @param component2 the BigDecimal with the Amount content to set
     * @return the field object to enable build pattern
     */
    public Field34K setComponent2(java.math.BigDecimal component2) {
        setComponent(2, SwiftFormatUtils.getBigDecimal(component2));
        return this;
    }
    /**
     * Alternative method setter for field's Amount (component 2) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10.0 becomes an Float)
     *
     * @param component2 the Number with the Amount content to set
     * @return the field object to enable build pattern
     * @see #setAmount(java.math.BigDecimal)
     */
    public Field34K setComponent2(java.lang.Number component2) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component2 instanceof BigDecimal) {
            setComponent(2, SwiftFormatUtils.getBigDecimal((BigDecimal) component2));
        } else if (component2 instanceof BigInteger) {
            setComponent(2, SwiftFormatUtils.getBigDecimal(new BigDecimal((BigInteger) component2)));
        } else if (component2 instanceof Long || component2 instanceof Integer) {
            setComponent(2, SwiftFormatUtils.getBigDecimal(BigDecimal.valueOf(component2.longValue())));
        } else if (component2 != null) {
            // it's other non-null Number (Float, Double, etc...)
            setComponent(2, SwiftFormatUtils.getBigDecimal(BigDecimal.valueOf(component2.doubleValue())));
        } else {
            // explicitly set component as null
            setComponent(2, null);
        }
        return this;
    }

    /**
     * Set the Amount (component 2).
     *
     * @param component2 the Amount to set
     * @return the field object to enable build pattern
     */
    public Field34K setAmount(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the Amount (component 2) from a BigDecimal object.
     *
     * @see #setComponent2(java.math.BigDecimal)
     *
     * @param component2 BigDecimal with the Amount content to set
     * @return the field object to enable build pattern
     * @since 9.2.7
     */
    public Field34K setAmount(java.math.BigDecimal component2) {
        return setComponent2(component2);
    }

    /**
     * Alternative method setter for field's Amount (component 2) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component2 the Number with the Amount content to set
     * @return the field object to enable build pattern
     * @see #setAmount(java.math.BigDecimal)
     */
    public Field34K setAmount(java.lang.Number component2) {
        return setComponent2(component2);
    }


    /**
     * Returns the list of all NON-NULL amounts as BigDecimal
     *
     * @return the list of NON-NULL amounts as BigDecimal values
     * @see AmountResolver#amounts(Field)
     */
    public List<BigDecimal> amounts() {
        return AmountResolver.amounts(this);
    }

    /**
     * Returns the first amounts as BigDecimal
     *
     * @return the first amount as BigDecimal value. Can be null
     * @see AmountResolver#amount(Field)
     */
    public BigDecimal amount() {
        return AmountResolver.amount(this);
    }


    /**
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field34K.NAME
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
    public static Field34K get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field34K(t);
    }

    /**
     * Gets the first instance of Field34K in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field34K get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field34K in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field34K> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field34K from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field34K> getAll(final SwiftTagListBlock block) {
        final List<Field34K> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null && arr.length > 0) {
            for (final Tag f : arr) {
                result.add(new Field34K(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field34K object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field34K fromJson(final String json) {

        final Field34K field = new Field34K();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Currency

        if (jsonObject.get("currency") != null) {
            field.setComponent1(jsonObject.get("currency").getAsString());
        }

        // **** COMPONENT 2 - Amount

        if (jsonObject.get("amount") != null) {
            field.setComponent2(jsonObject.get("amount").getAsString());
        }

        return field;
    }


}
