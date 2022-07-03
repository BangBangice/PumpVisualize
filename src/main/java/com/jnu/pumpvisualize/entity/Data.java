package com.jnu.pumpvisualize.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="data")
public class Data {
    @Id
    @GeneratedValue
    String datetime;

    Float WCW101MV;
    Float WCW103MV;
    Float WCW105MV;
    Float WCW111MT;
    Float WCW121MT;
    Float WCW131MT;
    Float WCW113MT;
    Float WCW123MT;
    Float WCW133MT;
    Float WCW101MT;
    Float WCW103MT;
    Float WCW105MT;
    Float WCW107MT;
    Float WCW141MT;
    Float WCW143MT;
    Float WCW107MV;
    Float WCW109MV;
    Float WCW115MT;
    Float WCW117MT;
    Float WCW125MT;
    Float WCW145MT;
    Float WCW147MT;
    Float WCW151MT;
    Float WCW153MT;
    Float WCW101SN;
    Float WCW109SD;
    Float WCL001MP;
}
