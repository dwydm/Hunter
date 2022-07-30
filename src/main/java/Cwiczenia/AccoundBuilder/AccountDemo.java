package Cwiczenia.AccoundBuilder;

public class AccountDemo {
    public static void main(String[] args) {

        User user1 = new User.UserBuilder()
                .buildName("John")
                .buildSurname("T")
                .buildMail("someMail")
                .build();

        User user2 = new User.UserBuilder()
                .buildName("Sonya")
                .buildMail("otherMail")
                .build();

        User user3 = new User.UserBuilder()
                .buildSurname("Shepard")
                .buildMail("js@alliance.zxc")
                .build();

        User user4 = new User.UserBuilder()
                .buildMail("47@acs.com")
                .build();

        User user5 = new User.UserBuilder()
                .build();

        User[] userArr = {user1,user2,user3,user4,user5};

        for (User user : userArr) {
            System.out.println(user);
        }
    }

}
