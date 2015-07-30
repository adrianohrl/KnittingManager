/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.paycheck;

/**
 *
 * @author adrianohrl
 */
public class ScheduleException extends Exception {

    public ScheduleException() {
        super("Schedule Exception");
    }

    public ScheduleException(String message) {
        super(message);
    }
    
}
