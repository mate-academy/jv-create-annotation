package services;

import dao.BetDao;
import dao.BetDaoImpl;

public class BetService {
    private BetDao betDao;

    public BetDao getBetDao() {
        return new BetDaoImpl();
    }
}
