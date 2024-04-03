package org.example;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper instance = Mappers.getMapper(PersonMapper.class);

    //@Mapping(source="firstname", target="firstname")
    //@Mapping(source="surname", target="surname")
    @InheritConfiguration
    PersonRequest personToPersonRequest(Person person);

    @InheritInverseConfiguration
    Person personRequestToPerson(PersonRequest person);
}
