/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.commands.autonomousCommands;

import com.badrobot.commands.DriveStraightForward;
import com.badrobot.commands.InjectFrisbee;
import com.badrobot.commands.Shoot;
import com.badrobot.commands.Turn;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Kyle Compton
 */
public class DriveForwardTurnShoot extends CommandGroup 
{
    
    public DriveForwardTurnShoot() 
    {
        int time = (int) SmartDashboard.getNumber("DriveForwardTurnShoot Time");
        int angle = (int) SmartDashboard.getNumber("DriveForwardTurnShoot Angle");
        double distance = 3; // yards
        
        addSequential(new DriveStraightForward(time));
        addParallel(new Shoot(time + 5, 1.0));
        addSequential(new Turn(angle));
        //time, power
        addSequential(new InjectFrisbee(4));
    }
}
