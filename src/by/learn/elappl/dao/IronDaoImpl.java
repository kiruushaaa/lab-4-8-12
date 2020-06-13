package by.learn.elappl.dao;

import by.learn.elappl.appliances.Iron;
import by.learn.elappl.connector.Connector;
import by.learn.elappl.exceptions.WrongHeatException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IronDaoImpl implements IronDao {
    //language=SQL
    private static final String SELECT_ALL_IRONS = "SELECT power, turned, maxHeat FROM Appliance WHERE name = 'Iron'";

    @Override
    public List<Iron> findAllIrons() {
        List<Iron> appliances = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = connection = Connector.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_IRONS);
            while (resultSet.next()) {
                Iron microwave = new Iron();
                microwave.setPower(resultSet.getInt("power"));
                microwave.setTurned(resultSet.getBoolean("turned"));
                microwave.setMaxHeat(resultSet.getInt("maxHeat"));
                appliances.add(microwave);
            }
        } catch (SQLException | WrongHeatException | IOException ex) {
            ex.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
        return appliances;
    }

    @Override
    public boolean turnOnOff(int id) {
        return new ApplianceDaoImpl().turnOnOff(id);
    }

    @Override
    public long countPower() {
        return 0;
    }

    @Override
    public boolean findRowsByPower(int power) {
        return false;
    }

    @Override
    public boolean selectAllSorted() {
        return false;
    }
}
