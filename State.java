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
public class State {

    static int capacityOne=5, capacityTwo=7, goalForOne;
    int currentOne, currentTwo;

    public static void initializeProblem(int capacityOne, int capacityTwo, int goalForOne) {
        State.capacityOne = capacityOne;
        State.capacityTwo = capacityTwo;
        State.goalForOne = goalForOne;
    }

    public State(int currentOne, int currentTwo) {
        this.currentOne = currentOne;
        this.currentTwo = currentTwo;
    }

    private int remainingOne() {
        return State.capacityOne - this.currentOne;
    }

    private int remainingTwo() {
        return State.capacityTwo - this.currentTwo;
    }

    public State fromOneToTwo() {
        int newOne;
        int newTwo;

        if (this.currentOne > remainingTwo()) {
            newOne = currentOne - remainingTwo();
            newTwo = State.capacityTwo;
        } else {
            newOne = 0;
            newTwo = currentTwo + currentOne;
        }

        return new State(newOne, newTwo);
    }

    public State fromTwoToOne() {
        int newOne;
        int newTwo;

        if (this.currentTwo > remainingOne()) {
            newTwo = currentTwo - remainingOne();
            newOne = State.capacityOne;
        } else {
            newTwo = 0;
            newOne = currentOne + currentTwo;
        }

        return new State(newOne, newTwo);
    }

    public State emptyOne() {
        return new State(0, currentTwo);
    }

    public State emptyTwo() {
        return new State(currentOne, 0);
    }

    public State fillOne() {
        return new State(State.capacityOne, currentTwo);
    }

    public State fillTwo() {
        return new State(currentOne, State.capacityTwo);
    }
    public State EmptyBoth() { return new State(0, currentTwo:0); }

    public State FillBoth() {
        return new State(State.capacityOne, State.capacityTwo);
    }



    public boolean goalTest() {
        if (this.currentOne == goalForOne) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.currentOne;
        hash = 37 * hash + this.currentTwo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final State other = (State) obj;
        if (this.currentOne != other.currentOne) {
            return false;
        }
        if (this.currentTwo != other.currentTwo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "State{" + "currentOne=" + currentOne + ", currentTwo=" + currentTwo + '}';
    }

}
