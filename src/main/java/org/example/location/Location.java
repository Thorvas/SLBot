package org.example.location;

import lombok.Data;
import org.example.monster.Monster;
import org.example.node.Node;

import java.util.List;

@Data
public class Location {

    private List<Node> passages;
    private List<Monster> monsters;
    private String locationName;

}
