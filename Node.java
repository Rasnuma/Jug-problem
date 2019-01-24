/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheJugProblem;

/**
 *
 * @author Sajid
 */
public class Node {

    int cost;
    State state;
    Node parent;

    public Node(State state, int cost, Node parent) {
        this.state = state;
        this.cost = cost;
        this.parent = parent;
    }

}
