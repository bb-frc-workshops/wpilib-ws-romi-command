/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TeleopArcadeDrive extends CommandBase {
  private Drivetrain m_drivetrain;
  private Supplier<Double> m_xSpeedSupplier;
  private Supplier<Double> m_zRotateSupplier;

  /**
   * Creates a new TeleopArcadeDrive.
   */
  public TeleopArcadeDrive(Drivetrain drivetrain, Supplier<Double> xSpeedSupplier, Supplier<Double> zRotateSuppplier) {
    m_drivetrain = drivetrain;
    m_xSpeedSupplier = xSpeedSupplier;
    m_zRotateSupplier = zRotateSuppplier;

    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.arcadeDrive(m_xSpeedSupplier.get(), m_zRotateSupplier.get());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
