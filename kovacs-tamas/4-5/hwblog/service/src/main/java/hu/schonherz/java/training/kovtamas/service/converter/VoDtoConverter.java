package hu.schonherz.java.training.kovtamas.service.converter;

import hu.schonherz.java.training.kovtamas.data.dto.UserDto;
import hu.schonherz.java.training.kovtamas.serviceapi.user.vo.Dates;
import hu.schonherz.java.training.kovtamas.serviceapi.user.vo.Login;
import hu.schonherz.java.training.kovtamas.serviceapi.user.vo.Location;
import hu.schonherz.java.training.kovtamas.serviceapi.user.vo.Name;
import hu.schonherz.java.training.kovtamas.serviceapi.user.vo.UserVo;

public class VoDtoConverter {

    public static UserVo convert(UserDto dto) {
        Name name = new Name();
        name.setFirstName(dto.getFirstName());
        name.setLastName(dto.getLastName());

        Location location = new Location();
        location.setPostCode(dto.getPostCode());
        location.setCity(dto.getCity());
        location.setStreet(dto.getStreet());

        Login login = new Login();
        login.setUsername(dto.getUsername());
        login.setPassword(dto.getPassword());

        Dates dates = new Dates();
        java.util.Date utilDob = convert(dto.getDob());
        java.util.Date utilReg = convert(dto.getRegistered());
        dates.setBirth(utilDob);
        dates.setRegistration(utilReg);

        UserVo vo = new UserVo();
        vo.setName(name);
        vo.setLocation(location);
        vo.setLogin(login);
        vo.setDates(dates);

        vo.setId(dto.getId());
        vo.setGender(dto.getGender());
        vo.setPhone(dto.getPhone());
        vo.setEmail(dto.getEmail());
        vo.setPicUrl(dto.getPicUrl());

        return vo;
    }

    public static UserDto convert(UserVo vo) {
        UserDto dto = new UserDto();
        dto.setId(vo.getId());
        dto.setGender(vo.getGender());
        dto.setPhone(vo.getPhone());
        dto.setEmail(vo.getEmail());
        dto.setPicUrl(vo.getPicUrl());

        dto.setFirstName(vo.getName().getFirstName());
        dto.setLastName(vo.getName().getLastName());

        dto.setPostCode(vo.getLocation().getPostCode());
        dto.setCity(vo.getLocation().getCity());
        dto.setStreet(vo.getLocation().getStreet());

        dto.setUsername(vo.getLogin().getUsername());
        dto.setPassword(vo.getLogin().getPassword());

        java.sql.Date sqlDob = convert(vo.getDates().getBirth());
        java.sql.Date sqlReg = convert(vo.getDates().getRegistration());
        dto.setDob(sqlDob);
        dto.setRegistered(sqlReg);

        return dto;
    }

    @SuppressWarnings("deprecation")
    private static java.util.Date convert(java.sql.Date sqlDate) {
        java.util.Date utilDate = new java.util.Date(sqlDate.getYear(), sqlDate.getMonth(), sqlDate.getDay());
//        utilDate.setHours(sqlDate.getHours());
//        utilDate.setMinutes(sqlDate.getMinutes());
//        utilDate.setSeconds(sqlDate.getSeconds());

        return utilDate;
    }

    @SuppressWarnings("deprecation")
    private static java.sql.Date convert(java.util.Date utilDate) {
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getYear(), utilDate.getMonth(), utilDate.getDay());
//        sqlDate.setHours(utilDate.getHours());
//        sqlDate.setMinutes(utilDate.getMinutes());
//        sqlDate.setSeconds(utilDate.getSeconds());

        return sqlDate;
    }

}
