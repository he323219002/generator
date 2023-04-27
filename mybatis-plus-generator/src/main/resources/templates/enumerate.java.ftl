package ${package.Enum};

import com.baomidou.mybatisplus.annotation.IEnum;





/**
* @author ${author}
* @since ${date}
*/
public enum ${table.domainEntityName}${curEnumField.columnName}Enum implements IEnum<Integer>{
<#list curEnumField.enumerateMapList as enumMap>
    ${enumMap.enumVal}(${enumMap.enumCode},"${enumMap.enumDesc}"),
</#list>
    ;

    private final Integer code;
    private final String message;

    ${table.domainEntityName}${curEnumField.columnName}Enum(Integer code, String message) {
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
