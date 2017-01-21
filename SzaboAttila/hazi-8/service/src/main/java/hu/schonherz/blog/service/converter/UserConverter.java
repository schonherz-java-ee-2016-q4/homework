package hu.schonherz.blog.service.converter;

import hu.schonherz.blog.data.domain.UserEntity;
import hu.schonherz.blog.service.api.user.vo.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UserConverter {
    public static UserVo toVO(UserEntity entity) {
        UserVo user = new UserVo();

        user.setCell(entity.getCell());
        user.setDob(entity.getDob().toString());
        user.setRegistered(entity.getRegistered().toString());
        user.setEmail(entity.getEmail());
        user.setPhone(entity.getPhone());
        user.setGender("f".equals(entity.getGender()) ? "female" : "male");
        user.setRole(entity.getRole());
        user.setActive(entity.isActive());

        LocationVo loc = new LocationVo();
        loc.setCity(entity.getCity());
        loc.setPostcode(entity.getPostcode());
        loc.setState(entity.getState());
        loc.setStreet(entity.getStreet());
        user.setLocation(loc);

        PictureVo picture = new PictureVo();
        picture.setLarge(entity.getLargeImage());
        picture.setMedium(entity.getMediumImage());
        picture.setThumbnail(entity.getThumbnailImage());
        user.setPicture(picture);

        LoginVo login = new LoginVo();
        login.setPassword(entity.getPassword());
        login.setUsername(entity.getUsername());
        user.setLogin(login);

        NameVo name = new NameVo();
        name.setFirst(entity.getFirst());
        name.setLast(entity.getLast());
        name.setTitle(entity.getTitle());
        user.setName(name);

        return user;
    }

    public static List<UserVo> toVO(List<UserEntity> entities) {
        List<UserVo> back = new ArrayList<>();
        for (UserEntity entity : entities) {
            back.add(toVO(entity));
        }
        return back;
    }

    public static UserEntity toEntity(UserVo user) throws ParseException {

        Date dob = new Date( new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(user.getDob()).getTime() );
        Date registered = new Date ( new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(user.getRegistered()).getTime() );
        return UserEntity.builder()
                .email(user.getEmail())
                .phone(user.getPhone())
                .cell(user.getCell())
                .gender("female".equals(user.getGender()) ? "f" : "m")
                .dob(dob)
                .role(user.getRole())
                .registered(registered)
                .active(user.getActive())
                .city(user.getLocation().getCity())
                .postcode(user.getLocation().getPostcode())
                .state(user.getLocation().getState())
                .street(user.getLocation().getStreet())
                .title(user.getName().getTitle())
                .first(user.getName().getFirst())
                .last(user.getName().getLast())
                .username(user.getLogin().getUsername())
                .password(user.getLogin().getPassword())
                .largeImage(user.getPicture().getLarge())
                .mediumImage(user.getPicture().getMedium())
                .thumbnailImage(user.getPicture().getThumbnail())
                .build();
    }
}
