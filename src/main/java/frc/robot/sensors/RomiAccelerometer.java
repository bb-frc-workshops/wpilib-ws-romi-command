package frc.robot.sensors;

public class RomiAccelerometer {
    private SimDevice m_simDevice;
    private SimDouble m_simAccelX;
    private SimDouble m_simAccelY;
    private SimDouble m_simAccelZ;
    private SimDouble m_simAccelSensitivity;

    public RomiAccelerometer(int sensitivity) {
        m_simDevice = SimDevice.create("Accel:BuiltInAccelerometer");
        if (m_simDevice != null) {
            System.out.println("Creating SimValues");
            m_simAccelX = m_simDevice.createDouble("x", false, 0.0);
            m_simAccelY = m_simDevice.createDouble("y", false, 0.0);
            m_simAccelZ = m_simDevice.createDouble("z", false, 0.0);
            m_simAccelSensitivity = m_simDevice.createDouble("range", true, sensitivity);
        }
    }

    public double getX() {
        return m_simAccelX.get();
    }

    public double getY() {
        return m_simAccelY.get();
    }

    public double getZ() {
        return m_simAccelZ.get();
    }
}