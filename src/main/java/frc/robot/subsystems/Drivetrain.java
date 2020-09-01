/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  // The Romi has the left and right motors set to
  // PWM channels 0 and 1 respectively
  private Spark m_leftMotor = new Spark(0);
  private Spark m_rightMotor = new Spark(1);

  // The Romi has onboard encoders that are hardcoded
  // to use DIO pins 4/5 and 6/7 for the left and right
  private Encoder m_leftEncoder = new Encoder(4, 5);
  private Encoder m_rightEncoder = new Encoder(6, 7);
  
  // Set up the differential drive controller
  private DifferentialDrive m_diffDrive = new DifferentialDrive(m_leftMotor, m_rightMotor);
  
  /**
   * Creates a new Drivetrain.
   */
  public Drivetrain() {

  }

  public void arcadeDrive(double xSpeed, double zRotate) {
    m_diffDrive.arcadeDrive(xSpeed, zRotate);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
