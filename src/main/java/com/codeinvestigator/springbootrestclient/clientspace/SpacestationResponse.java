package com.codeinvestigator.springbootrestclient.clientspace;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpacestationResponse {
    private List<SpaceShip> dockedships;
    private String status;
}
