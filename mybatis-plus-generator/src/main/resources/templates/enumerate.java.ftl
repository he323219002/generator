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
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ${table.entityName}${curEnumField.columnName}Enum{
<#list curEnumField.enumerateMapList as enumMap>
    ${enumMap.enumVal}(${enumMap.enumCode},"${enumMap.enumDesc}"),
</#list>
    ;

    @EnumValue
    private Integer code;
    @JsonValue
    private String desc;
}
