package com.telegram.bot.models.dtos;

import com.telegram.bot.models.City;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CityVO {
    int id;
    String name;
    String info;

    public static CityVO fromEntity(City city) {
        return new CityVO(city.getId(), city.getName(), city.getInformation());
    }
}
