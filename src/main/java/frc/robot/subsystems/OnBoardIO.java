/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * This class represents the onboard IO of the Romi
 * reference robot. This includes the pushbuttons and
 * LEDs.
 * 
 * DIO 0 - Button A (input only)
 * DIO 1 - Button B (input) or Green LED (output)
 * DIO 2 - Button C (input) or Red LED (output)
 * DIO 3 - Yellow LED (output only)
 */
public class OnBoardIO extends SubsystemBase {
  private DigitalInput m_buttonA = new DigitalInput(0);
  private DigitalOutput m_yellowLed = new DigitalOutput(3);

  // DIO 1
  private DigitalInput m_buttonB = null;
  private DigitalOutput m_greenLed = null;

  // DIO 2
  private DigitalInput m_buttonC = null;
  private DigitalOutput m_redLed = null;

  public static enum ChannelMode {
    INPUT,
    OUTPUT
  };

  /**
   * 
   * @param dio1 Mode for DIO 1 (input = Button B, output = green LED)
   * @param dio2 Mode for DIO 2 (input = Button C, output = red LED)
   */
  public OnBoardIO(ChannelMode dio1, ChannelMode dio2) {
    if (dio1 == ChannelMode.INPUT) {
      m_buttonB = new DigitalInput(1);
    }
    else {
      m_greenLed = new DigitalOutput(1);
    }

    if (dio2 == ChannelMode.INPUT) {
      m_buttonC = new DigitalInput(2);
    }
    else {
      m_redLed = new DigitalOutput(2);
    }
  }

  public boolean getButtonAPressed() {
    return m_buttonA.get();
  }

  public boolean getButtonBPressed() {
    if (m_buttonB != null) {
      return m_buttonB.get();
    }

    System.err.println("Button B was not configured");
    return false;
  }

  public boolean getButtonCPressed() {
    if (m_buttonC != null) {
      return m_buttonC.get();
    }

    System.err.println("Button C was not configured");
    return false;
  }

  public void setGreenLed(boolean value) {
    if (m_greenLed != null) {
      m_greenLed.set(value);
    }
    else {
      System.err.println("Green LED was not configured");
    }
  }

  public void setRedLed(boolean value) {
    if (m_redLed != null) {
      m_redLed.set(value);
    }
    else {
      System.err.println("Red LED was not configured");
    }
  }

  public void setYellowLed(boolean value) {
    m_yellowLed.set(value);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
