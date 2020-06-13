package by.learn.elappl.dao;

import by.learn.elappl.appliances.ElectricalAppliance;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public interface ApplianceDao<T extends ElectricalAppliance> {
    long countPower();
    boolean turnOnOff(int id);
    boolean findRowsByPower(int power);
    boolean selectAllSorted();

    default void close(Statement statement) {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
    }

    default void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
