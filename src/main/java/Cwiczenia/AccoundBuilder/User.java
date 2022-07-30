package Cwiczenia.AccoundBuilder;

public class User {
    private String name;
    private String surname;
    private String mail;

    private User(UserBuilder userBuilder){
        this.name = userBuilder.name;
        this.surname = userBuilder.surname;
        this.mail = userBuilder.mail;
    }



    public static class UserBuilder {
        private String name;
        private String surname;
        private String mail;

        public User build() {
            return new User(this);
        }

        public UserBuilder buildName(String name){
            this.name = name;
            return this;
        }

        public UserBuilder buildSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public UserBuilder buildMail(String mail) {
            this.mail = mail;
            return this;
        }

    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
