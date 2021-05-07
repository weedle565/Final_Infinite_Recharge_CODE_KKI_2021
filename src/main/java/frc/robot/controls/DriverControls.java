/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.controls;

import frc.robot.Robot;
/**
 * Add your docs here.
 */
public class DriverControls extends PlaystationController{

	public DriverControls(int port) {
        super(0);
        //Driver port is 0
    }
    
    private void arcadeDrive(Robot robot){
        double stickX = playstation.getRawAxis(0);
        double stickY = playstation.getRawAxis(1);

        robot.getDrivetrain().arcadeDiffDrive(stickX, stickY);        
    }

    @Override
    public void giveCommands(Robot robot){
        super.giveCommands(robot);
        arcadeDrive(robot);
    }

    //Changed from original, requested from Brandon
    @Override
    public void pressL2(Robot robot){
      //Ball gets pulled into the robot
      robot.getIntake().takeIn(-0.85);
    }
    
    @Override
    public void pressShare(Robot robot){
      //Ball gets pushed out of the robot (just in case something gets stuck)
      robot.getIntake().intakeOut(0.5);
    }

    @Override
    public void pressSquare(Robot robot){
      //Pulls the intake up
      robot.getIntake().intakeArmUp(-0.8);
    }
    
    @Override
    public void pressCross(Robot robot){
      //Pulls the intake down
      robot.getIntake().intakeArmDown(0.6);
    }

    @Override
    public void nothingPressed(Robot robot){
      //Makes sure nothing moves during the game
      robot.getIntake().intakeArmUp(0);
      robot.getIntake().intakeArmDown(0);
      robot.getIntake().takeIn(0);
      robot.getIntake().intakeOut(0);
    }

}
