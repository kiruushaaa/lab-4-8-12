package by.learn.elappl.dao;

import by.learn.elappl.appliances.Iron;

import java.util.List;

public interface IronDao extends ApplianceDao<Iron> {
    List<Iron> findAllIrons();
}
