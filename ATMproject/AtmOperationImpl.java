package ATMproject;

import java.util.HashMap;
import java.util.Map;

public class AtmOperationImpl implements AtmOperationInterf {
    ATM atm = new ATM();
    @SuppressWarnings({ "rawtypes", "unchecked" })
    Map<Double, String> ministmt = new HashMap();

    @Override
    public void viewBalance() {
        System.out.println("Available Balance is : " + atm.getBalance());
    }

    @Override
    public void withdrawAmount(double withdrawAmount) {
        if (withdrawAmount % 5 == 0) {
            if (withdrawAmount <= atm.getBalance()) {
                ministmt.put(withdrawAmount, "Amount Withdrawn");
                System.out.println("Collect the Cash " + withdrawAmount);
                atm.setBalance(atm.getBalance() - withdrawAmount);
                viewBalance();
            } else {
                System.out.println("Insufficent Balance..");
                viewBalance();
            }
        }
    }

    @Override
    public void depositAmount(double depositAmount) {
        ministmt.put(depositAmount, "Amount Deposited");

        System.out.println(depositAmount + " deposited successfully.");
        atm.setBalance(atm.getBalance() + depositAmount);
        viewBalance();
    }

    @Override
    public void viewMiniStatements() {
        for (Map.Entry<Double, String> m : ministmt.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }

}

