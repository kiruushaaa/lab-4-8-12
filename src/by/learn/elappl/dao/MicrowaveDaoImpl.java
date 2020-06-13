package by.learn.elappl.dao;

import by.learn.elappl.appliances.Microwave;
import by.learn.elappl.connector.Connector;
import by.learn.elappl.exceptions.WrongOvenModeException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MicrowaveDaoImpl implements MicrowaveDao {
    //language=SQL
    private static final String SELECT_ALL_MICROWAVES = "SELECT power, turned, mode FROM Appliance WHERE name = 'Microwave'";

    @Override
    public List<Microwave> findAllMicrowaves() {
        List<Microwave> appliances = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = Connector.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_MICROWAVES);
            while (resultSet.next()) {
                Microwave microwave = new Microwave();
                microwave.setPower(resultSet.getInt("power"));
                microwave.setTurned(resultSet.getBoolean("turned"));
                microwave.setMode(resultSet.getInt("mode"));
                appliances.add(microwave);
            }
        } catch (SQLException | WrongOvenModeException | IOException ex) {
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
