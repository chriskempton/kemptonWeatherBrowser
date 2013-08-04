//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.08.03 at 06:54:06 PM EDT 
//


package gov.weather.graphical.dwml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for operational-modeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="operational-modeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="official"/>
 *     &lt;enumeration value="developmental"/>
 *     &lt;enumeration value="experimental"/>
 *     &lt;enumeration value="test"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "operational-modeType")
@XmlEnum
public enum OperationalModeType {

    @XmlEnumValue("official")
    OFFICIAL("official"),
    @XmlEnumValue("developmental")
    DEVELOPMENTAL("developmental"),
    @XmlEnumValue("experimental")
    EXPERIMENTAL("experimental"),
    @XmlEnumValue("test")
    TEST("test");
    private final String value;

    OperationalModeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OperationalModeType fromValue(String v) {
        for (OperationalModeType c: OperationalModeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
