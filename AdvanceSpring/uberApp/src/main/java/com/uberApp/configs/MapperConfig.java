package com.uberApp.configs;

import com.uberApp.dto.PointDto;
import com.uberApp.utils.GeometryUtil;
import org.locationtech.jts.geom.Point;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
//add modelmapper dependency
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
       //convert this type of that type
        mapper.typeMap(PointDto.class, Point.class).setConverter(context -> {
            PointDto pointDto = context.getSource();
            return GeometryUtil.createPoint(pointDto);//to mention these points are coordinate
            // of earth we have GeometryFactory
            // thats how we create pointDto to pointClass
        });

        mapper.typeMap(Point.class, PointDto.class).setConverter(context -> {
            Point point = context.getSource();
            double coordinates[] = {
                    point.getX(),
                    point.getY()
            };
            return new PointDto(coordinates);
        });


        return mapper;
    }
}
