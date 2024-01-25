package com.myblog.myblog11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test3 {
    public static void main(String[] args) {
        List<Login> x=Arrays.asList
                (new Login("sam","12345"),
                        (new Login("mike","test")),
                        (new Login("adam","testing"))
                        );
        List<LoginDto> dtos = x.stream().map(login -> mapToDto(login)).collect(Collectors.toList());
        System.out.println(dtos);
    }

  static LoginDto mapToDto(Login login){
       LoginDto dto = new LoginDto();
       dto.setUserName(login.getUserName());
       dto.setPassword(login.getPassword());
       return dto;
    }
}
