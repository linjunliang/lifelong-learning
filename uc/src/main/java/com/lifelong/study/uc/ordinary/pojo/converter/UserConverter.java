package com.lifelong.study.uc.ordinary.pojo.converter;

import com.lifelong.study.uc.ordinary.pojo.dto.UserDTO;
import com.lifelong.study.uc.ordinary.pojo.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 用户MapStruct映射mapper
 *
 * @author: lin
 * @date: 2023/3/6
 */
@Mapper
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    /**
     * entity 转 dto
     * @param entity entity
     * @return {@link UserDTO}
     */
    UserDTO entity2Dto(UserEntity entity);

    /**
     * list entity 转 dto
     * @param entities list
     * @return DtoList
     */
    List<UserDTO> entity2Dto(List<UserEntity> entities);

}
