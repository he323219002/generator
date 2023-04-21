package ${package.Enum};
<#list table.importPackages as pkg>
import ${pkg};
</#list>

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;


/**
* @author ${author}
* @since ${date}
*/
public enum ${table.entityName}${curEnumField.columnName}Enum implements IEnum<Integer>{
<#list curEnumField.enumerateMapList as enumMap>
    ${enumMap.enumVal}(${enumMap.enumCode},"${enumMap.enumDesc}"),
</#list>
    ;

    ${table.entityName}${curEnumField.columnName}Enum(Integer code, String message) {
    this.code = code;
    this.message = message;
    }

    public Integer code() {
    return this.code;
    }

    public String message() {
    return this.message;
    }


    @Override
    public Integer getValue() {
    return this.code;
    }
}
