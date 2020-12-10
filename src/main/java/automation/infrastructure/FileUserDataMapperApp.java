package automation.infrastructure;

import automation.infrastructure.Data.FileUserDataMapper;

public class FileUserDataMapperApp {
    public static void main(String[] args) {
        FileUserDataMapper udm = new FileUserDataMapper();
//        System.out.println(udm.users());

        System.out.println(udm.getUserByUserName("user5"));
    }
}
