package tuan2.bai4_Account_Module_2;

import java.util.Scanner;

public class TestAcc {
    static Scanner sn = new Scanner(System.in); // Khởi tạo scanner một lần
    static DSAccount accountList;

    public static String inputString(String s) { //trả về một chuỗi
        System.out.print(s);
        return sn.nextLine();
    }

    public static int inputInt(String s) { //trả về một số nguyên
        System.out.print(s);
        while (!sn.hasNextInt()) {
            System.out.println("Vui lòng nhập số nguyên.");
            sn.next(); // Xóa bỏ giá trị không hợp lệ
            System.out.print(s);
        }
        int result = sn.nextInt();
        sn.nextLine(); // Thêm dòng này để xóa newline sau khi nhập số
        return result;
    }


    public static long inputLong(String s) { //trả về một số nguyên dài 
        System.out.print(s);
        while (!sn.hasNextLong()) {
            System.out.println("Vui lòng nhập số nguyên.");
            sn.next(); // Xóa b�? giá trị không hợp lệ
            System.out.print(s);
        }
        return sn.nextLong();
    }

    public static double inputDouble(String s) { // trả về một số thực 
        System.out.print(s);
        while (!sn.hasNextDouble()) {
            System.out.println("Vui lòng nhập số thực.");
            sn.next(); // Xóa b�? giá trị không hợp lệ
            System.out.print(s);
        }
        return sn.nextDouble();
    }

    public static void createDefaultAccountList() throws Exception { // thêm danh sách v
        Account[] accounts = {
            new Account(1017020607, "Lê Hoàng Long", 50000),
            new Account(1017046087, "Nguyễn Văn Nam", 5000000),
            new Account(1017061096, "Tran Van Thang", 1000000),
            new Account(1017030708, "Bao Bao", 300000)
        };

        for (Account account : accounts) {
            accountList.add(account);
        }
    }

    public static void displayTitle() {
        String title = String.format("\t%-7s %15s %30s %15s", "STT", "Số Tài Khoản", "H�? và Tên", "Số Dư");
        System.out.println(title);
    }

    public static void displayAccountList() {
        displayTitle();
        Account[] allAccount = accountList.getAllAccounts(); //Lấy toàn bộ mảng Account[] từ accountList.
        for (int i = 0; i < accountList.getSize(); i++) { //uyệt qua tất cả các tài khoản trong danh sách và in ra thông tin của từng tài khoản.
            System.out.printf("\t%-7d ", i + 1); // Đánh số thứ tự cho các tài khoản trong danh sách bắt đầu từ 1.
            System.out.println(allAccount[i]);
        }
    }

    public static Account createAccount() {
        long accountNumber = inputLong("Nhập số tài khoản: ");
        while (accountList.isExistingAccNumber(accountNumber)) { 
            System.out.println("Số tài khoản đã tồn tại.");
            accountNumber = inputLong("Vui lòng nhập lại số tài khoản: ");
        }

        String name = inputString("Nhập tên tài khoản: ");
        double balance = inputDouble("Nhập số tiền khởi tạo cho tài khoản: ");
        return new Account(accountNumber, name, balance);
    }

    public static void update() throws Exception {
        long accountNumber = inputLong("Nhập số tài khoản: ");
        Account acc = accountList.getAccountByAccNumber(accountNumber); // Lấy đối tượng Account theo số tài khoản.
        if (acc != null) {
            System.out.println("Trước khi sửa:");
            System.out.printf("%-20s %-30s %-20s\n", "Số tài khoản", "H�? và tên", "Số Dư");
            System.out.println(acc);
            String name = inputString("Nhập tên tài khoản mới: ");
            double balance = inputDouble("Nhập số dư mới: ");
            acc.setName(name);
            acc.setBalance(balance);
            accountList.update(acc);
        } else {
            System.out.println("Không tìm thấy tài khoản.");
        }
    }

    public static int menu() {
        String[] options = {
            "In danh sách tài khoản",
            "Thêm tài khoản",
            "Sửa danh sách tài khoản",
            "Xoá tài khoản theo số tài khoản"
        };

        System.out.println("\n\t********************************");
        System.out.println("\t** Chương Trình Quản lý tài khoản **");
        for (int i = 0; i < options.length; i++)
            System.out.printf("\t* %d. %s%n", i + 1, options[i]);
        System.out.println("\t********************************");
        return inputInt("Ch�?n: ");
    }

    public static void main(String[] args) throws Exception {
        accountList = new DSAccount();
        int choice;
        do {
            choice = menu();
            switch (choice) {
                case 1:
                    // Chỉ hiển thị danh sách tài khoản
                	createDefaultAccountList();
                    displayAccountList();
                    
                    break;
                case 2:
                    // Tạo tài khoản mới và thêm vào danh sách
                    Account acc = createAccount();
                    accountList.add(acc);
                    break;
                case 3:
                    // Cập nhật thông tin tài khoản
                    update();
                    break;
                case 4:
                    // Implement delete functionality here if needed
                    break;
                case 12:
                    // Kết thúc chương trình
                    break;
                default:
                    System.out.println("Lựa ch�?n không hợp lệ. Vui lòng ch�?n lại.");
                    break;
            }
        } while (choice != 12);

        System.out.println("�?ã Kết Thúc Chương Trình!!!");
        sn.close();
    }
}
