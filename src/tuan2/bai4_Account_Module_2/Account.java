package tuan2.bai4_Account_Module_2;

public class Account {
	private long numOfAcc;
	private String name;
	private double balance;
	private static final double RATE = 0.035;
	
	public long getNumOfAcc() {
		return numOfAcc;
	}
	public void setNumOfAcc(long numOfAcc) {
		this.numOfAcc = numOfAcc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Account() {
		super();
	}
	public Account(long numOfAcc, String name, double balance) {
		super();
		this.setNumOfAcc(numOfAcc);
		this.setName(name);
		this.setBalance(balance);
	}
	public Account(long numOfAcc, String name) {
		super();
		this.setNumOfAcc(numOfAcc);
		this.setName(name);
		this.balance = 50000;
		
	}
	@Override
	public String toString() {
		String str = String.format("%-20d %-30s %-20.2f", getNumOfAcc(), getName(), getBalance());
		return str;
	}
	public void deposit(double amount) throws Exception {  //Phương thức này dùng để gửi tiền vào tài khoản.
        if (amount > 0) {  //amount số tiền muốn gửi vào tài khoản.
            balance += amount;
        } else {
            throw new Exception ("Số tiền gửi không hợp lệ. Vui lòng thử lại.");
        }
    }

	public void withdraw(double amount, double withdrawalFee) throws Exception{ //Phương thức này dùng để rút tiền từ tài khoản, có tính phí rút tiền.
        if (amount > 0) { 
            if (amount + withdrawalFee <= balance) { //amount số tiền muốn rút, withdrawalFee Phí rút tiền.
                balance -= (amount + withdrawalFee);
            } else {
                throw new Exception("Số dư không đủ. Vui lòng thử lại.");
            }
        } else {
            throw new Exception("Số ti�?n rút không hợp lệ. Vui lòng thử lại.");
        }
    }
	public void maturity() {  //Phương thức này dùng để tính toán số tiền lãi và cộng vào số dư tài khoản khi tài khoản đến hạn.
		this.balance += this.balance*RATE;
	}
	public void transfer(Account destinationAccount, double amount) throws Exception {  //Phương thức này dùng để chuyển tiền từ tài khoản hiện tại sang tài khoản khác.
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                destinationAccount.deposit(amount); //destinationAccount tài khoản nhận tiền
            } else {
                throw new Exception("Số dư không đủ. Vui lòng thử lại.");
            }
        } else {
        	throw new Exception("Số chuyển không hợp lệ. Vui lòng thử lại.");
        }
    }
}
