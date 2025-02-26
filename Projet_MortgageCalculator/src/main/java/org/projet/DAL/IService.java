package org.projet.DAL;

import org.projet.BLL.Model.Bank;
import org.projet.BLL.Model.Service;

import java.util.List;
import java.util.Set;

public interface IService {
    public List<Bank> fetchBanksByService(String nameService);
}
