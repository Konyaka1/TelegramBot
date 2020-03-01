package com.telegram.bot.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(of = {"id"})
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "\"CITY\"")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "\"ID\"")
    Integer id;

    @Column(name = "\"NAME\"")
    String name;

    @Column(name = "\"INFORMATION\"")
    String information;

    public City(String name, String  info){
        this.name = name;
        this.information = info;
    }
}
