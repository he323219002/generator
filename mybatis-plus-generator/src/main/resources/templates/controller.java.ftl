package ${package.Controller};


import org.springframework.web.bind.annotation.RestController;

<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!}
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@RestController
public class ${table.controllerName} {


}

