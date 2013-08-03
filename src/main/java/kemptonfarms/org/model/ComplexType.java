package kemptonfarms.org.model;

import java.util.*;
public class ComplexType {
  private String prop1 = null;
  private Integer prop2 = null;
  private Boolean prop3 = null;
  private Float prop4 = null;
  private List<String> prop5 = new ArrayList<String>();
  public String getProp1() {
    return prop1;
  }
  public void setProp1(String prop1) {
    this.prop1 = prop1;
  }
  public ComplexType withProp1(String prop1) {
    this.prop1 = prop1;
    return this;
  } 

  public Integer getProp2() {
    return prop2;
  }
  public void setProp2(Integer prop2) {
    this.prop2 = prop2;
  }
  public ComplexType withProp2(Integer prop2) {
    this.prop2 = prop2;
    return this;
  } 

  public Boolean getProp3() {
    return prop3;
  }
  public void setProp3(Boolean prop3) {
    this.prop3 = prop3;
  }
  public ComplexType withProp3(Boolean prop3) {
    this.prop3 = prop3;
    return this;
  } 

  public Float getProp4() {
    return prop4;
  }
  public void setProp4(Float prop4) {
    this.prop4 = prop4;
  }
  public ComplexType withProp4(Float prop4) {
    this.prop4 = prop4;
    return this;
  } 

  public List<String> getProp5() {
    return prop5;
  }
  public void setProp5(List<String> prop5) {
    this.prop5 = prop5;
  }
  public ComplexType withProp5(List<String> prop5) {
    this.prop5 = prop5;
    return this;
  } 

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ComplexType {\n");
    sb.append("  prop1: ").append(prop1).append("\n");
    sb.append("  prop2: ").append(prop2).append("\n");
    sb.append("  prop3: ").append(prop3).append("\n");
    sb.append("  prop4: ").append(prop4).append("\n");
    sb.append("  prop5: ").append(prop5).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

