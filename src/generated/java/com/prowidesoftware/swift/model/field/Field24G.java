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
import com.prowidesoftware.swift.model.field.MultiLineField;


import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.field.SwiftParseUtils;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * <strong>SWIFT MT Field 24G</strong>
 * <p>
 * Model and parser for field 24G of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>4!c(**)[$35x]0-6</code></li>
 * 		<li>parser pattern: <code>S[$S]0-6</code></li>
 * 		<li>components pattern: <code>SSSSSSS</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2021</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field24G extends Field implements Serializable, MultiLineField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2021;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 24G
	 */
    public static final String NAME = "24G";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_24G = "24G";
	public static final String PARSER_PATTERN ="S[$S]0-6";
	public static final String COMPONENTS_PATTERN = "SSSSSSS";

	/**
	 * Component number for the Code subfield
	 */
	public static final Integer CODE = 1;

	/**
	 * Component number for the Name and Address subfield
	 */
	public static final Integer NAME_AND_ADDRESS = 2;

	/**
	 * Default constructor. Creates a new field setting all components to null.
	 */
	public Field24G() {
		super(7);
	}
	    					
	/**
	 * Creates a new field and initializes its components with content from the parameter value.
	 * @param value complete field value including separators and CRLF
	 */
	public Field24G(final String value) {
		super(value);
	}
	
	/**
	 * Creates a new field and initializes its components with content from the parameter tag.
	 * The value is parsed with {@link #parse(String)} 	 
	 * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
	 * @since 7.8
	 */
	public Field24G(final Tag tag) {
		this();
		if (tag == null) {
			throw new IllegalArgumentException("tag cannot be null.");
		}
		if (!StringUtils.equals(tag.getName(), "24G")) {
			throw new IllegalArgumentException("cannot create field 24G from tag "+tag.getName()+", tagname must match the name of the field.");
		}
		parse(tag.getValue());
	}

	/**
	 * Copy constructor.<br>
	 * Initializes the components list with a deep copy of the source components list.
	 * @param source a field instance to copy
	 * @since 7.7
	 */
	public static Field24G newInstance(Field24G source) {
		Field24G cp = new Field24G();
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
		init(7);
		List<String> lines = SwiftParseUtils.getLines(value);
		SwiftParseUtils.setComponentsFromLines(this, 1, null, 0, lines);
	}
	/**
	 * Serializes the fields' components into the single string value (SWIFT format)
	 */
	@Override
	public String getValue() {
		final StringBuilder result = new StringBuilder();
        appendInLines(result, 1, 7);
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
		if (component < 1 || component > 7) {
			throw new IllegalArgumentException("invalid component number "+component+" for field 24G");
		}
		if (component == 1) {
			//default format (as is)
			return getComponent(1);
		}
		if (component == 2) {
			//default format (as is)
			return getComponent(2);
		}
		if (component == 3) {
			//default format (as is)
			return getComponent(3);
		}
		if (component == 4) {
			//default format (as is)
			return getComponent(4);
		}
		if (component == 5) {
			//default format (as is)
			return getComponent(5);
		}
		if (component == 6) {
			//default format (as is)
			return getComponent(6);
		}
		if (component == 7) {
			//default format (as is)
			return getComponent(7);
		}
		return null;
	}
	/**
	 * Returns the field components pattern
	 * @return the static value of Field24G.COMPONENTS_PATTERN
	 */
	@Override
	public final String componentsPattern() {
		return COMPONENTS_PATTERN;
	}

	/**
     * Returns the field parser pattern
     * @return the static value of Field24G.PARSER_PATTERN
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
		return "4!c(**)[$35x]0-6";
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
        if (component == 2) {
            return true;
        }
        if (component == 3) {
            return true;
        }
        if (component == 4) {
            return true;
        }
        if (component == 5) {
            return true;
        }
        if (component == 6) {
            return true;
        }
        if (component == 7) {
            return true;
        }
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
		return 7;
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
		result.add("Code");
		result.add("Name and Address");
		result.add("Name and Address 2");
		result.add("Name and Address 3");
		result.add("Name and Address 4");
		result.add("Name and Address 5");
		result.add("Name and Address 6");
		return result;
	}

	/**
	 * Returns a mapping between component numbers and their label in camel case format.
	 * @since 7.10.3
	 */
	@Override
	protected Map<Integer, String> getComponentMap() {
		Map<Integer, String> result = new HashMap<>();
		result.put(1, "code");
		result.put(2, "nameandAddress");
		result.put(3, "nameandAddress2");
		result.put(4, "nameandAddress3");
		result.put(5, "nameandAddress4");
		result.put(6, "nameandAddress5");
		result.put(7, "nameandAddress6");
		return result;
	}
	/**
	 * Gets the component 1 (Code).
	 * @return the component 1
	 */
	public String getComponent1() {
		return getComponent(1);
	}

	/**
	 * Gets the Code (component 1).
	 * @return the Code from component 1
	 */
	public String getCode() {
		return getComponent(1);
	}
	/**
	 * Gets the component 2 (Name and Address).
	 * @return the component 2
	 */
	public String getComponent2() {
		return getComponent(2);
	}

	/**
	 * Gets the Name and Address (component 2).
	 * @return the Name and Address from component 2
	 */
	public String getNameandAddressLine1() {
		return getComponent(2);
	}

	/**
	 * Gets the Name and Address (component 3).
	 * @return the Name and Address from component 3
	 */
	public String getNameandAddressLine2() {
		return getComponent(3);
	}

	/**
	 * Gets the Name and Address (component 4).
	 * @return the Name and Address from component 4
	 */
	public String getNameandAddressLine3() {
		return getComponent(4);
	}

	/**
	 * Gets the Name and Address (component 5).
	 * @return the Name and Address from component 5
	 */
	public String getNameandAddressLine4() {
		return getComponent(5);
	}

	/**
	 * Gets the Name and Address (component 6).
	 * @return the Name and Address from component 6
	 */
	public String getNameandAddressLine5() {
		return getComponent(6);
	}

	/**
	 * Gets the Name and Address (component 7).
	 * @return the Name and Address from component 7
	 */
	public String getNameandAddressLine6() {
		return getComponent(7);
	}

	/**
	 * Gets the Name and Address as a concatenation of component 2 to component 7.
	 * @return the Name and Address from components
	 */
	public String getNameandAddress() {
		return getNameandAddress(null);
	}

	/**
	 * Gets the Name and Address as a concatenation of component 2 to component 7 joined together with a copy of the
	 * specified delimiter.
	 * @param deli the delimiter that separates each component
	 * @return the Name and Address from components
	 * @since 9.1.4
	 */
	public String getNameandAddress(CharSequence deli) {
		StringBuilder result = new StringBuilder();
		for (int i = 2 ; i < 8 ; i++) {
			if (getComponent(i) != null) {
			    if (deli != null && result.length() > 0) {
                    result.append(deli);
                }
				result.append(getComponent(i));
			}
		}
		return result.toString();
	}
	/**
	 * Gets the component 3 (Name and Address).
	 * @return the component 3
	 */
	public String getComponent3() {
		return getComponent(3);
	}
	/**
	 * Gets the component 4 (Name and Address).
	 * @return the component 4
	 */
	public String getComponent4() {
		return getComponent(4);
	}
	/**
	 * Gets the component 5 (Name and Address).
	 * @return the component 5
	 */
	public String getComponent5() {
		return getComponent(5);
	}
	/**
	 * Gets the component 6 (Name and Address).
	 * @return the component 6
	 */
	public String getComponent6() {
		return getComponent(6);
	}
	/**
	 * Gets the component 7 (Name and Address).
	 * @return the component 7
	 */
	public String getComponent7() {
		return getComponent(7);
	}


	/**
	 * Set the component1 (Code).
	 * @param component1 the component1 to set
	 */
	public Field24G setComponent1(String component1) {
		setComponent(1, component1);
		return this;
	}
	
	/**
	 * Set the Code (component1).
	 * @param component1 the Code to set
	 */
	public Field24G setCode(String component1) {
		setComponent(1, component1);
		return this;
	}

	/**
	 * Set the component2 (Name and Address).
	 * @param component2 the component2 to set
	 */
	public Field24G setComponent2(String component2) {
		setComponent(2, component2);
		return this;
	}

	/**
	 * Set the Name and Address (component2).
	 * @param component2 the Name and Address to set
	 */
	public Field24G setNameandAddressLine1(String component2) {
		setComponent(2, component2);
		return this;
	}

	/**
	 * Set the Name and Address (component3).
	 * @param component3 the Name and Address to set
	 */
	public Field24G setNameandAddressLine2(String component3) {
		setComponent(3, component3);
		return this;
	}

	/**
	 * Set the Name and Address (component4).
	 * @param component4 the Name and Address to set
	 */
	public Field24G setNameandAddressLine3(String component4) {
		setComponent(4, component4);
		return this;
	}

	/**
	 * Set the Name and Address (component5).
	 * @param component5 the Name and Address to set
	 */
	public Field24G setNameandAddressLine4(String component5) {
		setComponent(5, component5);
		return this;
	}

	/**
	 * Set the Name and Address (component6).
	 * @param component6 the Name and Address to set
	 */
	public Field24G setNameandAddressLine5(String component6) {
		setComponent(6, component6);
		return this;
	}

	/**
	 * Set the Name and Address (component7).
	 * @param component7 the Name and Address to set
	 */
	public Field24G setNameandAddressLine6(String component7) {
		setComponent(7, component7);
		return this;
	}

	/**
	 * Set the Name and Address splitting the parameter lines into components 2 to 7.
	 * @param value the Name and Address to set, may contain line ends and each line will be set to its correspondent component attribute
	 */
	public Field24G setNameandAddress(String value) {
		List<String> lines = SwiftParseUtils.getLines(value);
		SwiftParseUtils.setComponentsFromLines(this, 2, 6, 0, lines);
		return this;
	}

	/**
	 * Set the component3 (Name and Address).
	 * @param component3 the component3 to set
	 */
	public Field24G setComponent3(String component3) {
		setComponent(3, component3);
		return this;
	}

	/**
	 * Set the component4 (Name and Address).
	 * @param component4 the component4 to set
	 */
	public Field24G setComponent4(String component4) {
		setComponent(4, component4);
		return this;
	}

	/**
	 * Set the component5 (Name and Address).
	 * @param component5 the component5 to set
	 */
	public Field24G setComponent5(String component5) {
		setComponent(5, component5);
		return this;
	}

	/**
	 * Set the component6 (Name and Address).
	 * @param component6 the component6 to set
	 */
	public Field24G setComponent6(String component6) {
		setComponent(6, component6);
		return this;
	}

	/**
	 * Set the component7 (Name and Address).
	 * @param component7 the component7 to set
	 */
	public Field24G setComponent7(String component7) {
		setComponent(7, component7);
		return this;
	}

   
	/**
	 * Returns the field's name composed by the field number and the letter option (if any)
	 * @return the static value of Field24G.NAME
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
	public static Field24G get(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return null;
		}
		final Tag t = block.getTagByName(NAME);
		if (t == null) {
			return null;
		}
		return new Field24G(t) ;
	}
	
	/**
	 * Gets the first instance of Field24G in the given message.
	 * @param msg may be empty or null
	 * @return null if not found or msg is empty or null
	 * @see #get(SwiftTagListBlock)
	 */
	public static Field24G get(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return null;
		return get(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field24G in the given message
	 * an empty list is returned if none found.
	 * @param msg may be empty or null in which case an empty list is returned
	 * @see #getAll(SwiftTagListBlock)
	 */ 
	public static List<Field24G> getAll(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return java.util.Collections.emptyList();
		return getAll(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field24G from the given block
	 * an empty list is returned if none found.
	 *
	 * @param block may be empty or null in which case an empty list is returned 
	 */ 
	public static List<Field24G> getAll(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return java.util.Collections.emptyList();
		}
		final Tag[] arr = block.getTagsByName(NAME);
		if (arr != null && arr.length > 0) {
			final List<Field24G> result = new ArrayList<>(arr.length);
			for (final Tag f : arr) {
				result.add( new Field24G(f));
			}
			return result;
		}
		return java.util.Collections.emptyList();
	}
	
	/**
	 * Returns a specific line from the field's value.<br>
	 *
	 * @see MultiLineField#getLine(int)
	 * @param line a reference to a specific line in the field, first line being 1
	 * @return line content or null if not present or if line number is above the expected
	 * @since 7.7
	 */
	public String getLine(int line) {
		return getLine(line, 0);
	}
	
	/**
	 * Returns a specific line from the field's value.<br>
	 * 
	 * @see MultiLineField#getLine(int, int)
	 * @param line a reference to a specific line in the field, first line being 1
	 * @param offset an optional component number used as offset when counting lines
	 * @return line content or null if not present or if line number is above the expected
	 * @since 7.7
	 */
	public String getLine(int line, int offset) {
		Field24G cp = newInstance(this);
		return getLine(cp, line, null, offset);
	}
	
	/**
	 * Returns the field value split into lines.<br>
	 *
	 * @see MultiLineField#getLines()
	 * @return lines content or empty list if field's value is empty
	 * @since 7.7
	 */
	public List<String> getLines() {
		return SwiftParseUtils.getLines(getValue());
	}

	/**
	 * Returns the field value starting at the offset component, split into lines.<br>
	 *
	 * @see MultiLineField#getLines(int)
	 * @param offset an optional component number used as offset when counting lines
	 * @return found lines or empty list if lines are not present or the offset is invalid
	 * @since 7.7
	 */
	public List<String> getLines(int offset) {
		Field24G cp = newInstance(this);
		return SwiftParseUtils.getLines(getLine(cp, null, null, offset));
	}
	
	/**
	 * Returns a specific subset of lines from the field's value, given a range.<br>
	 *
	 * @see MultiLineField#getLinesBetween(int, int )
	 * @param start a reference to a specific line in the field, first line being 1
	 * @param end a reference to a specific line in the field, must be greater than start
	 * @return found lines or empty list if value is empty
	 * @since 7.7
	 */
	public List<String> getLinesBetween(int start, int end) {
		return getLinesBetween(start, end, 0);
	}

	/**
	 * Returns a specific subset of lines from the field's value, starting at the offset component.<br>
	 *
	 * @see MultiLineField#getLinesBetween(int start, int end, int offset)
	 * @param start a reference to a specific line in the field, first line being 1
	 * @param end a reference to a specific line in the field, must be greater than start
	 * @param offset an optional component number used as offset when counting lines
	 * @return found lines or empty list if lines are not present or the offset is invalid
	 * @since 7.7
	 */
	public List<String> getLinesBetween(int start, int end, int offset) {
		Field24G cp = newInstance(this);
		return SwiftParseUtils.getLines(getLine(cp, start, end, offset));
	}

	/**
	 * This method deserializes the JSON data into a Field24G object.
	 * @param json JSON structure including tuples with label and value for all field components
	 * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
	 * @since 7.10.3
	 * @see Field#fromJson(String)
	 */
	public static Field24G fromJson(final String json) {
		Field24G field = new Field24G();
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = (JsonObject) parser.parse(json);
		if (jsonObject.get("code") != null) {
			field.setComponent1(jsonObject.get("code").getAsString());
		}
		if (jsonObject.get("nameandAddress") != null) {
			field.setComponent2(jsonObject.get("nameandAddress").getAsString());
		}
		if (jsonObject.get("nameandAddress2") != null) {
			field.setComponent3(jsonObject.get("nameandAddress2").getAsString());
		}
		if (jsonObject.get("nameandAddress3") != null) {
			field.setComponent4(jsonObject.get("nameandAddress3").getAsString());
		}
		if (jsonObject.get("nameandAddress4") != null) {
			field.setComponent5(jsonObject.get("nameandAddress4").getAsString());
		}
		if (jsonObject.get("nameandAddress5") != null) {
			field.setComponent6(jsonObject.get("nameandAddress5").getAsString());
		}
		if (jsonObject.get("nameandAddress6") != null) {
			field.setComponent7(jsonObject.get("nameandAddress6").getAsString());
		}
		return field;
	}
	

}
