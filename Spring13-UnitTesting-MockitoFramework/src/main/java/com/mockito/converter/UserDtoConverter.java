package com.mockito.converter;


import com.mockito.dto.UserDTO;
import com.mockito.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class UserDtoConverter implements Converter<String, UserDTO> {

    @Autowired
    UserService userService;

    @Override
    public UserDTO convert(String source) {
        return userService.findByUserName(source);
    }
}
