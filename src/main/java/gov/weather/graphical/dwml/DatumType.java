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
 * <p>Java class for datumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="datumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="surface"/>
 *     &lt;enumeration value="mean sea level"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "datumType")
@XmlEnum
public enum DatumType {

    @XmlEnumValue("surface")
    SURFACE("surface"),
    @XmlEnumValue("mean sea level")
    MEAN_SEA_LEVEL("mean sea level");
    private final String value;

    DatumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DatumType fromValue(String v) {
        for (DatumType c: DatumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
