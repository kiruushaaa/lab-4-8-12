package by.learn.elappl.dao;

import by.learn.elappl.connector.Connector;

import java.io.IOException;
import java.sql.*;

public class ApplianceDaoImpl implements ApplianceDao {
    //language=SQL
    private static final String COUNT_POWER = "SELECT SUM(power) AS sum FROM Appliance WHERE turned = ?";
    //language=SQL
    private static final String TURN_ON_OFF = "UPDATE Appliance SET turned = IF(turned = 1, 0, 1) WHERE id = ?";
    //language=SQL
    private static final String FIND_BY_POWER = "SELECT id, name, power FROM Appliance WHERE power >= ?";
    //language=SQL
    private static final String SELECT_ALL_SORTED_POWER = "SELECT * FROM Appliance ORDER BY power";

    @Override
    public boolean turnOnOff(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = Connector.getConnection();
            statement = connection.prepareStatement(TURN_ON_OFF);
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            close(statement);
            close(connection);
        }
    }

    @Override
    public long countPower() {
        long power = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = Connector.getConnection();
            statement = connection.prepareStatement(COUNT_POWER);
            statement.setInt(1, 1);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                power = resultSet.getLong("sum");
            }
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
        return power;
    }

    @Override
    public boolean findRowsByPower(int power) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = Connector.getConnection();
            statement = connection.prepareStatement(FIND_BY_POWER);
            statement.setInt(1, power);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                System.out.println("id: " + result.getInt(1)
                        + " - " + result.getString(2)
                        + ", power=" + result.getInt(3));
            }
            return true;
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            close(statement);
            close(connection);
        }
    }

    @Override
    public boolean selectAllSorted() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = Connector.getConnection();
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(SELECT_ALL_SORTED_POWER);
            while (result.next()) {
                System.out.println("id: " + result.getInt(1)
                        + " - " + result.getString(2)
                        + ", power=" + result.getInt(3));
            }
            return true;
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            close(statement);
            close(connection);
        }
    }
}
