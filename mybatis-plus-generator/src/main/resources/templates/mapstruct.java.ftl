package ${package.MapStruct};

import org.mapstruct.Mapper;
import ${package.Dto}.${table.dtoName};
import ${package.DomainEntity}.${table.domainEntityName};
import ${package.Entity}.${table.entityName};

/**
* @author ${author}
* @since ${date}
*/
@Mapper(componentModel = "spring")
public interface ${table.mapstructName} {

    ${table.domainEntityName} toEntity(${table.dtoName} dto);

    ${table.entityName} toDbo(${table.domainEntityName} entity);
}
