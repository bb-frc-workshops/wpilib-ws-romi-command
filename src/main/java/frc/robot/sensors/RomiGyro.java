package frc.robot.sensors;

public class RomiGyro {
    private SimDevice m_simDevice;
    private SimDouble m_simRateX;
    private SimDouble m_simRateY;
    private SimDouble m_simRateZ;
    private SimDouble m_simAngleX;
    private SimDouble m_simAngleY;
    private SimDouble m_simAngleZ;

    public RomiGyro() {
        m_simDevice = SimDevice.create("Gyro:RomiGyro");
        if (m_simDevice != null) {
            m_simRateX = m_simDevice.createDouble("rateX", false, 0.0);
            m_simRateY = m_simDevice.createDouble("rateY", false, 0.0);
            m_simRateZ = m_simDevice.createDouble("rateZ", false, 0.0);

            m_simAngleX = m_simDevice.createDouble("angleX", false, 0.0);
            m_simAngleY = m_simDevice.createDouble("angleY", false, 0.0);
            m_simAngleZ = m_simDevice.createDouble("angleZ", false, 0.0);
        }
    }

    double getRateX() {
        return m_simRateX.get();
    }

    double getRateY() {
        return m_simRateY.get();
    }

    double getRateZ() {
        return m_simRateZ.get();
    }

    double getAngleX() {
        return m_simAngleX.get();
    }

    double getAngleY() {
        return m_simAngleY.get();
    }

    double getAngleZ() {
        return m_simAngleZ.get();
    }
}