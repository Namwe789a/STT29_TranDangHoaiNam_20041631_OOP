	package tuan2.bai4_Account_Module_2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DSAccount {
	private Account[] accounts;
	public int size = 0;

	public DSAccount() {
		super();
		this.accounts = new Account[1];
	}

	public DSAccount(int initCapacity) {
		this.accounts = new Account[initCapacity];
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Account[] getAllAccounts() {
		return accounts;
	}

	public boolean isExistingAccNumber(long accountNumber) { //iểm tra xem một số tài khoản (accountNumber) đã tồn tại trong danh sách chưa.
		for (int i = 0; i < size; i++)
			if (accountNumber == accounts[i].getNumOfAcc())
				return true;
		return false;
	}

	public Account[] copyArray(Account[] arr, int length) {  // Sao chép mảng arr sang một mảng mới với kích thước length
		Account[] newArr = new Account[length];
		for (int i = 0; i < size; i++)
			newArr[i] = arr[i];
		return newArr;
	}
	public void add(Account acc) throws Exception {
	    if (acc == null) {
	        throw new IllegalArgumentException("Tài khoản không được là null");
	    }

	    if (isExistingAccNumber(acc.getNumOfAcc())) { //Kiểm tra xem số tài khoản có tồn tại không. Nếu có, ném ra một ngoại lệ.
	        throw new Exception("Số tài khoản này đã tồn tại.");
	    }

	    if (size == accounts.length) {
	        accounts = copyArray(accounts, size * 2); //Nếu mảng accounts đã đầy, gọi copyArray để tăng gấp đôi kích thước mảng.
	    }
	    accounts[size++] = acc; //Thêm tài khoản vào mảng và tăng biến size.

//	    // Save to file
//	    try (FileWriter fw = new FileWriter("accounts.txt", true);
//	         BufferedWriter bw = new BufferedWriter(fw)) {
//	        bw.write(acc.getNumOfAcc() + "," + acc.getName() + "," + acc.getBalance());
//	        bw.newLine();
//	    } catch (IOException e) {
//	        throw new Exception("Error writing to file: " + e.getMessage());
//	    }
	}

	/*
	 * public void add(Account acc) throws Exception { if
	 * (!isExistingAccNumber(acc.getNumOfAcc())) { if (size == accounts.length)
	 * accounts = copyArray(accounts, size * 2); accounts[size++] = acc; } else
	 * throw new Exception("Số tài khoản này đã tồn tại.");
	 * 
	 * }
	 */

	public int indexOfAccount(long accountNumber) { //Trả về chỉ số của tài khoản trong mảng nếu tìm thấy, ngược lại trả về -1
		for (int i = 0; i < size; i++)
			if (accounts[i].getNumOfAcc() == accountNumber)
				return i; 
		return -1;
	}
 
	public Account getAccountByAccNumber(long accountNumber) {  //Trả về đối tượng Account theo số tài khoản, nếu không tìm thấy trả về null.
		int index = indexOfAccount(accountNumber);
		return (index != -1) ? accounts[index] : null;
	}

	public void delete(long accountNumber) throws Exception {
		int i = indexOfAccount(accountNumber);
		if (i != -1) {
			for (; i < size - 1; i++)
				accounts[i] = accounts[i + 1];
			size--;
		} else
			throw new Exception("Không tìm thấy tài khoản");
	}

	public void update(Account acc) throws Exception {
		int index = indexOfAccount(acc.getNumOfAcc()); //Tìm chỉ số tài khoản cần cập nhật.
		if (index != -1)
			accounts[index] = acc; //Cập nhật thông tin tài khoản mới vào vị trí tương ứng trong mảng.
		else
			throw new Exception("Không tìm thấy tài khoản");
	}

//	public Account[] sortByAccountNumber() {
//		Account[] sortedArr = copyArray(accounts, size);
//		Account temp;
//		int n = size;
//		for (int i = 0; i < n - 1; i++)
//			for (int j = 0; j < n - i - 1; j++)
//				if (sortedArr[j].getNumOfAcc() > sortedArr[j + 1].getNumOfAcc()) {
//					temp = sortedArr[j];
//					sortedArr[j] = sortedArr[j + 1];
//					sortedArr[j + 1] = temp;
//				}
//		return sortedArr;
//	}
}
