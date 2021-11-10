package com.tnicacio.gumball.services;

import com.tnicacio.gumball.dtos.GumballMachineDto;
import com.tnicacio.gumball.entities.enums.StateType;
import com.tnicacio.gumball.states.*;
import org.springframework.stereotype.Service;

@Service
public class StateService {

    public State getStateFrom(GumballMachineDto gumballMachine) {
        if (gumballMachine.getStateType() == StateType.NO_CREDIT) {
            return new NoCreditState(gumballMachine);
        }
        if (gumballMachine.getStateType() == StateType.WITH_CREDIT) {
            return new WithCreditState(gumballMachine);
        }
        if (gumballMachine.getStateType() == StateType.SOLD) {
            return new SoldState(gumballMachine);
        }
        if (gumballMachine.getStateType() == StateType.SOLD_OUT) {
            return new SoldOutState(gumballMachine);
        }
        if (gumballMachine.getStateType() == StateType.WINNER) {
            return new WinnerState(gumballMachine);
        }
        return null;
    }

}
