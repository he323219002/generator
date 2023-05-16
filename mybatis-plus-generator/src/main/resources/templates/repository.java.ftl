package ${package.Repository};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Repository;

/**
* @author ${author}
* @since ${date}
*/
@Repository
public class ${table.repositoryName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> {

}
