package com.cydeo.converter;

import com.cydeo.dto.RoleDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.impl.RoleServiceImpl;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component // we are injecting RoleService
@ConfigurationPropertiesBinding // spring checks the configuration classes
public class RoleDTOConverter implements Converter<String, RoleDTO> {
    // convert string to roleDto
    // "1" to Manager
    // roleDto object is inside the map

    private final RoleService rs;

    public RoleDTOConverter(RoleService rs) {
        this.rs = rs;
    }

    @Override
    public RoleDTO convert(String source) {

        return rs.findById(Long.parseLong(source));
    }



}
