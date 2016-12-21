package hu.schonherz.java.training.kovtamas.dbsupplier;

public class DataBaseSupplier {
}

/*
This class is not supposed to be used. It was only used once with the purpose of putting the
given data from the example.txt into the freshly created database.
Since the 'id' of the USER table has 'serial' type, using this class again would result in
duplicated records, which only differ in their column of 'id'.

The USER table was created with the following command:
CREATE TABLE blog.USER (
    ID SERIAL PRIMARY KEY,
    GENDER VARCHAR(6) NOT NULL,

    FIRST_NAME VARCHAR(25) NOT NULL,
    LAST_NAME VARCHAR(25) NOT NULL,

    STREET VARCHAR(30) DEFAULT NULL,
    CITY VARCHAR(30) NOT NULL,
    POST_CODE INTEGER NOT NULL,

    EMAIL VARCHAR(30) NOT NULL,

    USERNAME VARCHAR(30) UNIQUE NOT NULL,
    PASSWORD VARCHAR(30) NOT NULL,

    DATE_OF_BIRTH DATE NOT NULL,
    REGISTERED DATE NOT NULL,

    PHONE VARCHAR(12) DEFAULT NULL,

    PIC_URL VARCHAR
);
 */
//public class DataBaseSupplier {

/*
    The main method could not have been started as a single file because of it's dependencies.
    Instead, I started it from the index.jsp using the following code as the first part of the <body>:
        <%
            DataBaseSupplier.main(null);
        %>

    This scriplet is now removed from the index.jsp
 */
//    public static void main(String[] args) {
//        UserService service = new UserServiceImpl();
//        List<User> givenUsers = service.findAllUser();
//        List<UserDto> dtos = new ArrayList<>();
//        givenUsers.forEach(usr -> dtos.add(convertUserToDto(usr)));
//
//        GenericDao dao = new UserDao();
//        dtos.forEach(dto -> dao.save(dto));
//    }
//
//    private static UserDto convertUserToDto(User user) {
//        UserDto dto = new UserDto();
//        dto.setUsername(user.getLogin().getUsername());
//        dto.setPassword(user.getLogin().getPassword());
//        dto.setGender(user.getGender());
//        dto.setFirstName(user.getName().getFirst());
//        dto.setLastName(user.getName().getLast());
//        dto.setPostCode(user.getLocation().getPostcode());
//        dto.setCity(user.getLocation().getCity());
//        dto.setStreet(user.getLocation().getStreet());
//        dto.setEmail(user.getEmail());
//        dto.setPhone(user.getPhone());
//        dto.setPicUrl(user.getPicture().getMedium());
//
//        DateFormat df = new SimpleDateFormat("yyyy-MM-DD");
//        String dobDateString = user.getDob().split(" ")[0];
//        String regDateString = user.getRegistered().split(" ")[0];
//        try {
//            java.util.Date utilDob = df.parse(dobDateString);
//            java.util.Date utilReg = df.parse(regDateString);
//            Date sqlDob = new Date(utilDob.getYear(), utilDob.getMonth(), utilDob.getDay());
//            Date sqlReg = new Date(utilReg.getYear(), utilReg.getMonth(), utilReg.getDay());
//            dto.setDob(sqlDob);
//            dto.setRegistered(sqlReg);
//        } catch (ParseException pe) {
//            throw new RuntimeException("Could not parse date of birth and registration date!");
//        }
//
//        return dto;
//    }
//
//}
