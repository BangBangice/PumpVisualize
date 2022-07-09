package com.jnu.pumpvisualize.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="measure")
public class Measure {
    @Id
    @GeneratedValue
    Long id;

    @Column(name="order")
    Integer order_;
    String number;
    String name;
    String comment;
    Integer component_id;


}
