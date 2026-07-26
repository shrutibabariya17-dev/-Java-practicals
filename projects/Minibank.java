public class Minibank {

    static class Account {
        private int accountNumber;
        private String ownerName;
        private double balance;

        public Account(int accountNumber, String ownerName, double balance) {
            this.accountNumber = accountNumber;
            this.ownerName = ownerName;
            this.balance = balance;
        }

        @Override
        public String toString() {
            return "Account No: " + accountNumber +
                   ", Owner: " + ownerName +
                   ", Balance: " + balance;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Account)) return false;
            Account a = (Account) o;
            return accountNumber == a.accountNumber;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(accountNumber);
        }
    }

    static class Customer implements Cloneable {
        private String name;
        private Address address;

        public Customer(String name, Address address) {
            this.name = name;
            this.address = address;
        }

        public Address getAddress() {
            return address;
        }

        @Override
        public Customer clone() {
            try {
                return (Customer) super.clone();
            } catch (CloneNotSupportedException e) {
                return null;
            }
        }

        public static class Address {
            private String line;
            private String city;
            private String pincode;

            public Address(String line, String city, String pincode) {
                this.line = line;
                this.city = city;
                this.pincode = pincode;
            }

            public String getLine() {
                return line;
            }

            public String getCity() {
                return city;
            }

            public String getPincode() {
                return pincode;
            }
        }
    }

    public static void main(String[] args) {

        Account a1 = new Account(101, "Shruti", 5000);
        Account a2 = new Account(101, "Niyati", 8000);

        System.out.println(a1);
        System.out.println(a2);

        System.out.println("Accounts Equal: " + a1.equals(a2));

        Object obj = a1;
        if (obj instanceof Account) {
            System.out.println("obj is an Account");
        }

        Customer.Address address = new Customer.Address(
                "ABC Society",
                "Anand",
                "388001");

        Customer c1 = new Customer("Shruti", address);
        Customer c2 = c1.clone();

        System.out.println("Customer City: " + c2.getAddress().getCity());
    }
}


