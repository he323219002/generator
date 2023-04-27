package ${package.DomainEntity};
import com.jframe.base.Entity;
import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;
<#if (table.enumerateList?size > 0)>
import ${package.Enum}.*;
</#if>


/**
* @author ${author}
* @since ${date}
* ${domainEntity}领域模型
*/


@EqualsAndHashCode(callSuper = false)
public class ${domainEntity} extends ${superDomainEntityClass}{

<#if entitySerialVersionUID>

    private static final long serialVersionUID = 1L;
</#if>
<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>

    /**
    * ${field.comment}
    */
    <#if field.enumerate>
    private ${field.enumerateName} ${field.propertyName};
    <#else>
    private ${field.propertyType} ${field.propertyName};
    </#if>
</#list>
<#------------  END 字段循环遍历  ---------->

<#if entityColumnConstant>
    <#list table.fields as field>

    public static final String ${field.name?upper_case} = "${field.name}";
    </#list>
</#if>
<#if activeRecord>

    @Override
    public Serializable pkVal() {
    <#if keyPropertyName??>
        return this.${keyPropertyName};
    <#else>
        return null;
    </#if>
    }
</#if>
}
