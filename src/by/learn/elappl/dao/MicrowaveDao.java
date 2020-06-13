package by.learn.elappl.dao;

import by.learn.elappl.appliances.Microwave;

import java.util.List;

public interface MicrowaveDao extends ApplianceDao<Microwave> {
    List<Microwave> findAllMicrowaves();
}
