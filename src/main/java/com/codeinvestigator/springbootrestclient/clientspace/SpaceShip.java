package com.codeinvestigator.springbootrestclient.clientspace;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpaceShip {
    private String name;
    private Integer crew;
}
